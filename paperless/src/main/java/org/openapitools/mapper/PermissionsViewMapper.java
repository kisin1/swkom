package org.openapitools.mapper;

import org.mapstruct.*;
import org.openapitools.model.GetDocument200ResponsePermissionsView;
import org.openapitools.persistence.entities.GroupPermissions;
import org.openapitools.persistence.entities.Permission;
import org.openapitools.persistence.entities.UserPermissions;
import org.openapitools.persistence.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PermissionsViewMapper implements BaseMapper<Permission, GetDocument200ResponsePermissionsView> {

    @Autowired
    private CorrespondentRepository correspondentRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private StoragePathRepository storagePathRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private DocumentTagsRepository documentTagsRepository;
    @Autowired
    private PermissionRepository  permissionRepository;

    @Mapping(target = "permissionUserPermissions", source = "users", qualifiedByName = "usersDto")
    @Mapping(target = "permissionGroupPermissions", source = "groups", qualifiedByName = "groupsDto")
    abstract public Permission dtoToEntity(GetDocument200ResponsePermissionsView dto);

    @Mapping(target = "users", source = "permissionUserPermissions", qualifiedByName = "usersEntity")
    @Mapping(target = "groups", source = "permissionGroupPermissions", qualifiedByName = "groupsEntity")
    abstract public GetDocument200ResponsePermissionsView entityToDto(Permission entity);

    @Named("usersEntity")
    List<Integer> map1(Set<UserPermissions> userPermissions) {
        return userPermissions.stream().map( userPermission->(int)userPermission.getUser().getId() ).toList();
    }

    @Named("groupsEntity")
    List<Integer> map2(Set<GroupPermissions> groupPermissions) {
        return groupPermissions.stream().map( groupPermission->(int)groupPermission.getGroup().getId() ).toList();
    }

    @Named("usersDto")
    Set<UserPermissions> map3(List<Integer> users) {
        Set<UserPermissions> userPermissions = new HashSet<>();
        for (Integer user : users) {
            UserPermissions userPermission = new UserPermissions();
            userPermission.setUser(userRepository.getReferenceById(user));
            userPermissions.add(userPermission);
        }
        return userPermissions;
    }

    @Named("groupsDto")
    Set<GroupPermissions> map4(List<Integer> groups) {
        Set<GroupPermissions> groupPermissions = new HashSet<>();
        for (Integer group : groups) {
            GroupPermissions groupPermission = new GroupPermissions();
            groupPermission.setGroup(groupRepository.getReferenceById(group));
            groupPermissions.add(groupPermission);
        }
        return groupPermissions;
    }

}
