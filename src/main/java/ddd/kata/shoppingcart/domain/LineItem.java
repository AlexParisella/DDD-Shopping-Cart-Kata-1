package ddd.kata.shoppingcart.domain;

import ddd.kata.shoppingcart.domain.articles.ArticleId;
import ddd.kata.shoppingcart.domain.articles.Money;

public class LineItem {
    private final ArticleId articleId;
    private final String itemDescription;
    private int qty;
    private Money money;

    public LineItem(ArticleId articleId, String itemDescription, int qty) {

        this.articleId = articleId;
        this.itemDescription = itemDescription;
        this.qty = qty;
    }
    
    public LineItem(ArticleId articleId, String itemDescription, int qty, Money money) {

        this.articleId = articleId;
        this.itemDescription = itemDescription;
        this.qty = qty;
        this.money = money;
    }

    public int getQty() {
        return qty;
    }
    
    public ArticleId getArticleId() {
    	return articleId;
    }
    
    public Money getMoney() {
    	return money;
    }
    
    public void setQty(int qty) {
    	this.qty = qty;
    }
}
