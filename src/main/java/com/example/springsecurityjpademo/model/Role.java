package com.example.springsecurityjpademo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(name = "role_name_unique", columnNames = { "name" }) })
@NoArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq_generator")
    @SequenceGenerator(name = "roles_id_seq_generator", sequenceName = "roles_id_seq", allocationSize = 10,
            initialValue = 10)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Role(String name) {
        this.name = name;
    }

}
