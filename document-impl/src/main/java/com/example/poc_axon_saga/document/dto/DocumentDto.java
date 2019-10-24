package com.example.poc_axon_saga.document.dto;

import com.example.poc_axon_saga.document.model.DocumentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {
    private UUID id;
    private DocumentStatus status;
    private String sender;
    private String subject;
    private String data;
}
