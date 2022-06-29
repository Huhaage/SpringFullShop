/**
 * 
 */
package fr.fms.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Customer;

/**
 * @author CHJCS
 *
 */
public class CustomerController {

    @Autowired
    IBusinessImpl iBusinessImpl;

//    // ajoute customer et retourne la page du choix des adresses
//    @PostMapping("/saveCustomer")
//    public String saveCustomer(Model model, @Valid Customer customer, BindingResult bindingResult) {
//        System.out.println("customer : " + customer);
//            	
//        String mail = SecurityContextHolder.getContext().getAuthentication().getName();	
//        System.out.println("mail " + mail);
//        
//		Long idUser = iBusinessImpl.getIdUserByMail(mail);
//		System.out.println("id useer : " + idUser);
//
//        customer.setUser(iBusinessImpl.getUser(idUser));
//        System.out.println(customer);
//        
//        if (bindingResult.hasErrors()) {
//            return "register";
//        }
//        
//        iBusinessImpl.addCustomer(customer);
//        return "redirect:/chooseAddress";
//    }
}