package com.biblio.enumeration;

public enum EBookFormat {
    PAPERBACK("Bìa mềm"),
    HARDCOVER("Bìa cứng");

    private final String bookFormat;

    EBookFormat(String bookFormat) {
        this.bookFormat = bookFormat;
    }

    public String getBookFormat() {
        return bookFormat;
    }
}
