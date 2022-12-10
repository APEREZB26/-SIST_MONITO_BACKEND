package com.sist_monito_backend.controllers;

import com.sist_monito_backend.entities.Audit;
import com.sist_monito_backend.services.interfaces.IAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/audit")
@RestController
public class AuditController {
    @Autowired
    private IAuditService auditService;

    @GetMapping("/audits/agent/{id}")
    public List<Audit> getAuditById(@PathVariable Long id) {
        return auditService.findByAgentId(id);
    }
}
