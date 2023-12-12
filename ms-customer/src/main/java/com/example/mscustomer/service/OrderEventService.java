package com.example.mscustomer.service;

import com.example.mscustomer.dao.ClientRepository;
import com.example.mscustomer.dto.CommandeDto;
import com.example.mscustomer.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class OrderEventService {

    @Autowired
    private ClientRepository clientRepository;

    @Bean
    public Consumer<CommandeDto> commandeDtoConsumer(){
       return  (input)->{
            System.out.println("received :"+ input.toString());
            Client client = clientRepository.findByNom(input.getClientName());
            client.setCommandeId(input.getId());
            clientRepository.save(client);
        };
    }
}
