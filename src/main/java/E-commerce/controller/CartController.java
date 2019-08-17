package onlineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import onlineShop.model.Cart;
import onlineShop.model.Customer;
import onlineShop.service.CartService;
import onlineShop.service.CustomerService;

@Controller
public class CartController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/cart/getCartById")
	public String getCartId(Model model){
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		Customer customer = customerService.getCustomerByUserName(username);
		model.addAttribute("cartId", customer.getCart().getId());
		return "cart";
	}
	
	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCartItems(@PathVariable(value="cartId")int cartId){
		return cartService.getCartById(cartId);
	}
}
