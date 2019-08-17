package onlineShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop.dao.SalesOrderDao;
import onlineShop.model.Cart;
import onlineShop.model.CartItem;
import onlineShop.model.SalesOrder;


@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	@Autowired
	private SalesOrderDao salesOrderDao;
	
	@Autowired
	private CartService cartService;
	
	public void addSalesOrder(SalesOrder salesOrder) {
		salesOrderDao.addSalesOrder(salesOrder);
	}

	public double getSalesOrderTotal(int cartId) {
		double total=0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item: cartItems){
			total += item.getPrice();
		}
		return total;
	}
}