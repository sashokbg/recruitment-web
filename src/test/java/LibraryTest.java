
import com.entretien.entities.*;
import com.entretien.entities.abstracts.Member;
import com.entretien.entities.enums.Profil;
import com.entretien.repositories.impl.BookRepository;
import com.entretien.services.Library;
import com.entretien.services.impl.LibraryManagementSystem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.entretien.exceptions.HasLateBooksException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LibraryTest {

    private final BookRepository bookRepository = new BookRepository();
    private final Library library = new LibraryManagementSystem(bookRepository);
    private static List<Book> books = new ArrayList<>();
    public static final String STUDENT_ID = UUID.randomUUID().toString();
    public static final String RESEDENT_ID = UUID.randomUUID().toString();

    @BeforeEach
    void setup() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File booksJson = new File("src/test/resources/books.json");
        books = mapper.readValue(booksJson, new TypeReference<List<Book>>() {
        });
        bookRepository.addBooks(books);
    }

    @Test
    void whenMemberBorrowsAvailableBook_thenBookIsBorrowed() {
        // Given
        Member member = new StudentMember(STUDENT_ID, "Jeff", "Michel", 20.0f, Profil.STUDENT);

        // When
        Book book = library.borrowBook(46578964513L, member, LocalDate.now());

        // Then
        Assertions.assertNotNull(book);
    }

    @Test
    void whenBookIsBorrowed_thenItIsNoLongerAvailable() {
        // Given
        Member member1 = new StudentMember(STUDENT_ID, "Jeff", "Jeff", 20.0f, Profil.STUDENT);
        Member member2 = new ResidentMember(RESEDENT_ID, "ALI", "ABDALLAH", 30.0f, Profil.RESIDENT);

        // When
        Book bookAvailable = library.borrowBook(46578964513L, member1, LocalDate.now());

        // Then
        Assertions.assertNotNull(bookAvailable);
        Assertions.assertThrows(HasLateBooksException.class, () -> library.borrowBook(46578964513L, member2, LocalDate.now()));
    }

    @Test
    void whenResidentsReturnBook_thenTheyAreTaxedForLateReturn() {
        // Given
        Member member = new ResidentMember(STUDENT_ID, "Jeff", "Michel", 20.0f, Profil.RESIDENT);
        LocalDate dateBorrowed = LocalDate.now().minus(10, ChronoUnit.DAYS);

        // When
        Book book = library.borrowBook(46578964513L, member, dateBorrowed);
        library.returnBook(book, member);

        // Then
        Assertions.assertEquals(19f, member.getWallet());
    }

    @Test
    void whenStudentsReturnBookInFirst30Days_thenTheyPay10Cents() {
        // Given
        Member member = new StudentMember(STUDENT_ID, "Jeff", "Michel", 20.0f, Profil.STUDENT);
        LocalDate dateBorrowed = LocalDate.now().minus(30, ChronoUnit.DAYS);

        // When
        Book book = library.borrowBook(46578964513L, member, dateBorrowed);
        library.returnBook(book, member);

        // Then
        Assertions.assertEquals(17f, member.getWallet());
    }

    @Test
    void whenFirstYearStudentsReturnBookInFirst15Days_thenTheyAreNotTaxed() {
        // Given
        Member member = new StudentMember(STUDENT_ID, "Jeff", "Michel", 20.0f, Profil.STUDENT_1ST_YEAR);
        LocalDate dateBorrowed = LocalDate.now().minus(27, ChronoUnit.DAYS);

        // When
        Book book = library.borrowBook(46578964513L, member, dateBorrowed);
        library.returnBook(book, member);

        // Then
        Assertions.assertEquals(18.8f, member.getWallet());
    }

    @Test
    void whenResidentsKeepBookAfter60Days_thenTheyAreTaxed20Cents() {
        // Given
        Member member = new ResidentMember(RESEDENT_ID, "Jeff", "Michel", 20.0f, Profil.RESIDENT);
        member.payBook(65);

        // Then
        Assertions.assertEquals(13f, member.getWallet());
    }

    @Test
    void whenMemberHasLateBooks_thenCannotBorrowNewBook() {
        // Given
        Member member = new ResidentMember(RESEDENT_ID, "Jeff", "Michel", 20.0f, Profil.RESIDENT);
        LocalDate dateBorrowed = LocalDate.now().minus(31, ChronoUnit.DAYS);
        Book book = library.borrowBook(46578964513L, member, dateBorrowed);

        // Then
        Assertions.assertThrows(HasLateBooksException.class, () -> library.borrowBook(46578964513L, member, LocalDate.now()));
    }

}
