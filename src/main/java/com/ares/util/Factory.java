package com.ares.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ares.beans.BooksBean;

/**
 * Main factory of the application.
 * 
 * @author Michal Huniewicz
 * 
 */
public final class Factory {

	private static AbstractApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
	}

	/**
	 * Returns an instance of a BooksBean.
	 * 
	 * @return BooksBean instance
	 */
	public static BooksBean getBooksBean() {
		return ctx.getBean(BooksBean.class);
	}

	/**
	 * You cannot have an instance of this class.
	 */
	private Factory() {
		throw new InstantiationError(
				"You cannot have an instance of this class.");
	}

}
