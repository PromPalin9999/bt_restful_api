package com.cybersoft.restfulapi.service;


import com.cybersoft.restfulapi.dto.response.BookResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<BookResponseDTO> books = new ArrayList<>();

    public BookService() {
        add(1L, "Đắc nhân tâm", "Dale Carnegie");
        add(2L, "Làm đĩ", "Vũ Trọng Phụng");
        add(3L, "Nhà Giả kim", "Paulo Coelho");
        add(4L, "Clean Code", "Robert C. Martin");
    }

    public void add(Long id, String bookName, String author) {
        BookResponseDTO book = new BookResponseDTO();

        book.setId(id);
        book.setBookName(bookName);
        book.setAuthor(author);
        books.add(book);
    }

    public List<BookResponseDTO> searchByAuthor(String author) {
        return books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).toList();
    }

}
