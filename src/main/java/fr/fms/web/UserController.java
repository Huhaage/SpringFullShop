/**
 * 
 */
package fr.fms.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Customer;
import fr.fms.entities.Users;



/**
 * @author CHJCS
 *
 */
@Controller
public class UserController {

    @Autowired
    IBusinessImpl iBusinessImpl;


    @GetMapping("/login")
    public String login(Model model, Users user) {
        return "login";
    }
    
    // 
    @PostMapping("/login")
    public String connect() {
        return "login";
    }

    // deconnexion et retourne sur home
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @PostMapping("/logout")
    public String disconnect() {
        return "redirect:/login";
    }

    // register
    @GetMapping("/register")
    public String register(Model model, Customer customer) {
         String userName = SecurityContextHolder.getContext().getAuthentication().getName();
       System.out.println(userName);
        return "register";
    }

}
