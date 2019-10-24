package com.example.poc_axon_saga.document.resource;

import com.example.poc_axon_saga.document.dto.CreateDocumentDto;
import com.example.poc_axon_saga.document.dto.DocumentDto;
import com.example.poc_axon_saga.document.model.Document;
import com.example.poc_axon_saga.document.service.DocumentCommandService;
import com.example.poc_axon_saga.document.service.DocumentService;
import com.example.poc_axon_saga.signature.dto.SignDocumentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DocumentResourceImpl implements DocumentResource {

    private final DocumentService documentService;
    private final DocumentCommandService documentCommandService;
    private final MapperFacade mapperFacade;

    @Override
    public List<UUID> list() {
        return documentService.list();
    }

    @Override
    public DocumentDto get(UUID documentId) {
        return documentService.get(documentId, d -> mapperFacade.map(d, DocumentDto.class));
    }

    @Override
    public DocumentDto create(CreateDocumentDto document) {
        return documentService.create(() -> mapperFacade.map(document, Document.class), d -> mapperFacade.map(d, DocumentDto.class));
    }

    @Override
    public CompletableFuture<String> attachSignature(UUID documentId, String signatureData) {
        return documentCommandService.attachSignature(new SignDocumentDto(documentId, signatureData));
    }
}
