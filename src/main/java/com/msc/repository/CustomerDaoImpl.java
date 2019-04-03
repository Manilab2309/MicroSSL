/**
 * MICROSERVICE DAO IMPLEMENTATION
 */
package com.msc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

import com.msc.util.MicroCoreConstants;
import com.msc.entity.Customer;

/**
 * @author Ramón Cigüenza
 *
 */

@Repository
@Qualifier("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(com.msc.repository.CustomerDaoImpl.class);
	
	@Autowired
	MongoTemplate mongoTemplate;

	public void create(Customer customer) {

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Impl creating Customer");

		// TODO DT Database interact

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Impl success");
	}

	public List<Customer> getCustomers() {

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Query All Customers");

		//TODO: Query List DAO implementation
		Customer item1 = new Customer("MCR457", "Entity1");
		Customer item2 = new Customer("MCR124", "Entity2");
		Customer item3 = new Customer("MCR876", "Entity3");

		List<Customer> result = new ArrayList<Customer>();
		result.add(item1);
		result.add(item2);
		result.add(item3);

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Impl success");

		return result;

	}

	public Customer getCustomerById(String idCustomer) {

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Query For Customer: "+idCustomer);

		//TODO: Search DAO implementation
		Customer item = new Customer("MCR457", "EntityFounded");

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Impl success");

		return item;

	}


	public void deleteCustomerById(String idCustomer) {

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Delete Operation For Customer: "+idCustomer);

		//TODO: Delete DAO implementation

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Impl success");
	}

	public void updateCustomer(Customer customer) {

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Customer Updated: "+customer.getIdCustomer());

		//TODO: Update DAO implementation

		logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
		+ "Dao Impl success");
		}

}
