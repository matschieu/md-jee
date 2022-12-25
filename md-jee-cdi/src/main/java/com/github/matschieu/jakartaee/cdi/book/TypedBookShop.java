package com.github.matschieu.jakartaee.cdi.book;

import jakarta.enterprise.inject.Typed;

// This bean has only 2 types, TypedShop<Book> and Object
@Typed(TypedShop.class)
public class TypedBookShop extends TypedBusiness implements TypedShop<Book>{

}
