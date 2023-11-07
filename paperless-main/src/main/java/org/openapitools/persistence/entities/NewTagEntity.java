package org.openapitools.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class NewTagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private String match;

    @Column(name = "matching_algorithm")
    private Long matchingAlgorithm;

    @Column(name = "is_insensitive")
    private Boolean isInsensitive;

    @Column(name = "is_inbox_tag")
    private Boolean isInboxTag;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewTagEntity newTagEntity = (NewTagEntity) o;
        return Objects.equals(id, newTagEntity.id) &&
                Objects.equals(name, newTagEntity.name) &&
                Objects.equals(color, newTagEntity.color) &&
                Objects.equals(match, newTagEntity.match) &&
                Objects.equals(matchingAlgorithm, newTagEntity.matchingAlgorithm) &&
                Objects.equals(isInsensitive, newTagEntity.isInsensitive) &&
                Objects.equals(isInboxTag, newTagEntity.isInboxTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, match, matchingAlgorithm, isInsensitive, isInboxTag);
    }
}
