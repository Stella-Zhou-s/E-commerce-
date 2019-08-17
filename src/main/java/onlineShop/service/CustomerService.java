package onlineShop.service;

import java.util.List;

import onlineShop.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByUserName(String userName);
}
