package com.sist_monito_backend.services.interfaces;

import com.sist_monito_backend.entities.Survey;

import java.util.List;

public interface ISurveyService {
   List<Survey> findByAgentId(Long id);

   void save(Survey survey);
}
