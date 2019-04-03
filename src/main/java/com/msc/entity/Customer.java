/**
 * CUSTOMER
 */
package com.msc.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Ramón Cigüenza
 *
 */

@Document(collection = "Customer.toLowerCase()")
public class Customer implements Serializable {

	@Field("id")
	private String idCustomer;
	
	@Field("name")
	private String name;

	public Customer(String idCustomer, String name) {
			this.idCustomer = idCustomer;
			this.name = name;
			}

	public String getIdCustomer() {
			return idCustomer;
			}

	public void setIdCustomer(String idCustomer) {
			this.idCustomer = idCustomer;
			}

	public String getName() {
			return name;
			}

	public void setName(String name) {
			this.name = name;
			}
}
