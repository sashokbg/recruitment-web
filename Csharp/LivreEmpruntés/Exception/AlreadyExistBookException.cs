namespace com.proxym.libraryapp.Exceptions
{ 
    public class AlreadyExistBookException : Exception
    {
        public AlreadyExistBookException(object key) : base($"Book Already Exist: {key}")
        {
        }
    }
}
