package com.example.mscustomer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;



@Builder
@Data
@ToString
public class CommandeDto implements Serializable {
    Long id;
    String designation;
    String description;
    LocalDateTime date;
    String clientName;
}