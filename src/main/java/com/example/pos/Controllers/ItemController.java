package com.example.pos.Controllers;

import com.example.pos.Exceptions.ItemNotFoundException;
import com.example.pos.Models.Item;
import com.example.pos.Repositories.Interface.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.pos.Services.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import java.util.Map;

@RestController
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    ItemController(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @GetMapping("/items")
    List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    @PostMapping("/item")
    Item createNewItem(@RequestBody Item newItem) {

        return itemService.saveItem(newItem);
    }

    @GetMapping("/item/{id}")
    Item findItemById(@PathVariable Long id) {

        return itemRepository.findById(id)
               .orElseThrow(() -> new ItemNotFoundException(id));
    }
    @GetMapping("/item/criteria")
    List<Item> findItemByCriteria(HttpServletRequest req)
    {
        return itemService.filterItems(req);
    }

    @PutMapping("/item")
    Item updateItem(@RequestBody Item newItem) {
        return itemService.updateItem(newItem);
    }

    @DeleteMapping("/item/{id}")
    void deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }

}
