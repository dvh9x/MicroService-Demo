package com.example.MicroService.Inventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @GetMapping("/inventories")
    public int getProductInventories() {
        return 100;
    }
}
