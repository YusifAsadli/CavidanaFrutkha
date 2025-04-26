package edu.az.itbrains123.ecommerse.controllers;

import edu.az.itbrains123.ecommerse.dtos.order.OrderDashboardDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderDetailDto;
import edu.az.itbrains123.ecommerse.dtos.order.OrderDto;
import edu.az.itbrains123.ecommerse.models.Order;
import edu.az.itbrains123.ecommerse.sevices.OrderService;
import edu.az.itbrains123.ecommerse.sevices.impls.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/dashboard/orders")
    public String order(Model model) {
        List<OrderDashboardDto> orders =orderService.getDashboardOrder();
        model.addAttribute("orders", orders);
        return"/dashboard/orders/index";
    }
    @GetMapping("/dashboard/orders/{id}")
    public String detail(Model model, @PathVariable Long id){
        List<OrderDetailDto> order = orderService.getOrderById(id);
        model.addAttribute("orders",order);
        return "/dashboard/orders/detail";
    }



}
