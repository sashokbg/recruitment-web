namespace com.proxym.libraryapp.book
{

    /// <summary>
    /// The book repository emulates a database via 2 HashMaps
    /// </summary>
    public class BookRepository
	{
        private Dictionary<Isbn, Book> availableBooks = new Dictionary<Isbn, Book>();  


        public virtual void saveAll(IList<Book> books)
        { 
            //TODO implement the missing feature
        }

		public virtual Book findBook(long isbnCode)
		{
			//TODO implement the missing feature
			return null;
		}

		public virtual void save(Book book)
		{
			//TODO implement the missing feature
		}
         
	}

}
