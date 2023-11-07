package org.openapitools.services.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.Correspondent;
import org.openapitools.persistence.entities.CorrespondentEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CorrespondentMapper {

    CorrespondentMapper INSTANCE = Mappers.getMapper(CorrespondentMapper.class);

    CorrespondentEntity toEntity(Correspondent dto);

    Correspondent toDto(CorrespondentEntity entity);

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
