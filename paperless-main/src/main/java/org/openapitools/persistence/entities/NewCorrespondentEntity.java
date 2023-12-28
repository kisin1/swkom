package org.openapitools.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class NewCorrespondentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String match;

    @Column(name = "matching_algorithm")
    private Long matchingAlgorithm;

    @Column(name = "is_insensitive")
    private Boolean isInsensitive;

    @Column(name = "document_count")
    private Long documentCount;

    @Column(name = "last_correspondence")
    private OffsetDateTime lastCorrespondence;
}