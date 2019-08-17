package onlineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import onlineShop.model.Cart;
import onlineShop.model.Customer;
import onlineShop.model.SalesOrder;
import onlineShop.service.CartService;
import onlineShop.service.SalesOrderService;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private SalesOrderService customerOrderService;

	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {

		SalesOrder customerOrder = new SalesOrder();
		Cart cart = cartService.getCartById(cartId);
		customerOrder.setCart(cart);

		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setShippingAddress(customer.getShippingAddress());
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrderService.addSalesOrder(customerOrder);
		return "redirect:/checkout?cartId=" + cartId;
	}
}
