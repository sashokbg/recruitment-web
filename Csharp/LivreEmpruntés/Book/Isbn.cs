namespace fr.d2factory.libraryapp.book
{
    /// <summary>
    /// 
    /// </summary>
    public class Isbn
    {
        public long IsbnCode { get; protected set; } 

		public Isbn(long isbnCode)
		{
            IsbnCode = isbnCode;
		}
	}

}
