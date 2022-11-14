package com.sist_monito_backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "id_client")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idClient;

   @NotEmpty(message = "Can not be empty")
   @Column(nullable = false)
   private String fullname;

   @NotEmpty(message = "Can not be empty")
   @Column(nullable = false)
   private String phoneNumber;

   //TODO: Falta la relación con DetailSurvey
}
