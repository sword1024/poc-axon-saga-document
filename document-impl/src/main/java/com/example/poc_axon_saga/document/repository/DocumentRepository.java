package com.example.poc_axon_saga.document.repository;

import com.example.poc_axon_saga.document.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
}
