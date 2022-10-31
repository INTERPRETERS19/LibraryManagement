package com.uom.candela.mapper;

import com.uom.candela.dto.BorrowRequestDTO;
import com.uom.candela.dto.BorrowingDTO;
import com.uom.candela.dto.MemberDTO;
import com.uom.candela.model.Book;
import com.uom.candela.model.Borrowing;
import com.uom.candela.model.Member;
import com.uom.candela.repository.BookRepository;
import com.uom.candela.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BorrowingMapper {

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MemberMapper memberMapper;

	public BorrowingDTO borrowingToBorrwingDto(Borrowing borrowing, boolean eager) {
		BorrowingDTO borrowingDTO = new BorrowingDTO();
		borrowingDTO.setId(borrowing.getId());

		if (eager && borrowing.getBook() != null) {
			borrowingDTO.setBook(bookMapper.bookToBookDto(borrowing.getBook()));
		}

		if (eager && borrowing.getMember() != null) {
			borrowingDTO.setMember(memberMapper.memberToMemberDto(borrowing.getMember()));
		}

		borrowingDTO.setBorrowDate(borrowing.getBorrowDate());
		borrowingDTO.setReturnDate(borrowing.getReturnDate());
		return borrowingDTO;
	}

	public List<BorrowingDTO> borrowingsToBorrowingDtos(List<Borrowing> borrowings) {
		return borrowings.stream().map(borrowing -> this.borrowingToBorrwingDto(borrowing, true))
				.collect(Collectors.toList());
	}

	public Borrowing borrowDtoToBorrow(BorrowRequestDTO borrowRequestDTO) {

		Borrowing borrowing = new Borrowing();
		Optional<Member> memberOptional = memberRepository.findById(borrowRequestDTO.getMemberId());
		Optional<Book> bookOptional = bookRepository.findById(borrowRequestDTO.getBookId());

		if (!memberOptional.isPresent())
			throw new ResourceNotFoundException();
		if (!bookOptional.isPresent())
			throw new ResourceNotFoundException();

		bookOptional.get().setAvailability(true);
		borrowing.setBook(bookOptional.get());
		borrowing.setReturnDate(null);
		borrowing.setMember(memberOptional.get());

		if (borrowRequestDTO.isReturnOrnot()) {

			Date returnedDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(returnedDate);
			calendar.add(Calendar.DATE, 7);
			borrowing.setReturnDate(calendar.getTime());

		}

		return borrowing;
	}
}
