package com.uom.candela.mapper;

import com.uom.candela.dto.BookDTO;
import com.uom.candela.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    private BorrowingMapper borrowingMapper;

    public BookDTO bookToBookDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setName(book.getName());

        if (book.getBorrowing() != null) {
            bookDTO.setBorrowing(borrowingMapper.borrowingToBorrwingDto(book.getBorrowing(), false));
            bookDTO.setAvailability(false);

        }else {
            bookDTO.setAvailability(true);  	
        }

        return bookDTO;
    }

    public Book bookDtoToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setId(bookDTO.getId());
        book.setIsbn(bookDTO.getIsbn());
        book.setAuthor(bookDTO.getAuthor());

        return book;
    }

    public List<BookDTO> booksToBookDtos(List<Book> books) {
        return books.stream().map(this::bookToBookDto).collect(Collectors.toList());
    }
}
