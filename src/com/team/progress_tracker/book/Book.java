package com.team.progress_tracker.book;

public class Book {
	
	private int book_ID;
	private String title;
	private String author;
	
	/*
	 * A simple book object.
	 */
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBook_ID() {
		return book_ID;
	}
	public void setBook_ID(int book_ID) {
		this.book_ID = book_ID;
	}

}
