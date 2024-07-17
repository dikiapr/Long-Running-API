package com.longrunapi.latihan.service;

import com.longrunapi.latihan.model.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingService {

    public List<Item> getItems() {
        try {
            // Simulasi proses yang memakan waktu 5 menit
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return Arrays.asList(
                new Item("Tomat"),
                new Item("Telur"),
                new Item("Minyak"),
                new Item("Bawang"),
                new Item("Gula"),
                new Item("Garam"),
                new Item("Kopi"),
                new Item("Teh"),
                new Item("Susu"),
                new Item("Roti")
        );
    }

    public List<Item> getItemsWithDelay() throws InterruptedException {
        Thread.sleep(1000);
        return Arrays.asList(
                new Item("Tomat"),
                new Item("Telur"),
                new Item("Minyak"),
                new Item("Bawang"),
                new Item("Gula"),
                new Item("Garam"),
                new Item("Kopi"),
                new Item("Teh"),
                new Item("Susu"),
                new Item("Roti")
        );
    }
}
