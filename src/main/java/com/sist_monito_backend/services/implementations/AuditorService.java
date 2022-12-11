package com.sist_monito_backend.services.implementations;

import com.sist_monito_backend.entities.Auditor;
import com.sist_monito_backend.repositories.AuditorRepository;
import com.sist_monito_backend.services.interfaces.IAuditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorService implements IAuditorService {
   @Autowired
   private AuditorRepository auditorRepository;

   @Override
   public Optional<Auditor> findByEmail(String email) {
      return auditorRepository.findByEmail(email);
   }
}
