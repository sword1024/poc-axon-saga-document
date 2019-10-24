package com.example.poc_axon_saga.document.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
public class Document {
    @Id
    private UUID id;

    @Version
    private long version;

    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    private String sender;
    private String subject;
    private String data;
}
