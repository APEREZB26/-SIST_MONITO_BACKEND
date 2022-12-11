package com.sist_monito_backend.services.interfaces;

import com.sist_monito_backend.entities.Auditor;

import java.util.Optional;

public interface IAuditorService {
   Optional<Auditor> findByEmail(String email);
}
