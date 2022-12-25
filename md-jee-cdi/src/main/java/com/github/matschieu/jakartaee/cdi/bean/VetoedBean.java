package com.github.matschieu.jakartaee.cdi.bean;

import jakarta.enterprise.inject.Vetoed;

// Vetoed bean is not managed by the constructor
// A package can also be vetoed
@Vetoed
public class VetoedBean extends NotVetoedBean {

}
