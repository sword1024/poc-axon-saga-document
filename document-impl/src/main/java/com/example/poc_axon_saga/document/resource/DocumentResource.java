package com.example.poc_axon_saga.document.resource;

import com.example.poc_axon_saga.document.dto.CreateDocumentDto;
import com.example.poc_axon_saga.document.dto.DocumentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestMapping("document")
public interface DocumentResource {

    @GetMapping()
    List<UUID> list();

    @GetMapping("/{documentId}")
    DocumentDto get(@PathVariable UUID documentId);

    @PostMapping
    DocumentDto create(@RequestBody CreateDocumentDto document);

    @PostMapping("/{documentId}/signature")
    CompletableFuture<String> attachSignature(@PathVariable UUID documentId, @RequestBody String signatureData);
}
