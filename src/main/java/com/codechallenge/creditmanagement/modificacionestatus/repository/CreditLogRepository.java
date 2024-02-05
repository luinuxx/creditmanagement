package com.codechallenge.creditmanagement.modificacionestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.creditmanagement.modificacionestatus.model.CreditRequestLog;

@Repository
public interface CreditLogRepository extends JpaRepository<CreditRequestLog, Long> {
    boolean existsByIdSolicitudAndEstatus(Long idSolicitud, String estatus);
    
}
