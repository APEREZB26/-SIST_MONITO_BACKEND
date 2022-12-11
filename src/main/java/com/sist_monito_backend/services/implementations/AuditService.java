package com.sist_monito_backend.services.implementations;

import com.sist_monito_backend.entities.Audit;
import com.sist_monito_backend.repositories.AuditRepository;
import com.sist_monito_backend.services.interfaces.IAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditService implements IAuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Audit> findByAgentId(Long id) {
        return auditRepository.findByAgentId(id);
    }

    @Override
    public void save(Audit audit) {
        auditRepository.save(audit);
    }
}
