package services;

import dto.DocumentDto;
import co.elastic.clients.elasticsearch._types.Result;
import dto.DocumentDto;
import java.io.IOException;
import java.util.Optional;


public interface SearchIndexService {
    Result indexDocument(DocumentDto document) throws IOException;

    Optional<DocumentDto> getDocumentById(int id);

    boolean deleteDocumentById(int id);
}
