/**
 * 
 */
package fr.fms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

    // ajoute customer et retourne la page du choix des adresses
    @PostMapping("/saveCustomer")
    public String save(Model model, @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        iBusinessImpl.addCustomer(customer);
        return "redirect:/chooseAddress";
    }
}