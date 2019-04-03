/**
 * MicroCore CRUD SERVICE
 */
package com.msc.service;

import java.io.Serializable;
import java.util.List;

import com.msc.entity.Customer;

/**
 * @author Ramón Cigüenza
 *
 */
public interface CustomerService extends Serializable {

	/** Create new Customer */
	void create(Customer customer);

	/** Queries Customers */
	List<Customer> getCustomers();

	/** Queries Customers By ID */
	Customer getCustomerById(String idCustomer);

	/** Delete Customer */
	void deleteCustomerById(String idCustomer);

	/** Update Customer*/
	void updateCustomer(Customer customer);

}
