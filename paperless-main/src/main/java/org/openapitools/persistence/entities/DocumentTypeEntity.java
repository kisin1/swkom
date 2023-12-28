package org.openapitools.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class DocumentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    private String slug;

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

    // Constructors, getters, and setters as needed

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentTypeEntity that = (DocumentTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(slug, that.slug) &&
                Objects.equals(name, that.name) &&
                Objects.equals(match, that.match) &&
                Objects.equals(matchingAlgorithm, that.matchingAlgorithm) &&
                Objects.equals(isInsensitive, that.isInsensitive) &&
                Objects.equals(documentCount, that.documentCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug, name, match, matchingAlgorithm, isInsensitive, documentCount);
    }
}
