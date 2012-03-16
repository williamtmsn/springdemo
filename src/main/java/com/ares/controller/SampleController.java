package com.ares.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ares.beans.BookTO;
import com.ares.beans.BooksBean;
import com.ares.util.BeanHelper;

@Controller
@RequestMapping("/books")
public class SampleController {

	private static final String BOOKS = "books";
	private static final String BOOK = "book";

	/**
	 * Returns all books.
	 * 
	 * @return all books
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView handleAllBooks() {
		ModelAndView mav = new ModelAndView();

		BooksBean booksBean = BeanHelper.getInstance().getBooksBean();

		List<BookTO> booksTO = booksBean.loadBooks();

		mav.addObject(BOOKS, booksTO);

		return mav;
	}

	/**
	 * Returns a single book by ID.
	 * 
	 * @param response
	 *            response
	 * @param bookId
	 *            book ID
	 * @return single book
	 * @throws IOException 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView handleBookById(HttpServletResponse response,
			@PathVariable("id") Long bookId) throws IOException {
		ModelAndView mav = new ModelAndView();

		BooksBean booksBean = BeanHelper.getInstance().getBooksBean();

		BookTO bookTO = booksBean.loadBookById(bookId);

		/*Shop shop = new Shop();
		shop.setName(bookId.toString());
		shop.setStaffName(new String[]{"demo1", "demo2"});
		*/
		
		if (bookTO.getId() == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book "
					+ bookId + " not found.");
		}
		mav.addObject(BOOK, bookTO);

		//		mav.addObject(BOOK, shop);
		return mav;
	}
}
