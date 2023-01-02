package com.example.pos.Controllers;

import com.example.pos.Exceptions.OrderNotFoundException;
import com.example.pos.Models.Order;
import com.example.pos.Services.OrderService;
import com.example.pos.Repositories.Interface.OrderRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;
    OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    List<Order> all() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/criteria")
    List<Order> findItemByCriteria(HttpServletRequest req)
    {
        return orderService.filterOrders(req);
    }

    @GetMapping("/order/{id}")
        Order one(@PathVariable Long id) {

    return orderRepository.findById(id)
            .orElseThrow(() -> new OrderNotFoundException(id));
    }
    @PostMapping("/order")
    Order newOrder(@RequestBody Order newOrder) {
        return orderService.saveOrder(newOrder);
    }

    @PutMapping("/order")
    Order replaceEmployee(@RequestBody Order newOrder) {
        return orderService.updateItem(newOrder);
    }

    @DeleteMapping("/order/{id}")
    void deleteOrder(@PathVariable Long id) {
        orderService.deleteItemById(id);
    }

}
