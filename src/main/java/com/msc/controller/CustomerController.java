/**
 * REST MICROSERVICE CONTROLLER FOR /MICROCORE
 */
package com.msc.controller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.msc.exceptions.MicroCoreUserNotAuthorizedException;
import com.msc.util.MicroCoreConstants;
import com.msc.service.CustomerService;
import com.msc.entity.Customer;
import com.msc.exceptions.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ramón Cigüenza
 *
 */

@Controller
@RestController
@RequestMapping("/v1/msc")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge=6000)
@Api(value="CustomerControllerAPI",consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class CustomerController {
	
	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
		
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping (value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	@ApiOperation("Create a new Customer")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "KO"),
			@ApiResponse(code = 401, message = "KO - Not Authorized"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
	public @ResponseBody void create (@RequestBody Customer customer)
					throws MicroCoreUserNotAuthorizedException {
				
		try {
			
			// User authentication
			logger.info("CustomerControllerAPI creating Customer entity ");
			customerService.create(customer);
			logger.info("CustomerControllerAPI created");
					
		}catch (MicroCoreUserNotAuthorizedException e){
			logger.debug(MicroCoreConstants.MsgDebugOperations.DEBUG_MSG_ERROR_USER_NOT_AUTHORIZED);
			throw new MicroCoreUserNotAuthorizedException("Invalid Credentials: "+e.getMessage());
		}
	}

	/** Read Query API Service */
	@RequestMapping (value="/getCustomers",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Query records")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="OK",response=Customer.class),
			@ApiResponse(code=204, message="OK - Item not found")
	})
	public @ResponseBody
		List<Customer> getCustomers(){
			return customerService.getCustomers();
			}

	@RequestMapping (value="/getCustomerById/{idCustomer}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ApiOperation("Gets id item object")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="OK",response=Customer.class),
			@ApiResponse(code=204, message="OK - ID not found")
	})
	public @ResponseBody Customer getCustomerById(@PathVariable String idCustomer){
			return customerService.getCustomerById(idCustomer);
			}

	@RequestMapping(value="/deleteCustomerById/{idCustomer}",method=RequestMethod.DELETE)
	@ApiOperation("Delete item by ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK - Item Deleted"),
			@ApiResponse(code = 600, message = "Incorrect ID"),
			@ApiResponse(code = 204, message = "OK - ID item not found"),
			@ApiResponse(code = 606, message = "Invalid Input")
	})
	public @ResponseBody void deleteCustomerById(@PathVariable String idCustomer){
			customerService.deleteCustomerById(idCustomer);
			}

	@RequestMapping(value="/updateCustomer",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update element", notes= "Update database record item")
	@ApiResponses(value = {
			@ApiResponse(code = 600, message = "KO - Incorrect ID"),
			@ApiResponse(code = 601, message = "KO - ID not found"),
			@ApiResponse(code = 606, message = "KO - Invalid Input")
	})
	public @ResponseBody void updateCustomer(Customer customer) {
			customerService.updateCustomer(customer);
			}

	
}
