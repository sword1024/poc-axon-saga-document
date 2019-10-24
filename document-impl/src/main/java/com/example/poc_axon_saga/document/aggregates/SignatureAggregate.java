package com.example.poc_axon_saga.document.aggregates;

import com.example.poc_axon_saga.document.service.DocumentService;
import com.example.poc_axon_saga.signature.commands.ApplySignatureCommand;
import com.example.poc_axon_saga.signature.events.SignatureAppliedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
@Slf4j
public class SignatureAggregate {
    @Autowired
    private DocumentService documentService;

    private UUID documentId;
    @AggregateIdentifier
    private UUID signatureId;

    @CommandHandler
    public void on(ApplySignatureCommand command) {
        documentId = command.getDocumentId();
        signatureId = command.getSignatureId();
        documentService.markSigned(documentId);
        AggregateLifecycle.apply(new SignatureAppliedEvent(documentId, signatureId));
    }
}
