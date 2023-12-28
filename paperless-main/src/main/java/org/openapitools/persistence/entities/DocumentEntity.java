package org.openapitools.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    @Column
    private Integer id;

    @NotBlank
    @Column
    private Integer correspondent;

    @NotBlank
    @Column(name = "document_type")
    private Integer documentType;

    @NotBlank
    @Column(name = "storage_path")
    private Integer storagePath;

    @NotBlank
    @Column
    private String title;

    @NotBlank
    @Column
    private String content;

    @NotBlank
    @ElementCollection
    @CollectionTable(name = "document_tags", joinColumns = @JoinColumn(name = "document_id"))
    @Column(name = "tag")
    private List<Integer> tags; // @ElementCollection is used to indicate that tags is a collection of values that should be stored in a separate table (document_tags)

    @NotBlank                   // The @CollectionTable annotation is used to specify the name of the table for the collection, and @Column(name = "tag") is used to specify the name of the column in the collection table where each element of the tags list will be stored.
    @Column
    private OffsetDateTime created;

    @NotBlank
    @Column(name = "created_date")
    private OffsetDateTime createdDate;

    @NotBlank
    @Column
    private OffsetDateTime modified;

    @NotBlank
    @Column
    private OffsetDateTime added;

    @NotBlank
    @Column(name = "archive_serial_number")
    private String archiveSerialNumber;

    @NotBlank
    @Column(name = "original_file_name")
    private String originalFileName;

    @NotBlank
    @Column(name = "archived_file_name")
    private String archivedFileName;
}