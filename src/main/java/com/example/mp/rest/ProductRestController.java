package com.example.mp.rest;

import com.example.mp.entity.Product;
import com.example.mp.entity.User;
import com.example.mp.model.GetProductResponse;
import com.example.mp.service.ProductService;
import com.example.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private UserService userService;
    private ProductService productService;

    @Autowired
    public ProductRestController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/addProduct/{userId}")
    public GetProductResponse addProduct(@RequestBody Product product, @PathVariable("userId") int id){
        User user = userService.findById(id);
        user.getProductSet().add(product);
        product.getUserSet().add(user);
        userService.save(user);

        GetProductResponse getProductResponse = new GetProductResponse();
        getProductResponse.setName(product.getName());
        getProductResponse.setId(product.getId());
        getProductResponse.setOrderSet(product.getOrderSet());
        getProductResponse.setUserSet(product.getUserSet());

        return getProductResponse;
    }

    @GetMapping("/getProducts/{user_id}")
    public Set<GetProductResponse> getProducts(@PathVariable("user_id") int id){
        User user = userService.findById(id);
        Set<GetProductResponse> getProductResponseSet = new HashSet<>();
        for (Product product:user.getProductSet()){
            GetProductResponse getProductResponse = new GetProductResponse();
            getProductResponse.setUserSet(product.getUserSet());
            getProductResponse.setOrderSet(product.getOrderSet());
            getProductResponse.setId(product.getId());
            getProductResponse.setName(product.getName());
            getProductResponseSet.add(getProductResponse);
        }

        return getProductResponseSet;
    }
}
