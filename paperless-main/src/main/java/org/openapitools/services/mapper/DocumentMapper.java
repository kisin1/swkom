package org.openapitools.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.Document;
import org.openapitools.persistence.entities.DocumentEntity;

import java.util.List;

@Mapper
public interface DocumentMapper {


    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    Document toDTO(DocumentEntity entity);

    DocumentEntity toEntity(Document model);

    // From Integer to JsonNullable<Integer>
    default JsonNullable<Integer> integerToJsonNullable(Integer value) {
        return JsonNullable.of(value);
    }

    // From String to JsonNullable<String>
    default JsonNullable<String> stringToJsonNullable(String value) {
        return JsonNullable.of(value);
    }

    // From List<Integer> to JsonNullable<List<Integer>>
    default JsonNullable<List<Integer>> listToJsonNullable(List<Integer> value) {
        return JsonNullable.of(value);
    }

    // From JsonNullable<Integer> to Integer
    default Integer jsonNullableToInteger(JsonNullable<Integer> value) {
        return value.orElse(null);
    }

    // From JsonNullable<String> to String
    default String jsonNullableToString(JsonNullable<String> value) {
        return value.orElse(null);
    }

    // From JsonNullable<List<Integer>> to List<Integer>
    default List<Integer> jsonNullableToList(JsonNullable<List<Integer>> value) {
        return value.orElse(null);
    }
}