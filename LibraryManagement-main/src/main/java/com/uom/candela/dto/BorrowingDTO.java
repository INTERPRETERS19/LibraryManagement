package com.uom.candela.dto;

import java.util.Date;

public class BorrowingDTO {
    private String id;
    private BookDTO book;
    private MemberDTO member;
    private Date borrowDate;
    private Date returnDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
