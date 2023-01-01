package com.example.pos.Controllers;

import com.example.pos.Models.Item;
import com.example.pos.Repositories.Interface.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemRepository repository;

    ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/items")
    List<Item> all() {
        return repository.findAll();
    }


    @PostMapping("/item")
    Item newItem(@RequestBody Item newItem) {
        return repository.save(newItem);
    }

}
