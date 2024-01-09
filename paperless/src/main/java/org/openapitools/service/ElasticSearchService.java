package org.openapitools.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.configuration.ElasticSearchConfig;
import org.openapitools.persistence.entities.DocumentEntity;
import org.openapitools.persistence.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ElasticSearchService implements SearchIndexService {
    private final ElasticsearchClient esClient;
    private final DocumentRepository documentRepository;

    @Autowired
    public ElasticSearchService(ElasticsearchClient esClient, DocumentRepository documentRepository) throws IOException {
        this.esClient = esClient;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<DocumentEntity> searchDocument(String query) throws IOException {
        SearchResponse<ObjectNode> response = esClient.search(s -> s
                        .index(ElasticSearchConfig.DOCUMENTS_INDEX_NAME)
                        .size(1000)
                        .query(q -> q.match(m -> m.field("content").query(query))),
                ObjectNode.class
        );

        assert response.hits().total() != null;
        if (response.hits().total().value() != 0) {
            log.info("Found {} documents", response.hits().total().value());
        } else {
            log.info("No documents found");
        }

        return extractDocuments(response.hits());
    }

    private List<DocumentEntity> extractDocuments(HitsMetadata<ObjectNode> hitsMetadata) {
        List<ObjectNode> documents = new ArrayList<>();

        //get hits
        for (Hit<ObjectNode> hit : hitsMetadata.hits()) {
            documents.add(hit.source());
        }

        //extract ids
        List<Integer> documentIds = new ArrayList<>();
        for (ObjectNode document : documents) {
            documentIds.add(document.get("id").asInt());
        }

        //get documents from repository
        List<DocumentEntity> documentEntities = new ArrayList<>();
        for (Integer documentId : documentIds) {
            Optional<DocumentEntity> document = documentRepository.findById(documentId);
            document.ifPresent(documentEntities::add);
        }

        return documentEntities;
    }


}
