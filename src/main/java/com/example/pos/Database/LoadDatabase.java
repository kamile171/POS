package com.example.pos.Database;

import com.example.pos.Models.Item;
import com.example.pos.Repositories.Interface.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;


@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ItemRepository repository) {

        return args -> {
            //BigDecimal cost = new BigDecimal("29.55");
            log.info("Preloading " + repository.save(new Item("Apple",new BigDecimal("1.99") , 10.0)));
            log.info("Preloading " + repository.save(new Item("Cheese", new BigDecimal("5.99"), 5.0)));
            //log.info("Preloading " + repository.save(new Item()));
            //log.info("Preloading " + repository.save(new Item("Cheese", 12.99, 5.0)));
        };
    }

}
