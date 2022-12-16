namespace com.proxym.libraryapp.member
{ 

	/// <summary>
	/// A member is a person who can borrow and return books to a <seealso cref="Library"/>
	/// A member can be either a student or a resident
	/// </summary>
	public abstract class Member
	{ 
		/// <summary>
		/// The member should pay their books when they are returned to the library
		/// </summary>
		/// <param name="numberOfDays"> the number of days they kept the book </param>
		public abstract void payBook(int numberOfDays);
        /// <summary>
		/// An initial sum of money the member has
		/// </summary>
        public virtual float Wallet { get; set; }

	}

}
