package com.example.springsecurityjpademo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(name = "role_name_unique", columnNames = { "name" }) })
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq_generator")
    @SequenceGenerator(name = "roles_id_seq_generator", sequenceName = "roles_id_seq", allocationSize = 10,
            initialValue = 10)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
