package org.openapitools.mapper;

import org.mapstruct.*;
import org.openapitools.model.GetDocument200ResponsePermissionsView;
import org.openapitools.persistence.entities.AuthUser;
import org.openapitools.persistence.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Permissions;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PermissionsMapper implements BaseMapper<AuthUser, Permissions> {

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

    @Mapping(target = "view", source = "id", qualifiedByName = "viewEntity")
    @Mapping(target = "change", source = "id", qualifiedByName = "changeEntity")
    abstract public Permissions entityToDto(AuthUser entity);

    @Named("viewEntity")
    GetDocument200ResponsePermissionsView map1(Integer id) {
        if(id==null)
            return new GetDocument200ResponsePermissionsView();
        return new GetDocument200ResponsePermissionsView().addUsersItem(id);
    }

    @Named("changeEntity")
    GetDocument200ResponsePermissionsView map2(Integer id) {
        if(id==null)
            return new GetDocument200ResponsePermissionsView();
        return new GetDocument200ResponsePermissionsView().addUsersItem(id);
    }

}
