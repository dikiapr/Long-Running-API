package com.longrunapi.latihan.controller;

import com.longrunapi.latihan.model.Item;
import com.longrunapi.latihan.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private Executor taskExecutor;

    // Blocking API
    @GetMapping("/items")
    public List<Item> getItemsBlocking() {
        return shoppingService.getItems();
    }

    // Non-blocking API
    @GetMapping("/items/async")
    public CompletableFuture<List<Item>> getItemsNonBlocking() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return shoppingService.getItemsWithDelay();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }, taskExecutor);
    }
}
