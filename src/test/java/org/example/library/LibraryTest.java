package org.example.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibraryTest {
    @Mock
    Book book1;
    @Mock
    Book book2;
    @InjectMocks
    Library library;

    @Test
    public void getNumberOfBooks_shouldReturnCorrectNumber_whenBooksAreAdded() {
        mockBooksAddedToLibrary();
        assertThat(library.getNumberOfBooks()).isEqualTo(2);
    }

    @Test
    public void getNumberOfBooks_shouldReturnZero_whenBooksAreNotAdded() {
        assertThat(library.getNumberOfBooks()).isEqualTo(0);
    }

    @Test
    public void getAllBooks_shouldReturnAllBooks_whenBooksAdded() {
        mockBooksAddedToLibrary();
        assertThat(library.getAllBooks()).containsExactly(book1, book2);
    }

    @Test
    public void getAllBooks_shouldReturnEmptyList_whenBooksNotAdded() {
        assertThat(library.getAllBooks()).isEmpty();
    }

    @Test
    public void findBookByTitle_shouldReturnOptionalBook_whenTitleIsFoundInBookList() {
        mockBooksAddedToLibrary();
        mockBookGetTitle();
        Optional<Book> actual = library.findBookByTitle("Book 2");
        assertThat(actual).isPresent();
    }

    @Test
    public void findBookByTitle_shouldReturnOptionalEmpty_whenTitleIsNotFoundInBookList() {
        mockBooksAddedToLibrary();
        mockBookGetTitle();
        Optional<Book> actual = library.findBookByTitle("Book 3");
        assertThat(actual).isEmpty();
    }

    @Test
    public void findBookByTitle_shouldReturnOptionalEmpty_whenBookListIsEmpty() {
        Optional<Book> actual = library.findBookByTitle("Book 3");
        assertThat(actual).isEmpty();
    }

    @Test
    public void findBookWithHighestNumberOfPages_shouldReturnOptionalBook_whenTitleIsFoundInBookList() {
        library.addBook(book1);
        Optional<Book> actual = library.findBookWithHighestNumberOfPages();
        assertThat(actual).isPresent();
    }

    @Test
    public void findBookWithHighestNumberOfPages_shouldReturnOptionalEmpty_whenBookListIsEmpty() {
        Optional<Book> actual = library.findBookWithHighestNumberOfPages();
        assertThat(actual).isEmpty();
    }

    private void mockBooksAddedToLibrary() {
        library.addBook(book1);
        library.addBook(book2);
    }

    private void mockBookGetTitle() {
        when(book1.getTitle()).thenReturn("Book 1");
        when(book2.getTitle()).thenReturn("Book 2");
    }
}