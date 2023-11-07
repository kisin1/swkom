package org.openapitools.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class CorrespondentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")

    private Long id;

    @Column
    private String slug;

    @Column
    private String name;

    @Column
    private String match;

    @Column
    private Long matchingAlgorithm;

    @Column
    private Boolean isInsensitive;

    @Column
    private Long documentCount;
    @Column
    private OffsetDateTime lastCorrespondence;

}