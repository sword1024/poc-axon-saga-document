package com.example.poc_axon_saga.document.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDocumentDto {
    private String sender;
    private String subject;
    private String data;
}
