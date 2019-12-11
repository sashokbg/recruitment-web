package fr.d2factory.libraryapp.library;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.book.BookRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Do not forget to consult the README.md :)
 */
public class LibraryTest {
    private Library library ;
    private BookRepository bookRepository;
    private static List<Book> books;


    @BeforeEach
    void setup() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        File booksJson = new File("src/test/resources/books.json");
        books = mapper.readValue(booksJson, new TypeReference<List<Book>>() {
        });
    }

    @Test
    void member_can_borrow_a_book_if_book_is_available(){
        Assertions.fail("Implement me");
    }

    @Test
    void borrowed_book_is_no_longer_available(){
        Assertions.fail("Implement me");
    }

    @Test
    void residents_are_taxed_10cents_for_each_day_they_keep_a_book(){
        Assertions.fail("Implement me");
    }

    @Test
    void students_pay_10_cents_the_first_30days(){
        Assertions.fail("Implement me");
    }

    @Test
    void students_in_1st_year_are_not_taxed_for_the_first_15days(){
        Assertions.fail("Implement me");
    }
    
    @Test
    void residents_pay_20cents_for_each_day_they_keep_a_book_after_the_initial_60days(){
        Assertions.fail("Implement me");
    }

    @Test
    void members_cannot_borrow_book_if_they_have_late_books(){
        Assertions.fail("Implement me");
    }
}
