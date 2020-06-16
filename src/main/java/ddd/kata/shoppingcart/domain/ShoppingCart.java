package ddd.kata.shoppingcart.domain;

import ddd.kata.shoppingcart.domain.articles.ArticleId;
import ddd.kata.shoppingcart.domain.articles.Money;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {


    private final String cartId;
    private final String userId;
    private List<LineItem> lineItems;

    public ShoppingCart(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
        this.lineItems = new ArrayList<LineItem>();
    }

    public double getTotalAmount() {
        return lineItems.size();
    }

    public int getItemsCount() {
        int count = 0;
        for (LineItem lineItem:lineItems)
              {
                  count = count + lineItem.getQty();

        }
        return count;
    }

    public int getItemAmount(ArticleId articleId) {
    	for(LineItem item:lineItems) {
    		if(item.getArticleId().getId().equals(articleId.getId())) {
    			return item.getQty();
    		}
    	}
    	return -1;
    }
    
    public void addItem(ArticleId articleId, String itemDescription, int qty) {
        LineItem lineItem = new LineItem(articleId, itemDescription, qty);
        if(lineItems.contains(lineItem)) {
        	for(int i=0; i<lineItems.size(); i++) {
        		if(lineItems.get(i).getArticleId().getId().equals(lineItem.getArticleId().getId())) {
        			lineItems.get(i).setQty(lineItems.get(i).getQty()+qty);
        			break;
        		}
        	}
        }
        else 
        	lineItems.add(lineItem);
    }
    
    public void addItem(ArticleId articleId, String itemDescription, int qty, Money money) {
        LineItem lineItem = new LineItem(articleId, itemDescription, qty, money);
        if(lineItems.contains(lineItem)) {
        	for(int i=0; i<lineItems.size(); i++) {
        		if(lineItems.get(i).getArticleId().getId().equals(lineItem.getArticleId().getId())) {
        			lineItems.get(i).setQty(lineItems.get(i).getQty()+qty);
        			lineItems.get(i).getMoney().setTotale(lineItems.get(i).getMoney().getValue().multiply(new BigDecimal(lineItems.get(i).getQty())));
        			break;
        		}
        	}
        }
        else 
        	lineItems.add(lineItem);
    }

	public void removeItem(ArticleId articleId) {
		for(int i=0; i<lineItems.size(); i++) {
			if(lineItems.get(i).getArticleId().getId().equals(articleId.getId())){
				lineItems.remove(lineItems.get(i));
			}
		}
		
	}
	
	public void editItem(ArticleId articleId, int qty) {
		
		for(int i=0; i<lineItems.size(); i++) {
			if(lineItems.get(i).getArticleId().getId().equals(articleId.getId())){
				lineItems.get(i).setQty(qty);
				lineItems.get(i).getMoney().setTotale(lineItems.get(i).getMoney().getValue().multiply(new BigDecimal(qty)));
			}
		}
	}
	
	
}
