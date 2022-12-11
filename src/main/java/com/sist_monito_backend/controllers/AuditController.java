package com.sist_monito_backend.controllers;

import com.sist_monito_backend.entities.Audit;
import com.sist_monito_backend.services.interfaces.IAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value="/create", consumes={"application/json"})
    public ResponseEntity<?> createSurvey(@RequestBody Audit audit) {
        Map<String, Object> response = new HashMap<>();
        double score;

        try {
            score = (audit.getScore1()*8)+(audit.getScore2()*8)+(audit.getScore3()*4) ;
            auditService.save(audit);
            response.put("message", "Audit created successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
