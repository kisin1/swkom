package org.openapitools.integrationTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import io.minio.MinioClient;
import io.minio.StatObjectArgs;
import org.openapitools.persistence.entities.DocumentEntity;
import org.openapitools.persistence.repositories.DocumentRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DocumentServiceImplIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private MinioClient minioClient;

    // RabbitTemplate omitted for simplicity

    @Test
    void testUploadDocument() throws Exception {
        String filename = "test.pdf";
        MockMultipartFile file = new MockMultipartFile(
                "document",
                filename,
                MediaType.APPLICATION_PDF_VALUE,
                "PDF content".getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/documents/post_document/")
                        .file(file)
                        .param("title", "Test Document")
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());

        // Database Verification
        List<DocumentEntity> documents = documentRepository.findAll();
        assertTrue(documents.stream().anyMatch(doc -> doc.getStoragePath().getName().equals(filename)),
                "Document not found in the database");

        // Minio Storage Verification
        String bucketName = "paperless-files"; // Replace with your bucket name
        StatObjectArgs statObjectArgs = StatObjectArgs.builder().bucket(bucketName).object(filename).build();
        assertTrue(minioClient.statObject(statObjectArgs).size() > 0, "Document not found in Minio");

        // RabbitMQ verification logic (omitted for simplicity)
    }
}
