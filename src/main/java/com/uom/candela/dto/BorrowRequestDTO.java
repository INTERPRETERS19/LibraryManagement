package com.uom.candela.dto;

public class BorrowRequestDTO {
    private String bookId;
    private String memberId;
    private boolean returnOrnot;


	public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    public boolean isReturnOrnot() {
		return returnOrnot;
	}

	public void setReturnOrnot(boolean returnOrnot) {
		this.returnOrnot = returnOrnot;
	}

}
