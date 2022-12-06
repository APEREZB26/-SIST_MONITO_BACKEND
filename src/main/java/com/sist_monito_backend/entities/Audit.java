package com.sist_monito_backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "audits")

public class Audit implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_audit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAudit;

    @NotEmpty(message = "Can not be empty")
    private Double score1;

    @NotEmpty(message = "Can not be empty")
    private Double score2;

    @NotEmpty(message = "Can not be empty")
    private Double score3;

    @NotEmpty(message = "Can not be empty")
    private Double scoreFinal;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @NotEmpty(message = "Can not be empty")
    @Size(min = 5, max = 200, message = "The size must be between 5 and 200 characters")
    @Column(nullable = false)
    private String feedback;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_auditor")
    @JsonManagedReference
    private Auditor auditor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_survey")
    @JsonManagedReference
    private Survey survey;

}
