package com.example.pos.Repositories.Interface;

import com.example.pos.Models.Item;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {



}
