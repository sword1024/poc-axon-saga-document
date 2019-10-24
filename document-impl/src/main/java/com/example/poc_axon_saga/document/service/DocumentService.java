package com.example.poc_axon_saga.document.service;

import com.example.poc_axon_saga.document.model.Document;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

public interface DocumentService {

    List<UUID> list();

    <D> D get(UUID documentId, Function<Document, D> resultConverter);

    <D> D create(Supplier<Document> documentSource, Function<Document, D> resultConverter);

    void markSigned(UUID documentId);
}
