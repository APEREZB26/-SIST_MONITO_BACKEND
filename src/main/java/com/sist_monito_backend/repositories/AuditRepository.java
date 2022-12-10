package com.sist_monito_backend.repositories;

import com.sist_monito_backend.entities.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {

    @Query("SELECT au, s FROM Audit au INNER JOIN Survey s ON au.survey.idSurvey = s.idSurvey INNER JOIN Agent a ON a.idAgent = s.agent.idAgent WHERE a.idAgent = ?1")
    List<Audit> findByAgentId(Long id);
}
