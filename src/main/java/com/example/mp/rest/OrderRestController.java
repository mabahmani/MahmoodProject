package com.example.mp.rest;


import com.example.mp.entity.Order;
import com.example.mp.model.AddOrderResponse;
import com.example.mp.service.OrderService;
import com.example.mp.service.ProductService;
import com.example.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    private OrderService orderService;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public OrderRestController(OrderService orderService, UserService userService, ProductService productService) {
        this.orderService = orderService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/addOrder/{user_id}/{product_id}")
    public AddOrderResponse addOrder(@RequestBody Order order, @PathVariable("user_id") int userId, @PathVariable("product_id") int productId){
        order.setUser(userService.findById(userId));
        order.setProduct(productService.findById(productId));
        orderService.save(order);

        AddOrderResponse addOrderResponse = new AddOrderResponse();
        addOrderResponse.setId(order.getId());
        addOrderResponse.setName(order.getName());
        addOrderResponse.setProduct(order.getProduct());
        addOrderResponse.setUser(order.getUser());

        return addOrderResponse;
    }
}
