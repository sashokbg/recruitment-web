using com.proxym.libraryapp.book;
using com.proxym.libraryapp.member;

namespace com.proxym.libraryapp.library
{
    /// <summary>
    /// The library class is in charge of stocking the books and managing the return delays and members
    /// 
    /// The books are available via the <seealso cref="BookRepository"/>
    /// </summary>
    public interface ILibrary
    {

        /// <summary>
        /// A member is borrowing a book from our library.
        /// </summary>
        /// <param name="isbnCode"> the isbn code of the book </param>
        /// <param name="member"> the member who is borrowing the book </param>
        /// <param name="borrowedAt"> the date when the book was borrowed
        /// </param>
        /// <returns> the book the member wishes to obtain if found </returns>
        /// <exception cref="HasLateBooksException"> in case the member has books that are late
        /// </exception>
        /// <seealso cref="com.proxym.libraryapp.book.ISBN"/>
        /// <seealso cref="Member"/>
        Book borrowBook(long isbnCode, Member member, DateOnly borrowedAt);

        /// <summary>
        /// A member returns a book to the library.
        /// We should calculate the tarif and probably charge the member
        /// </summary>
        /// <param name="book"> the <seealso cref="Book"/> they return </param>
        /// <param name="member"> the <seealso cref="Member"/> who is returning the book
        /// </param>
        /// <seealso cref="Member.payBook(int)"/>
        void returnBook(Book book, Member member);
    }

}
