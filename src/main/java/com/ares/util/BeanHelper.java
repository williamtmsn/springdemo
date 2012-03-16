package com.ares.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.ares.beans.BooksBean;

public class BeanHelper {

	ApplicationContext context;
	 
    private static BeanHelper beanHelper;
 
    private BeanHelper() {
    	context = ContextLoader.getCurrentWebApplicationContext();
    }
   
    public static synchronized BeanHelper getInstance() {
    	if (null == beanHelper) {
    		beanHelper = new BeanHelper();
    	}
    	return beanHelper;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException();
    }
    
    /**
	 * Returns an instance of a BooksBean.
	 * 
	 * @return BooksBean instance
	 */
	public BooksBean getBooksBean() {
		return (BooksBean) context.getBean("booksBean");
	}

}
