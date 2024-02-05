package com.codechallenge.creditmanagement.alta.repository;

import com.codechallenge.creditmanagement.alta.model.CreditRequest;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRequestRepository extends JpaRepository<CreditRequest, Long> {
	@Modifying
    @Transactional
    @Query("UPDATE CreditRequest cr SET cr.estatus = ?2 WHERE cr.idSolicitud = ?1")
    void actualizarEstatus(Long idSolicitud, String nuevoEstatus);
}
