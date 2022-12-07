package com.sist_monito_backend.services.implementations;

import com.sist_monito_backend.entities.Survey;
import com.sist_monito_backend.repositories.SurveyRepository;
import com.sist_monito_backend.services.interfaces.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService implements ISurveyService {
   @Autowired
   private SurveyRepository surveyRepository;

   @Override
   public void save(Survey survey) {
      surveyRepository.save(survey);
   }
}
