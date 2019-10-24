package com.example.poc_axon_saga.document.service;

import com.example.poc_axon_saga.document.model.Document;
import com.example.poc_axon_saga.document.model.DocumentStatus;
import com.example.poc_axon_saga.document.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<UUID> list() {
        return repository.findAll().stream().map(Document::getId).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public <D> D get(UUID documentId, Function<Document, D> resultConverter) {
        Document document = findById(documentId);
        return resultConverter.apply(document);
    }

    @Transactional
    @Override
    public <D> D create(Supplier<Document> documentSource, Function<Document, D> resultConverter) {
        Document document = documentSource.get();
        document = repository.save(document);
        return resultConverter.apply(document);
    }

    @Transactional
    @Override
    public void markSigned(UUID documentId) {
        Document document = findById(documentId);
        DocumentStatus status = document.getStatus();
        if (status == DocumentStatus.CREATED) {
            document.setStatus(DocumentStatus.SIGNED);
        } else {
            //TODO throw exception
        }
    }

    private Document findById(UUID documentId) {
        return repository.findById(documentId).orElseThrow(() -> new EntityNotFoundException(documentId.toString()));
    }
}
