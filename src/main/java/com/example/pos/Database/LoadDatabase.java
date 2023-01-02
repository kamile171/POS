package com.example.pos.Database;

import com.example.pos.Models.CashRegister;
import com.example.pos.Models.Item;
import com.example.pos.Models.Order;
import com.example.pos.Models.Subscription;
import com.example.pos.Repositories.Interface.CashRegisterRepository;
import com.example.pos.Repositories.Interface.ItemRepository;
import com.example.pos.Repositories.Interface.OrderRepository;
import com.example.pos.Repositories.Interface.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository, SubscriptionRepository subscriptionRepository, CashRegisterRepository cashRegisterRepository, OrderRepository orderRepository) {

        return args -> {
            //items
            log.info("Preloading " + itemRepository.save(new Item("Apple",new BigDecimal("1.99") , 10.0)));
            log.info("Preloading " + itemRepository.save(new Item("Cheese", new BigDecimal("5.99"), 5.0)));
            //subscriptions
            log.info("Preloading " + subscriptionRepository.save(new Subscription("SmolBiznes", 10, new BigDecimal("5"))));
            log.info("Preloading " + subscriptionRepository.save(new Subscription("BigBiznes", 7, new BigDecimal("10"))));
            //cashRegisters
            log.info("Preloading " + cashRegisterRepository.save(new CashRegister(Long.valueOf(1), Long.valueOf(1), new BigDecimal("1255"), 54, new BigDecimal("500"), "Eur" )));
            log.info("Preloading " + cashRegisterRepository.save(new CashRegister(Long.valueOf(1), Long.valueOf(1),new BigDecimal("25"), 7, new BigDecimal("8"),"Eur" )));
            log.info("Preloading " + cashRegisterRepository.save(new CashRegister(Long.valueOf(2), Long.valueOf(1),new BigDecimal("3"), 2, new BigDecimal("1"), "Eur")));
            //order
            log.info("Preloading " + orderRepository.save(new Order(Long.valueOf(1), Long.valueOf(1),12.22, LocalDateTime.now(), "cash", true, 16.0, "some comment", new Long[]{Long.valueOf(1),Long.valueOf(2),Long.valueOf(2)})));
            log.info("Preloading " + orderRepository.save(new Order(Long.valueOf(1), Long.valueOf(1),52.22, LocalDateTime.now(), "cash", true, 20.0, "another comment", new Long[]{Long.valueOf(1),Long.valueOf(1),Long.valueOf(2)})));

        };
    }

}
