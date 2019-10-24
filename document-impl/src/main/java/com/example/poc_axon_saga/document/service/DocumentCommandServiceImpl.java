package com.example.poc_axon_saga.document.service;

import com.example.poc_axon_saga.signature.commands.CreateSignatureCommand;
import com.example.poc_axon_saga.signature.dto.SignDocumentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentCommandServiceImpl implements DocumentCommandService {
    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> attachSignature(SignDocumentDto signDocumentDto) {
        return commandGateway.send(new CreateSignatureCommand(signDocumentDto.getDocumentId(), signDocumentDto.getSignatureData()));
    }
}
