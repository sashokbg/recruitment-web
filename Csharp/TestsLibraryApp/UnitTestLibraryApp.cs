using com.proxym.libraryapp.book;
using com.proxym.libraryapp.library;
using System.Collections.Generic;
using Xunit;

namespace TestProjectBook
{
    public class UnitTestLibraryApp
    { 
        public ILibrary library;
        private readonly BookRepository bookRepository;
        public static List<Book> books = new(); 
        public UnitTestLibraryApp()
        {
            bookRepository=new BookRepository();
              //books = GetBooks(); 
        }
        [Fact]
        public void findBookISBN968787565445()
        {
            Assert.NotNull(bookRepository.findBook(968787565445L));
        }

        [Fact]
        public void member_can_borrow_a_book_if_book_is_available()
        {
            Assert.True(false, "Implement me."); 
        }
        [Fact]
        public void borrowed_book_is_no_longer_available()
        { 
            Assert.True(false, "Implement me."); 
        }
        [Fact]
        public void residents_are_taxed_10cents_for_each_day_they_keep_a_book()
        {
            Assert.True(false, "Implement me."); 
        }
        [Fact]
        public void students_pay_10_cents_the_first_30days()
        {
            Assert.True(false, "Implement me."); 
        }
        [Fact]
        public void students_in_1st_year_are_not_taxed_for_the_first_15days()
        {
            Assert.True(false, "Implement me."); 
        }
        [Fact]
        public void residents_pay_20cents_for_each_day_they_keep_a_book_after_the_initial_60days()
        {
            Assert.True(false, "Implement me."); 
        }
        [Fact]
        public void members_cannot_borrow_book_if_they_have_late_books()
        {
            Assert.True(false, "Implement me."); 
        }
        //public List<Book> GetBooks() => new List<Book>
        //    {
        //       new Book("Harry Potter","J.K. Rowling",  new Isbn(46578964513)),
        //        new Book("Around the world in 80 days", "Jules Verne", new Isbn(3326456467846)),
        //    new Book("Catch 22", "Joseph Heller", new Isbn(968787565445)),
        //        new Book("La peau de chagrin", "Balzac", new Isbn(465789453149))
        //    };
    }
}
