package com.uom.candela.service;

import com.uom.candela.dto.BookDTO;
import com.uom.candela.mapper.BookMapper;
import com.uom.candela.model.Book;
import com.uom.candela.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookDTO createBook(BookDTO bookDTO) {
        bookDTO.setId(null);
        
        Book book = bookRepository.save(bookMapper.bookDtoToBook(bookDTO));
        return bookMapper.bookToBookDto(book);
    }

    public BookDTO getBookById(String id) {
        return bookRepository.findById(id)
                .map(book -> bookMapper.bookToBookDto(book))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public List<BookDTO> getAllBooks() {
        return bookMapper.booksToBookDtos(bookRepository.findAll());
    }

    public BookDTO updateBook(String id, BookDTO bookDTO) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) throw new ResourceNotFoundException();

        Book book = bookMapper.bookDtoToBook(bookDTO);
        book.setId(bookOptional.get().getId());
        return bookMapper.bookToBookDto(bookRepository.save(book));
    }

    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }
}
