package org.openapitools.mapper;

import org.mapstruct.*;
import org.openapitools.model.GetDocuments200ResponseResultsInnerNotesInner;
import org.openapitools.persistence.entities.AuthUser;
import org.openapitools.persistence.entities.Document;
import org.openapitools.persistence.entities.DocumentsNote;
import org.openapitools.persistence.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class DocumentNotesMapper implements BaseMapper<DocumentsNote, GetDocuments200ResponseResultsInnerNotesInner> {

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
    private DocumentRepository documentRepository;

    @Mapping(target = "document", source = "document", qualifiedByName = "documentDto")
    @Mapping(target = "user", source = "user", qualifiedByName = "userDto")
    abstract public DocumentsNote dtoToEntity(GetDocuments200ResponseResultsInnerNotesInner dto);

    @Mapping(target = "document", source = "document", qualifiedByName = "documentEntity")
    @Mapping(target = "user", source = "user", qualifiedByName = "userEntity")
    abstract public GetDocuments200ResponseResultsInnerNotesInner entityToDto(DocumentsNote entity);

    @Named("userEntity")
    Integer map(AuthUser user) {
        return user.getId();
    }

    @Named("documentEntity")
    Integer map(Document document) {
        return document.getId();
    }

    @Named("createdEntity")
    String map(OffsetDateTime created) {
        return created.toString();
    }

    @Named("userDto")
    AuthUser mapCorrespondent(Integer value) {
        return userRepository.findById(value).orElse(null);
    }

    @Named("documentDto")
    Document mapDocument(Integer value) {
        return documentRepository.findById(value).orElse(null);
    }


}