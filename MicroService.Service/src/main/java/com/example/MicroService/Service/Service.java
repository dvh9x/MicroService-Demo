package com.example.MicroService.Service;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.requireNonNullElse;

@RestController
public class Service {
    @Resource
    private InformationProductClient informationClient;

    @Resource
    private InventoryProductClient inventoryClient;

    @GetMapping("/product")
    public Product getProduct() {

        var product = new Product();
        var productName = informationClient.getProductName();
        var productInventory = inventoryClient.getProductInventories();

        //Fallback to error message
        product.setStrName(requireNonNullElse(productName, "Error: Fetching Product Title Failed"));

        //Fallback to default error inventory
        product.setIntInventories(requireNonNullElse(productInventory, -1));

        return product;
    }
}
