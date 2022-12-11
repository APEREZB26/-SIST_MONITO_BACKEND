package com.sist_monito_backend.repositories;

import com.sist_monito_backend.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
   @Query("SELECT s, a FROM Survey s INNER JOIN Agent a ON s.agent.idAgent = a.idAgent WHERE a.idAgent = ?1")
   List<Survey> findByAgentId(Long id);
}
