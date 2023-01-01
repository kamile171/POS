package com.example.pos.Services;

import com.example.pos.Exceptions.InvalidInputException;
import com.example.pos.Exceptions.OrderNotFoundException;
import com.example.pos.Models.Order;
import com.example.pos.Repositories.Interface.OrderRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void deleteItemById(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }
    public Order saveOrder(Order newOrder) {

        if (newOrder.getRegisterId() == null || newOrder.getItemId() == null || newOrder.getTotalValue() == null
                || newOrder.getDateTime() == null|| newOrder.getPaymentMethod() == null|| newOrder.getIsInactive() == null
                || newOrder.getLoyalty() == null|| newOrder.getOrderComment() == null|| newOrder.getItems() == null) {
            throw new InvalidInputException();
        }
        return orderRepository.save(newOrder);
    }
    public Order updateItem(Order newOrder) {

        return orderRepository.findById(newOrder.getId())
                .map(order -> {
                    order.setId(newOrder.getId());
                    order.setRegisterId(newOrder.getRegisterId());
                    order.setItemId(newOrder.getItemId());
                    order.setTotalValue(newOrder.getTotalValue());
                    order.setDateTime(newOrder.getDateTime());
                    order.setPaymentMethod(newOrder.getPaymentMethod());
                    order.setIsInactive(newOrder.getIsInactive());
                    order.setLoyalty(newOrder.getLoyalty());
                    order.setOrderComment(newOrder.getOrderComment());
                    order.setItems(newOrder.getItems());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new OrderNotFoundException(newOrder.getId()));
    }
    public List<Order> filterOrders(HttpServletRequest req)
    {
        List<Order> filteredOrders = new ArrayList<>();
        if (req.getParameter("isInactive") != null)
        {
            filteredOrders.addAll(orderRepository.findByOrderStatus(Boolean.valueOf(req.getParameter("isInactive"))));
        }
        if (req.getParameter("orderComment") != null)
        {
            filteredOrders.addAll(orderRepository.findByDescription(req.getParameter("orderComment")));
        }
        if (req.getParameter("items") != null)
        {
            filteredOrders.addAll(orderRepository.findByitemId(new Long[]{Long.valueOf(req.getParameter("items"))}));
        }

        return filteredOrders;

    }


}