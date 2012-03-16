package com.ares.beans;

import java.util.ArrayList;
import java.util.List;

public class BooksBean {

	private static List<BookTO> books;

	static {
		// TODO replace this with real data source stuff.
		BookTO lotrBook = new BookTO();
		lotrBook.setId(1L);
		lotrBook.setName("Lord of the Rings");

		BookTO myNameIsRedBook = new BookTO();
		myNameIsRedBook.setId(2L);
		myNameIsRedBook.setName("My Name Is Red");

		books = new ArrayList<BookTO>();
		books.add(lotrBook);
		books.add(myNameIsRedBook);
	}

	/**
	 * Returns all the books.
	 * 
	 * @return all books
	 */
	public List<BookTO> loadBooks() {
		return books;
	}

	/**
	 * Returns a book by ID.
	 * 
	 * @param bookId
	 *            book ID
	 * @return requested book or an empty bookTO object if the book doesn't
	 *         exist
	 */
	public BookTO loadBookById(Long bookId) {
		try {
			return books.get(bookId.intValue() - 1); // Ugly, I know. But that's
			// just dummy code anyhow.
		} catch (Exception e) {
			return new BookTO();
		}
	}

}
