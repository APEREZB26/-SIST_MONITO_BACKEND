package com.sist_monito_backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "auditors")

public class Auditor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_auditor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuditor;

    @NotEmpty(message = "Can not be empty")
    @Size(min = 4, max = 20, message = "The size must be between 4 and 20 characters")
    @Column(nullable = false)
    private String fullname;

    @NotEmpty(message = "Can not be empty")
    private String dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonManagedReference
    private User user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "auditor")
    @JsonManagedReference
    private Audit audits;

}
