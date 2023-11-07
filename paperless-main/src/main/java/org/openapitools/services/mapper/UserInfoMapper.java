package org.openapitools.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.UserInfo;
import org.openapitools.persistence.entities.UserInfoEntity;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    UserInfoEntity toEntity(UserInfo userInfo);

    UserInfo toDto(UserInfoEntity userInfoEntity);

    List<UserInfoEntity> toEntityList(List<UserInfo> userInfoList);

    List<UserInfo> toDtoList(List<UserInfoEntity> userInfoEntityList);

    // Helper methods for JsonNullable types
    default JsonNullable<String> stringToJsonNullable(String value) {
        return JsonNullable.of(value);
    }

    default String jsonNullableToString(JsonNullable<String> value) {
        return value.orElse(null);
    }

    // ... similar helper methods for other data types as needed
}
