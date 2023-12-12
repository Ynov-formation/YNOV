package com.example.mscustomer.service;

import com.example.mscustomer.entities.Commande;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "MS-ORDER")
public interface OrderClient {
    @GetMapping( "/order/v1/commandes/{id}")
    @CircuitBreaker(name = "orderService", fallbackMethod = "getCommandFallback")
    Commande getommande(@PathVariable("id") Long id);

    default Commande getCommandFallback(Long id, Exception e) {
        return Commande.builder().designation("Commande par défaut").build();
    }
}

