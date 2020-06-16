package ddd.kata.shoppingcart.domain.articles;

import java.math.BigDecimal;

public class Money {
	
	BigDecimal value;
	BigDecimal totale;
	
	public Money(BigDecimal value, BigDecimal totale){
		this.value = value;
		this.totale = totale;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public BigDecimal getTotale() {
		return totale;
	}
	
	public void setTotale(BigDecimal totale) {
		this.totale = totale;
	}
	
}
