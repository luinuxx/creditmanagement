package com.codechallenge.creditmanagement.modificacionestatus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CreditRequestLogMotivo")
public class Motivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMotivo;
	
	@Column(columnDefinition = "TEXT")
    private String codigo;
	@Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "idRegistro", columnDefinition = "INTEGER")
    private CreditRequestLog creditRequestLog;
    
    public Long getIdMotivo() {
    	return idMotivo;
    }
    
    public void setIdMotivo(Long idMotivo) {
    	this.idMotivo = idMotivo;
    }
    
    public CreditRequestLog getCreditRequestLog() {
    	return creditRequestLog;
    }
    
    public void setCreditRequestLog(CreditRequestLog creditRequestLog) {
    	this.creditRequestLog = creditRequestLog;
    }

    public String getCodigo() {
    	return codigo;
    }
    
    public void setCodigo(String codigo) {
    	this.codigo = codigo;
    }
    
    public String getDescripcion() {
    	return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }
}
