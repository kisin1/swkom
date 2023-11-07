package org.openapitools.services.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.DocumentType;
import org.openapitools.persistence.entities.DocumentTypeEntity;

import java.util.List;

@Mapper
public interface DocumentTypeMapper {

    DocumentTypeMapper INSTANCE = Mappers.getMapper(DocumentTypeMapper.class);

    DocumentTypeEntity toEntity(DocumentType documentType);

    DocumentType toDto(DocumentTypeEntity documentTypeEntity);

    List<DocumentTypeEntity> toEntityList(List<DocumentType> documentTypeList);

    List<DocumentType> toDtoList(List<DocumentTypeEntity> documentTypeEntityList);

    // Helper methods for JsonNullable types
    default JsonNullable<String> stringToJsonNullable(String value) {
        return JsonNullable.of(value);
    }

    default String jsonNullableToString(JsonNullable<String> value) {
        return value.orElse(null);
    }

    // ... similar helper methods for other data types as needed
}