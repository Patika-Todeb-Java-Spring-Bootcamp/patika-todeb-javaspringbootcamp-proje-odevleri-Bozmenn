package com.berkozmen.library_automation_system.service;

import com.berkozmen.library_automation_system.model.dto.BookDTO;
import com.berkozmen.library_automation_system.model.entity.Book;
import com.berkozmen.library_automation_system.model.mapper.BookMapper;
import com.berkozmen.library_automation_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

   @Autowired
   private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> allBooks = bookRepository.findAll();
        return allBooks;
    }

    public Book getById(Long id){
       Optional<Book> byId = bookRepository.findById(id);
       return byId.orElseThrow(()->new RuntimeException());
    }


    public Book create(BookDTO bookDTO){
        Book book = BookMapper.toEntity(bookDTO);
        Book save = bookRepository.save(book);
        return save;

    }

    public void delete(Long id){
        getById(id);
        bookRepository.deleteById(id);
    }

    public Book update(String title, BookDTO bookDTO){
        Optional<Book> bookByTitle = bookRepository.findBookByTitle(title);
        if(!bookByTitle.isPresent()){
            throw new RuntimeException("Could not found !");
        }
        Book updatedBook = bookByTitle.get();
        if(!StringUtils.isEmpty(bookDTO.getTitle())){
            updatedBook.setTitle(bookDTO.getTitle());
        }if(!StringUtils.isEmpty(bookDTO.getAuthor())){
            updatedBook.setAuthor(bookDTO.getAuthor());
        }if(!StringUtils.isEmpty(bookDTO.getISBN())){
            updatedBook.setISBN(bookDTO.getISBN());
        }if(!StringUtils.isEmpty(bookDTO.getPublisher())){
            updatedBook.setPublisher(bookDTO.getPublisher());
        }if(!StringUtils.isEmpty(bookDTO.getPublishedDate())){
            updatedBook.setPublishedDate(bookDTO.getPublishedDate());
        }
        return bookRepository.save(updatedBook);

    }




}