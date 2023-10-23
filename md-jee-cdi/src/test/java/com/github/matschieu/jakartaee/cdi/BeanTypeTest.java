package com.github.matschieu.jakartaee.cdi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.matschieu.WeldTest;
import com.github.matschieu.jakartaee.cdi.book.Book;
import com.github.matschieu.jakartaee.cdi.book.BookShop;
import com.github.matschieu.jakartaee.cdi.book.Business;
import com.github.matschieu.jakartaee.cdi.book.Shop;
import com.github.matschieu.jakartaee.cdi.book.TypedBookShop;
import com.github.matschieu.jakartaee.cdi.book.TypedBusiness;
import com.github.matschieu.jakartaee.cdi.book.TypedShop;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.util.TypeLiteral;
import jakarta.inject.Inject;

class BeanTypeTest extends WeldTest {

	@Inject
	private BookShop bookshop;

	@Inject
	private Business business;

	@Inject
	private Shop<Book> shop;

	@Test
	void testInjectionUsingAnnotation() {
		Assertions.assertInstanceOf(BookShop.class, bookshop);
		Assertions.assertInstanceOf(BookShop.class, business);
		Assertions.assertInstanceOf(BookShop.class, shop);
	}

	@Test
	void testInjectionUsingContainer() {
		Assertions.assertInstanceOf(BookShop.class, weld.container().select(BookShop.class).get());
		Assertions.assertInstanceOf(BookShop.class, weld.container().select(Business.class).get());
		Assertions.assertInstanceOf(BookShop.class, weld.container().select(new TypeLiteral<Shop<Book>>() {}).get());
	}

	@Inject
	private Instance<TypedBookShop> typedBookshop;

	@Inject
	private Instance<TypedBusiness> typedBusiness;

	@Inject
	private Instance<TypedShop<Book>> typedShop;

	@Test
	void testTypedInjectionUsingAnnotation() {
		// TypedBookShop has restricted type to TypedShop, it can't be injected as other type
		Assertions.assertThrows(Exception.class, () -> typedBookshop.get());
		Assertions.assertThrows(Exception.class, () -> typedBusiness.get());
		Assertions.assertInstanceOf(TypedBookShop.class, typedShop.get());
	}

}
