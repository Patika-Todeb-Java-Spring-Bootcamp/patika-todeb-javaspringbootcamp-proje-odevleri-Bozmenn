package com.berkozmen.library_automation_system.model.mapper;

import com.berkozmen.library_automation_system.model.entity.Book;
import com.berkozmen.library_automation_system.model.dto.BookDTO;
import org.springframework.validation.annotation.Validated;

@Validated
public class BookMapper {

    public static BookDTO toDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setPublishedDate(book.getPublishedDate());
        return bookDTO;
    }

    public static Book toEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setISBN(bookDTO.getISBN());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublishedDate(bookDTO.getPublishedDate());
        return book;
    }


}
