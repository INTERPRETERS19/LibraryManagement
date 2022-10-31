package com.jaffna.libraryManager.dto;

public class BookDTO {
    private String id;
    private String name;
    private String isbn;
    private String author;
    private boolean availability;

    private BorrowingDTO borrowing;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BorrowingDTO getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(BorrowingDTO borrowing) {
        this.borrowing = borrowing;
    }

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
    
}
