package org.openapitools.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.DocTag;
import org.openapitools.persistence.entities.DocTagEntity;

import java.util.List;

@Mapper
public interface DocTagMapper {

    DocTagMapper INSTANCE = Mappers.getMapper(DocTagMapper.class);

    DocTagEntity toEntity(DocTag docTag);

    DocTag toDto(DocTagEntity docTagEntity);

    List<DocTagEntity> toEntityList(List<DocTag> docTagList);

    List<DocTag> toDtoList(List<DocTagEntity> docTagEntityList);

    // Helper methods for JsonNullable types
    default JsonNullable<String> stringToJsonNullable(String value) {
        return JsonNullable.of(value);
    }

    default String jsonNullableToString(JsonNullable<String> value) {
        return value.orElse(null);
    }

    // ... similar helper methods for other data types as needed
}
