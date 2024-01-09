package org.openapitools.service;

import org.openapitools.persistence.entities.DocumentEntity;

import java.io.IOException;
import java.util.List;


public interface SearchIndexService {
    List<DocumentEntity>  searchDocument(String query) throws IOException ;

}