package com.example.Reto2Web.Controllers;

import com.example.Reto2Web.Model.Gadget;
import com.example.Reto2Web.Model.Order;
import com.example.Reto2Web.Services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/order")
public class OrderControllers {
    @Autowired
    private OrderServices orderServices;

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderServices.getAllOrders();
    }
    @GetMapping("/state/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String status){
        return orderServices.getOrderByStatus(status);
    }
    @GetMapping("/zone/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return orderServices.getOrdersByZone(zone.toUpperCase());
    }
    @GetMapping("/salesman/{salesmanId}")
    public List<Order> getOrdersBySalesman(@PathVariable("salesmanId") Integer salesmanId){
        return orderServices.getOrdersBySalesman(salesmanId);
    }
    @GetMapping("/{orderId}")
    public Optional<Order> getOrderByOrderId(@PathVariable("orderId") Integer orderId){
        return orderServices.getOrderById(orderId);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order insertOrder(@RequestBody Order order){
        return orderServices.insertOrder(order);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order updateOrder(@RequestBody Order order){
        return orderServices.updateOrder(order);
    }
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Integer orderId){
        orderServices.deleteOrder(orderId);
    }


}
