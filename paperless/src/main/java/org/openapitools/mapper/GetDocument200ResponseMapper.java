package org.openapitools.mapper;


import org.mapstruct.*;
import org.openapitools.model.GetDocument200Response;
import org.openapitools.model.GetDocument200ResponsePermissions;
import org.openapitools.model.GetDocuments200ResponseResultsInnerNotesInner;
import org.openapitools.persistence.entities.*;
import org.openapitools.persistence.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class GetDocument200ResponseMapper implements BaseMapper<DocumentEntity, GetDocument200Response> {
    @Autowired
    private CorrespondentRepository correspondentRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private StoragePathRepository storagePathRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentTagsRepository documentTagsRepository;

    @Autowired
    private PermissionsMapper PermissionsMapper;
    @Autowired
    private DocumentNotesMapper documentNotesMapper;

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentDto")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "documentTypeDto")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathDto")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagsDto")
    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "archiveSerialNumberDto")
    @Mapping(target = "owner", source = "owner", qualifiedByName = "ownerDto")
    @Mapping(target = "notes", source = "notes", qualifiedByName = "notesDto")
    abstract public DocumentEntity dtoToEntity(GetDocument200Response dto);

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentEntity")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "documentTypeEntity")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathEntity")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagsEntity")
    @Mapping(target = "createdDate", source = "created", qualifiedByName = "createdToCreatedDate")
    @Mapping(target = "owner", source = "owner", qualifiedByName = "ownerEntity")
    @Mapping(target = "permissions", source = "owner", qualifiedByName = "permissionsEntity")
    @Mapping(target = "notes", source = "notes", qualifiedByName = "notesEntity")
    abstract public GetDocument200Response entityToDto(DocumentEntity entity);

    @Named("correspondentEntity")
    Integer map(Correspondent correspondent) {
        if(correspondent == null) return null;

        return correspondent.getId();
    }

    @Named("documentTypeEntity")
    Integer map(DocumentType documentType) {
        if(documentType == null) return null;
        return documentType.getId();
    }

    @Named("storagePathEntity")
    Integer map(StoragePath storagePath) {
        if(storagePath == null) return null;
        return storagePath.getId();
    }

    @Named("ownerEntity")
    Integer map(AuthUser owner) {
        if(owner == null) return null;

        return owner.getId();
    }

    @Named("tagsEntity")
    List<Integer> map(Set<DocumentTags> tags) {
        if(tags == null) return null;
        return tags.stream().map( tag->(int)tag.getId() ).toList();
    }

    @Named("permissionsEntity")
    GetDocument200ResponsePermissions mapPermissions(AuthUser owner) {
        if(owner == null) return null;
        return PermissionsMapper.entityToDto(owner);
    }

    @Named("notesEntity")
    List<GetDocuments200ResponseResultsInnerNotesInner> mapNotes(Set<DocumentsNote> notes) {
        if(notes == null) return null;
        return notes.stream().map( note->documentNotesMapper.entityToDto(note) ).toList();
    }

    // map created to createdDate (Date without the time)
    @Named("createdToCreatedDate")
    OffsetDateTime mapCreatedDate(OffsetDateTime value) {
        return value!=null ? value.withOffsetSameInstant(ZoneOffset.UTC).toLocalDate().atStartOfDay().atOffset(ZoneOffset.UTC) : null;
    }

    @Named("correspondentDto")
    Correspondent mapCorrespondent(Integer value) {
        if(value == null) return null;
        return correspondentRepository.findById(value).orElse(null);
    }

    @Named("documentTypeDto")
    DocumentType mapDocumentType(Integer value) {
        if(value == null) return null;

        return documentTypeRepository.findById(value).orElse(null);
    }

    @Named("storagePathDto")
    StoragePath mapStoragePath(Integer value) {
        if(value == null) return null;
        return storagePathRepository.findById(value).orElse(null);
    }

    @Named("ownerDto")
    AuthUser mapOwner(Integer value) {
        if(value == null) return null;
        return userRepository.findById(value).orElse(null);
    }

    @Named("tagsDto")
    Set<DocumentTags> mapDocTag(List<Integer> value) {
        if(value == null) return null;
        return new HashSet<DocumentTags>(documentTagsRepository.findAllById(value));
    }

    @Named("archiveSerialNumberDto")
    Integer mapArchiveSerialNumber(String value) {
        if(value==null || value.isEmpty()) return null;
        return Integer.parseInt(value);
    }

    @Named("notesDto")
    Set<DocumentsNote> mapNotes(List<GetDocuments200ResponseResultsInnerNotesInner> value) {
        if(value==null || value.isEmpty()) return null;

        HashSet<DocumentsNote> notes = new HashSet<DocumentsNote>();

        for(GetDocuments200ResponseResultsInnerNotesInner note : value) {
            notes.add(documentNotesMapper.dtoToEntity(note));
        }

        return notes;
    }

}