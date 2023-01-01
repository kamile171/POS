package com.example.pos.Services;

import com.example.pos.Exceptions.ItemNotFoundException;
import com.example.pos.Models.Item;
import com.example.pos.Repositories.Interface.ItemRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void deleteItemById(Long id) {

        if (!itemRepository.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
        itemRepository.deleteById(id);
    }

    public Item updateItem(Item newItem) {

        return itemRepository.findById(newItem.getId())
                .map(item -> {
                    item.setItemName(newItem.getItemName());
                    item.setCost(newItem.getCost());
                    item.setDiscountPercentage(newItem.getDiscountPercentage());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new ItemNotFoundException(newItem.getId()));
    }
    public List<Item> filterItems(HttpServletRequest req)
    {
        List<Item> filteredItems = new ArrayList<>();
        if (req.getParameter("itemName") != null)
        {
            filteredItems.addAll(itemRepository.findByItemName(req.getParameter("itemName")));
        }
        if (req.getParameter("cost") != null)
        {
            filteredItems.addAll(itemRepository.findByCost(new BigDecimal(req.getParameter("cost"))));
        }
        if (req.getParameter("discountPercentage") != null)
        {
            filteredItems.addAll(itemRepository.findByDiscountPercentage(Double.valueOf(req.getParameter("discountPercentage"))));
        }

        return filteredItems;

    }


}
