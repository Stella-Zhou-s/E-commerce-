package onlineShop.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import onlineShop.model.Cart;
import onlineShop.service.SalesOrderService;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SalesOrderService salesOrderService;
	
	public Cart getCartById(int CartId) {
		Session session = null;
		Cart cart = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			cart = (Cart) session.get(Cart.class, CartId);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return cart;
	}

	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartById(cartId);
		if (cart == null || cart.getCartItem().size() == 0) {
			throw new IOException(cartId + "");
		}
		update(cart);
		return cart;
	}

	public void update(Cart cart) {
		int cartId = cart.getId();
		double total = salesOrderService.getSalesOrderTotal(cartId);
		cart.setTotalPrice(total);
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
		session.close();
	}
}
