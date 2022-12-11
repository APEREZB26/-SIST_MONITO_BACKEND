package com.sist_monito_backend.controllers;

import com.sist_monito_backend.entities.Survey;
import com.sist_monito_backend.services.interfaces.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/survey")
@RestController
public class SurveyController {
   @Autowired
   private ISurveyService surveyService;
   @PostMapping(value="/create", consumes={"application/json"})
   public ResponseEntity<?> createSurvey(@RequestBody Survey survey) {

      Map<String, Object> response = new HashMap<>();
      System.out.println(survey);

      try {
         surveyService.save(survey);
         response.put("message", "Survey created successfully");
         return new ResponseEntity<>(response, HttpStatus.CREATED);
      } catch (DataAccessException e) {
         response.put("message", e.getMessage());
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}
