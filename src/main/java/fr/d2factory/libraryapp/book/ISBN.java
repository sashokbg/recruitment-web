package fr.d2factory.libraryapp.book;

public class ISBN {
    long isbnCode;
    int checkDigit;

    public ISBN(long isbnCode, int checkDigit) {
        this.isbnCode = isbnCode;
        this.checkDigit = checkDigit;
    }
}
