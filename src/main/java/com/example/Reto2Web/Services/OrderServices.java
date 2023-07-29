package com.example.Reto2Web.Services;

import com.example.Reto2Web.Model.Order;
import com.example.Reto2Web.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();

    }
    public List<Order> getOrderByStatus(String status) {
        return orderRepository.getOrderByStatus(Utilities.toCapitalize(status));

    }
    public List<Order> getOrdersByZone(String zone) {
        return orderRepository.findBySalesManZone(Utilities.toCapitalize(zone));

    }
    public List<Order> getOrdersBySalesman(Integer salesmanId) {
        return orderRepository.findBySalesManId(salesmanId);

    }
    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.getOrderById(orderId);

    }
    public Order insertOrder(Order order) {
        if(!order.getProducts().isEmpty()) {
            if (order.getProducts().size() == order.getQuantities().size()) {
                order.setStatus("pendiente");
                if (order.getRegisterDay().toString().length() ==0){
                    order.setRegisterDay(Date.from(Instant.now()));
                }
                return orderRepository.save(order);
            }
            else
                return order;
        }
        else
            return order;
    }
    public Order updateOrder(Order order) {
        Optional<Order> tempOrder = orderRepository.getOrderById(order.getId());
        if (order.getStatus()== "Aprobada" || order.getStatus()== "Rechazada"){
            tempOrder.get().setStatus(order.getStatus());
            if (order.getRegisterDay().toString().length() == 0)
                order.setRegisterDay(Date.from(Instant.now()));
            tempOrder.get().setRegisterDay(order.getRegisterDay());
            return orderRepository.save(tempOrder.get());
        }
        else
            return order;
    }
    public void deleteOrder(Integer orderId){
        Optional<Order> tempOrder = orderRepository.getOrderById(orderId);
        if (tempOrder.isPresent())
            orderRepository.delete(tempOrder.get());

    }

}
