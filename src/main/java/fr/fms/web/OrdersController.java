/**
 * 
 */
package fr.fms.web;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Orders;
import fr.fms.entities.OrdersItem;
import fr.fms.entities.OrdersItemId;
import fr.fms.services.GlobalException;

/**
 * @author CHJCS
 *
 */

@Controller
public class OrdersController {

    @Autowired
    IBusinessImpl iBusinessImpl;

    // affiche les catégories coté admin
    @GetMapping("/adminListOrders")
    public String OrdersList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "1") Long id) {

        // Page<Category> categories = categoryRepository.findAll();
        Page<Orders> orders = iBusinessImpl.readAllOrders(page, 4);
        if (orders.isEmpty()) {
            throw new GlobalException("Aucune données");
        }
        model.addAttribute("listOrders", orders.getContent());
        model.addAttribute("pages", new int[orders.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", id);
        return "adminListOrders";
    }

    // // form edition category
    @GetMapping("/detailOrder")
    public String detailOrder(Model model, Long id, OrdersItem orderItem) {

        List<OrdersItem> ordersItems = iBusinessImpl.readAllItemsByOrderId(id);
        if (ordersItems.isEmpty()) {
            throw new GlobalException("Aucunes données");
        }
        Orders order = iBusinessImpl.readOrderByid(id);
        model.addAttribute("ordersItems", ordersItems);
        model.addAttribute("order", order.getOrderId());

        return "detailOrder";
    }

}
