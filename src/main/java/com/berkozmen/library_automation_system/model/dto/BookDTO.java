package com.berkozmen.library_automation_system.model.dto;

import lombok.Data;

@Data
public class BookDTO {

    private String title;
    private String author;
    private long ISBN;
    private String publisher;
    private String publishedDate;
    private int rating;

}