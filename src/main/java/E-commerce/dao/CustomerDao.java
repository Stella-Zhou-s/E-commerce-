package onlineShop.dao;

import java.util.List;

import onlineShop.model.Customer;

public interface CustomerDao {
	
	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByUserName(String userName);

}
