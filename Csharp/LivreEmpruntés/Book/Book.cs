namespace fr.d2factory.libraryapp.book
{
	/// <summary>
	/// A simple representation of a book
	/// </summary>
	public class Book
	{
        public Book(string title, string author, Isbn isbn)
        {
            Title = title;
            Author = author;
            Isbn = isbn;
        }

        public string Title { get; protected set; } 
        public string Author { get; protected set; } 
        public Isbn Isbn { get; protected set; } 
         
	}

}
