using System;

namespace fr.d2factory.libraryapp.library
{
	/// <summary>
	/// This exception is thrown when a member who owns late books tries to borrow another book
	/// </summary>
	public class HasLateBooksException : Exception
	{
	}

}