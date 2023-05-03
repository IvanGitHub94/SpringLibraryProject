package com.jpcsaturday.SpringLibraryProject.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SequenceGenerator(name = "default_generator", sequenceName = "author_sequence", allocationSize = 1)
public class Author extends GenericModel{

    @Column(name = "fio", nullable = false)
    private String authorFIO;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "description")
    private String description;
}

