package com.sist_monito_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "audios")
public class Audio implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id_audio")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idAudio;

   @NotEmpty(message = "Can not be empty")
   @Column(nullable = false)
   private String url;

   @OneToOne(cascade = CascadeType.ALL, mappedBy = "audio")
   @JsonBackReference
   private Survey survey;
}
