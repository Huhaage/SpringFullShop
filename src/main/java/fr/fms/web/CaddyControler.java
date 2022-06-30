package fr.fms.web;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Customer;
import fr.fms.entities.Users;
import fr.fms.services.GlobalException;


@Transactional
@Controller
public class CaddyControler {

	@Autowired
	IBusinessImpl iBusinessImpl;

	@GetMapping("/caddy")
	public String caddy(Model model, HttpSession session) {

		model.addAttribute("listCaddy", iBusinessImpl.listCaddy());
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		// pour le if
		model.addAttribute("size", iBusinessImpl.sizeCaddy());

		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);
		return "caddy";

	}

	@GetMapping("/addToCaddy")
	public String addToCaddy(Long id, Model model, @RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="keyword", defaultValue = "") String keyword) throws InterruptedException {
		iBusinessImpl.addToCaddy(id);
		Thread.sleep(2000);
		
		return "redirect:/articles?page="+page+"&keyword="+keyword;

	}

	
	@GetMapping("/delToCaddy")
	public String delToCaddy(Model model, Long id, HttpSession session) {
		iBusinessImpl.removeFromCaddy(id);
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy());
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		// pour le if
		model.addAttribute("size", iBusinessImpl.sizeCaddy());

		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);

		return "caddy";
	}

	@GetMapping("/clearCaddy")
	public String clearCaddy(Model model,HttpSession session) {
		iBusinessImpl.getCaddy().clear();
		// pour le if
		model.addAttribute("size", iBusinessImpl.sizeCaddy());

		int length = iBusinessImpl.sizeCaddy();
		session.setAttribute("caddySize", length);
		return "redirect:/caddy";
	}

	// lien de la page order
	@GetMapping("/order")
	public String order(Model model, @RequestParam(name = "id", defaultValue = "0") Long id) {
		Customer cust = iBusinessImpl.getCustomer((long) id);
		Customer customer = new Customer(id, cust.getName(), cust.getFirstName(), cust.getAddress(), cust.getPhone());
		
		model.addAttribute("listCaddy", iBusinessImpl.listCaddy()); 
		model.addAttribute("totalCaddy", iBusinessImpl.totalCaddy());
		model.addAttribute("customer", customer);

		model.addAttribute("size", iBusinessImpl.sizeCaddy());
		
		return "order";
	}

    //payement
    @GetMapping("/payment")
    public String payment(Model model) {        
        Long orderId=iBusinessImpl.newOrder(1L); 
        iBusinessImpl.saveOrder(orderId);
        iBusinessImpl.getCaddy().clear();

        return "redirect:/articles";
    }
		
	@GetMapping("/chooseAddress")
	public String chooseAddress(Model model) {
		String mail = SecurityContextHolder.getContext().getAuthentication().getName();	
		Long idUser = iBusinessImpl.getIdUserByMail(mail);
				
		List<Customer> listAddresses = iBusinessImpl.readAllCustomerByUserId((long) idUser);
		model.addAttribute("listAddresses", listAddresses);
		
		return "chooseAddress";
	}

	// register
	@GetMapping("/register")
	public String register(Model model, Customer customer) {
		return "register";
	}

    // ajoute customer et retourne la page du choix des adresses
    @PostMapping("/saveCustomer")
	public String saveCustomer(Model model, @Valid Customer customer, BindingResult bindingResult) {
	
            	
        String mail = SecurityContextHolder.getContext().getAuthentication().getName();	
		Long idUser = iBusinessImpl.getIdUserByMail(mail);
		Users user = iBusinessImpl.getUser(idUser);
		Users newUser = new Users(user.getId(), user.getMail());
		
        customer.setUser(newUser);
      
       iBusinessImpl.addCustomer(customer);
        return "redirect:/chooseAddress";
    }
	
}
