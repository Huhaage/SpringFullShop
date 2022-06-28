/**
 * 
 */
package fr.fms.web;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fms.business.IBusinessImpl;

/**
 * @author CHJCS
 *
 */
public class CustomerController {
	@Autowired
	IBusinessImpl iBusinessImpl;
	
}