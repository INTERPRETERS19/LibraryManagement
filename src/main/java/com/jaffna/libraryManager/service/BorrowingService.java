package com.jaffna.libraryManager.service;

import com.jaffna.libraryManager.dto.BorrowRequestDTO;
import com.jaffna.libraryManager.dto.BorrowingDTO;
import com.jaffna.libraryManager.mapper.BorrowingMapper;
import com.jaffna.libraryManager.model.Book;
import com.jaffna.libraryManager.model.Borrowing;
import com.jaffna.libraryManager.model.Member;
import com.jaffna.libraryManager.repository.BookRepository;
import com.jaffna.libraryManager.repository.BorrowingRepository;
import com.jaffna.libraryManager.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {

	@Autowired
	private BorrowingRepository borrowingRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BorrowingMapper borrowingMapper;

	public List<BorrowingDTO> getBorrowings() {
		return borrowingMapper.borrowingsToBorrowingDtos(borrowingRepository.findAll());
	}

	public BorrowingDTO borrow(BorrowRequestDTO borrowRequestDTO) throws Exception {
		Book book = bookRepository.findById(borrowRequestDTO.getBookId()).orElseThrow(ResourceNotFoundException::new);
		Member member = memberRepository.findById(borrowRequestDTO.getMemberId())
				.orElseThrow(ResourceNotFoundException::new);

		if (book.getBorrowing() != null || member.getBorrowing() != null) {
			throw new Error("Bad request");
		}

		Date borrowDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(borrowDate);
		calendar.add(Calendar.DATE, 7);

		Borrowing borrowing = new Borrowing();
		borrowing.setBook(book);
		borrowing.setMember(member);
		borrowing.setBorrowDate(borrowDate);
		borrowing.setReturnDate(null);
		return borrowingMapper.borrowingToBorrwingDto(borrowingRepository.save(borrowing), true);
	}

	public BorrowingDTO updateBorrow(String borrowId, BorrowRequestDTO borrowRequestDTO) {

		Optional<Borrowing> borrowingOptional = borrowingRepository.findById(borrowId);

		if (!borrowingOptional.isPresent())
			throw new ResourceNotFoundException();

		Borrowing borrowing = borrowingMapper.borrowDtoToBorrow(borrowRequestDTO);

		borrowing.setId(borrowingOptional.get().getId());
		borrowing.setBorrowDate(borrowingOptional.get().getBorrowDate());

		return borrowingMapper.borrowingToBorrwingDto(borrowingRepository.save(borrowing), true);
	}

	public void deleteBorrowingById(String borrowId) {

		borrowingRepository.deleteById(borrowId);

	}
}
