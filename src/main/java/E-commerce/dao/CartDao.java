package onlineShop.dao;

import java.io.IOException;

import onlineShop.model.Cart;

public interface CartDao {
	
	Cart getCartById(int CartId);
	
	Cart validate(int cartId) throws IOException;
	
	void update(Cart cart);
}
