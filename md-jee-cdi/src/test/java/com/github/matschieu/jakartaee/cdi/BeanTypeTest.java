package com.github.matschieu.jakartaee.cdi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
		assertThat(bookshop).isInstanceOf(BookShop.class);
		assertThat(business).isInstanceOf(BookShop.class);
		assertThat(shop).isInstanceOf(BookShop.class);
	}

	@Test
	void testInjectionUsingContainer() {
		assertThat(weld.container().select(BookShop.class).get()).isInstanceOf(BookShop.class);
		assertThat(weld.container().select(Business.class).get()).isInstanceOf(BookShop.class);
		assertThat(weld.container().select(new TypeLiteral<Shop<Book>>() {}).get()).isInstanceOf(BookShop.class);
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
		assertThatExceptionOfType(Exception.class).isThrownBy(() -> typedBookshop.get());
		assertThatExceptionOfType(Exception.class).isThrownBy(() -> typedBusiness.get());
		assertThat(typedShop.get()).isInstanceOf(TypedBookShop.class);
	}

}
