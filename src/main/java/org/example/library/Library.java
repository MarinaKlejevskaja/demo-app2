package org.example.library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        bookList.add(book);
    }

    public List<Book> getAllBooks() {
        return bookList;
    }
    public int getNumberOfBooks(){
        return bookList.size();
    }
    public Optional<Book> findBookByTitle(String title){
        return bookList.stream().filter(book -> book.getTitle().equals(title)).findFirst();
    }
    public Optional<Book> findBookWithHighestNumberOfPages(){
        return bookList.stream().max(Comparator.comparing(Book::getNumberOfPages));
    }
}
