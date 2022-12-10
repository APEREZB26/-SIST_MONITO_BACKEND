package com.sist_monito_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "surveys")
public class Survey implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id_survey")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idSurvey;

   @ManyToOne()
   @JoinColumn(name = "id_agent")
   @JsonBackReference
   private Agent agent;

   @NotEmpty(message = "Can not be empty")
   @Column(nullable = false)
   private String audio_url;

   @OneToOne(cascade = CascadeType.ALL, mappedBy = "survey")
   @JsonBackReference
   private Audit audit;

   @Column(name = "created_at")
   @Temporal(TemporalType.DATE)
   private Date createdAt;

   @PrePersist
   public void prePersist() {
      createdAt = new Date();
   }
}
