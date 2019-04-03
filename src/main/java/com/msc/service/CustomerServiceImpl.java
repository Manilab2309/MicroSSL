/**
 * CUSTOMER SERVICE IMPLEMENTATION
 */
package com.msc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.msc.entity.Customer;
import com.msc.repository.CustomerDao;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	/** Create new Customer */
	public void create(Customer customer) {
		customerDao.create(customer);
	}
	
	/** Queries Customers */
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	
	/** Queries Customer By ID */
	public Customer getCustomerById(String idCustomer) {
		return customerDao.getCustomerById(idCustomer);
	}
	
	/** Delete Customer */
	public void deleteCustomerById(String idCustomer) {
		customerDao.deleteCustomerById(idCustomer);
	}
	
	/** Update Customer*/
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

}
