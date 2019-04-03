/**
 * MICROSERVICE DAO INTERFACE
 */
package com.msc.repository;

import java.io.Serializable;
import java.util.List;

import com.msc.entity.Customer;
import com.msc.exceptions.MicroCoreUserNotAuthorizedException;

/**
 * @author Ramón Cigüenza
 *
 */
public interface CustomerDao extends Serializable {

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
