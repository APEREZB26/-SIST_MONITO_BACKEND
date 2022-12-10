package com.sist_monito_backend.services.interfaces;

import com.sist_monito_backend.entities.Audit;

import java.util.List;


public interface IAuditService {
    List<Audit> findByAgentId(Long id);
}
