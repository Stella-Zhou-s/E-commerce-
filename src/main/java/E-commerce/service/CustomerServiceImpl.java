package onlineShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onlineShop.dao.CustomerDao;
import onlineShop.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	public void addCustomer(Customer customer) {		
		customerDao.addCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		return customerDao.getCustomerByUserName(userName);
	}
}