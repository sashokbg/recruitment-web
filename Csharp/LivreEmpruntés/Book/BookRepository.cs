using LivreEmpruntés;
using System.Collections;
using System.Collections.Generic;

namespace fr.d2factory.libraryapp.book
{

	/// <summary>
	/// The book repository emulates a database via 2 HashMaps
	/// </summary>
	public class BookRepository
	{
        private Dictionary<Isbn, Book> availableBooks = new Dictionary<Isbn, Book>(); 
        private IDictionary<Book, DateTime> borrowedBooks = new Dictionary<Book, DateTime>(); 


        public virtual void addBooks(IList<Book> books)
        { 
            //TODO implement the missing feature
        }

		public virtual Book findBook(long isbnCode)
		{
			//TODO implement the missing feature
			return null;
		}

		public virtual void saveBookBorrow(Book book, DateTime borrowedAt)
		{
			//TODO implement the missing feature
		}

		public virtual DateTime findBorrowedBookDate(Book book)
		{
			//TODO implement the missing feature
			return  DateTime.Now;
		}
	}

}
