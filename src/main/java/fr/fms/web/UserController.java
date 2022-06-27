/**
 * 
 */
package fr.fms.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.fms.entities.User;


/**
 * @author CHJCS
 *
 */
@Controller
public class UserController {


    @GetMapping("/login")
    public String login(Model model, User user) {
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
}
