/**
 * 
 */
package fr.fms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author CHJCS
 *
 */
@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        
        return "login";
    }
}
