package com.example.msorder.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.msorder.entities.Commande}
 */
@Value
@Builder
public class CommandeDto implements Serializable {
    Long id;
    String designation;
    String description;
    LocalDateTime date;
    String clientName;
}