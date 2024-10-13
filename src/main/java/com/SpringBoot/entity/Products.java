package com.SpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products implements Serializable {

    @Id
    @GeneratedValue
    private long productId;
    @NotBlank(message = "product name cannot be blank")
    @Size(max = 50, message = "product name cannot exceed 100 characters")
    private String productName;
    @NotBlank(message = "product Description cannot be blank")
    @Size(max = 50, message = "product Description cannot exceed 100 characters")
    private String productDescription;
    @NotNull
    private long productPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Kolkata")
    private ZonedDateTime launchDate;

    @PrePersist
    @PreUpdate
    public void setTimeZone() {
        if (launchDate == null) {
            launchDate = ZonedDateTime.now();
        }
        launchDate = launchDate.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    }

//    The @PrePersist and @PreUpdate annotations in this method are lifecycle hooks in JPA (Java Persistence API) that allow you to run specific logic right before the entity is saved or updated in the database. Let's break down the method and its purpose:
//    @PrePersist:
//    This annotation marks a method to be executed before the entity is persisted in the database (i.e., before an INSERT operation occurs).
//    @PreUpdate:
//    This annotation marks a method to be executed before the entity is updated in the database (i.e., before an UPDATE operation occurs).

}
