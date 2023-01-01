package com.example.pos.Controllers;

import com.example.pos.Exceptions.ItemNotFoundException;
import com.example.pos.Models.Item;
import com.example.pos.Repositories.Interface.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/item/{id}")
    Item one(@PathVariable Long id) {

        return repository.findById(id)
               .orElseThrow(() -> new ItemNotFoundException(id));
    }
}
