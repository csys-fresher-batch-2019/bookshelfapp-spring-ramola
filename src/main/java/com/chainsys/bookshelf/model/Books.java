package com.chainsys.bookshelf.model;

import java.sql.Date;

public class Books {
	private int bookId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String setBookName(String bookName) {
		return this.bookName = bookName;
	}

	public int getBookVersion() {
		return bookVersion;
	}

	public void setBookVersion(int bookVersion) {
		this.bookVersion = bookVersion;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String setBookAuthor(String bookAuthor) {
		return this.bookAuthor = bookAuthor;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public String setBookLanguage(String bookLanguage) {
		return this.bookLanguage = bookLanguage;
	}

	public String getBookType() {
		return bookType;
	}

	public String setBookType(String bookType) {
		return this.bookType = bookType;
	}

	public Date getBookUploadedOn() {
		return bookUploadedOn;
	}

	public void setBookUploadedOn(Date bookUploadedOn) {
		this.bookUploadedOn = bookUploadedOn;
	}

	public int getBookRating() {
		return bookRating;
	}

	public void setBookRating(int bookRating) {
		this.bookRating = bookRating;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Date getBookPublishedDate() {
		return bookPublishedDate;
	}

	public void setBookPublishedDate(Date bookPublishedDate) {
		this.bookPublishedDate = bookPublishedDate;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public String getBookLink() {
		return bookLink;
	}

	public void setBookLink(String bookLink) {
		this.bookLink = bookLink;
	}

	private String bookName;
	private int bookVersion;
	private String bookAuthor;
	private String bookLanguage;
	private String bookType;
	private Date bookUploadedOn;
	private int bookRating;
	private String bookPublisher;
	private Date bookPublishedDate;
	private String imgLink;
	private String bookLink;

	@Override
	public String toString() {
		return "Books [bookName=" + bookName + ", bookVersion=" + bookVersion + ", bookAuthor=" + bookAuthor
				+ ", bookLanguage=" + bookLanguage + ", bookType=" + bookType + ", bookUploadedOn=" + bookUploadedOn
				+ ", bookRating=" + bookRating + ", bookPublisher=" + bookPublisher + ", bookPublishedDate="
				+ bookPublishedDate + ", imgLink=" + imgLink + ", bookLink=" + bookLink + "]";
	}

}
