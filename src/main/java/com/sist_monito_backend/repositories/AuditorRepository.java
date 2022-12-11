package com.sist_monito_backend.repositories;

import com.sist_monito_backend.entities.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, Long> {
   @Query("SELECT a FROM Auditor a inner join User u on a.user.idUser = u.idUser where u.email = ?1")
   Optional<Auditor> findByEmail(String email);
}
