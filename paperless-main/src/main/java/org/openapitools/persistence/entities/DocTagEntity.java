package org.openapitools.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class DocTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")

    private Long id;

    private String slug;
    private String name;
    private String color;
    private String match;
    private Long matchingAlgorithm;
    private Boolean isInsensitive;
    private Boolean isInboxTag;
    private Long documentCount;

    // Konstruktor, Getter und Setter hier hinzufügen

    // Standardkonstruktor
    public DocTagEntity() {
    }

    // Konstruktor ohne ID, da sie automatisch generiert wird
    public DocTagEntity(String slug, String name, String color, String match, Long matchingAlgorithm, Boolean isInsensitive, Boolean isInboxTag, Long documentCount) {
        this.slug = slug;
        this.name = name;
        this.color = color;
        this.match = match;
        this.matchingAlgorithm = matchingAlgorithm;
        this.isInsensitive = isInsensitive;
        this.isInboxTag = isInboxTag;
        this.documentCount = documentCount;
    }
}
