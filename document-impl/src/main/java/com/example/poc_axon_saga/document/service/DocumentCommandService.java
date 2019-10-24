package com.example.poc_axon_saga.document.service;

import com.example.poc_axon_saga.signature.dto.SignDocumentDto;

import java.util.concurrent.CompletableFuture;

public interface DocumentCommandService {

    CompletableFuture<String> attachSignature(SignDocumentDto signDocumentDto);
}
