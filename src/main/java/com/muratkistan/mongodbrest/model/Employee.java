package com.muratkistan.mongodbrest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Employee")
public class Employee {

    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String firstName;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String lastName;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String emailId;

}
