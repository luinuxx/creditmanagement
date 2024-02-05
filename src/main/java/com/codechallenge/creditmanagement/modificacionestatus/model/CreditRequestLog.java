package com.codechallenge.creditmanagement.modificacionestatus.model;


import com.codechallenge.creditmanagement.alta.model.CreditRequest;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CreditRequestLog")
public class CreditRequestLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegistro;
	
	
	private String idEstatus;
	
	private String estatus;
	
	@ManyToOne
	private Motivo motivo;
	
	private Long idMotivo;
	
    private String fechaCambio;
    
    @ManyToOne
    private CreditRequest solicitud;
    
    private Long idSolicitud;
    
    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }
    
    public CreditRequest getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(CreditRequest solicitud) {
        this.solicitud = solicitud;
    }
    
    public Long getIdSolicitud() {
    	return idSolicitud;
    }
    
    public void setIdSolicitud(Long idSolicitud) {
    	this.idSolicitud = idSolicitud;
    }

    public String getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(String idEstatus) {
        this.idEstatus = idEstatus;
    }
    
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    public Motivo getMotivo(){
    	return motivo;
    }
    
    public void setMotivo(Motivo motivo) {
    	this.motivo = motivo;
    }
    
    public Long getIdMotivo() {
    	return idMotivo;
    }
    
    public void setIdMotivo(Long idMotivo) {
    	this.idMotivo = idMotivo;
    }
    
    public String getFechaCambio() {
    	return fechaCambio;
    }
    
    public void setFechaCambio(String fechaCambio) {
    	this.fechaCambio = fechaCambio;
    }
}
