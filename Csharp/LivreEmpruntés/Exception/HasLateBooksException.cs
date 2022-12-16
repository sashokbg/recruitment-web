using System;

namespace com.proxym.libraryapp.Exceptions
{
    /// <summary>
    /// This exception is thrown when a member who owns late books tries to borrow another book
    /// </summary>
    public class HasLateBooksException : Exception
    {
    }

}
