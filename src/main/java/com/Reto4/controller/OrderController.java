package com.Reto4.controller;


import com.Reto4.model.Order;
import com.Reto4.service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }
    
    //Reto 3:Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zona}")
    public List<Order> getfindByZone(@PathVariable("zona") String zona) {
        return orderService.getfindByZone(zona);
    }
    
    //Reto4
    @GetMapping("salesman/{id}")
    public List<Order> getordersSalesManByID(@PathVariable("id") int id){
        return orderService.getordersSalesManByID(id);
    }
    
    @GetMapping("/{state}/{id}")
    public List<Order> getordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id){
        return orderService.getordersSalesManByState(state, id);
    }
    
    @GetMapping("/date/{date}/{id}")
    public List<Order> getordersSalesManByDate(@PathVariable("date")String dateStr, @PathVariable("id")Integer id){
        return orderService.getordersSalesManByDate(dateStr, id);
    }
    
}
