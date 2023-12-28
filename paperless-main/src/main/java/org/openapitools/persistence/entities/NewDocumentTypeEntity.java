package org.openapitools.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class NewDocumentTypeEntity {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewDocumentTypeEntity that = (NewDocumentTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(match, that.match) &&
                Objects.equals(matchingAlgorithm, that.matchingAlgorithm) &&
                Objects.equals(isInsensitive, that.isInsensitive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, match, matchingAlgorithm, isInsensitive);
    }
}
