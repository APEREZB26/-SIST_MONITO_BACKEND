package com.sist_monito_backend.controllers;

import com.sist_monito_backend.entities.Agent;
import com.sist_monito_backend.entities.User;
import com.sist_monito_backend.services.interfaces.IAgentService;
import com.sist_monito_backend.utils.ValidateErrorsFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/auth")
@RestController
public class AuthController {
   ValidateErrorsFields validateErrorsFields = new ValidateErrorsFields();

   @Autowired
   private IAgentService agentService;

   @PostMapping("/login-agent")
   public ResponseEntity<?> loginAgent(@RequestBody User user) {
      Map<String, Object> response = new HashMap<>();
      Optional<Agent> agentLogin;

      try {
         agentLogin = agentService.findByEmail(user.getEmail());

         if (agentLogin.isEmpty()) {
            response.put("message", "User does not exist");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
         }

         response.put("agent", agentLogin);
         return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (DataAccessException e) {
         response.put("message", "Error deleting client in the database");
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

   @PostMapping("/register-agent")
   public ResponseEntity<?> createAgent(@Valid @RequestBody Agent agent, BindingResult result) {
      Map<String, Object> response = new HashMap<>();

      if (validateErrorsFields.validateErrors(result, response))
         return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

      try {
         agentService.save(agent);
         response.put("message", "Agent created successfully");
         return new ResponseEntity<>(response, HttpStatus.CREATED);
      } catch (DataAccessException e) {
         response.put("message", "Error inserting into database");
         response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}


