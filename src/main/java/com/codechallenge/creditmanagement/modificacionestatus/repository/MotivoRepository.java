package com.codechallenge.creditmanagement.modificacionestatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.creditmanagement.modificacionestatus.model.Motivo;

@Repository
public interface MotivoRepository extends JpaRepository<Motivo, Long> {    
}