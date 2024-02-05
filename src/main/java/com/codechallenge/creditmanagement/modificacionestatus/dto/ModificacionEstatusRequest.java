package com.codechallenge.creditmanagement.modificacionestatus.dto;

import java.util.List;

import com.codechallenge.creditmanagement.alta.dto.SolicitudRequest;
import com.codechallenge.creditmanagement.modificacionestatus.model.Motivo;

public class ModificacionEstatusRequest {
	private Long idSolicitud;
	private String idEstatus;
    private List<Motivo> motivo;
    private String fechaCambio;
    private SolicitudRequest solicitud;

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
    
    public List<Motivo> getMotivo(){
    	return motivo;
    }
    
    public void setMotivo(List<Motivo> motivo) {
    	this.motivo = motivo;
    }
    
    public String getFechaCambio() {
    	return fechaCambio;
    }
    
    public void setFechaCambio(String fechaCambio) {
    	this.fechaCambio = fechaCambio;
    }

    public SolicitudRequest getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudRequest solicitud) {
        this.solicitud = solicitud;
    }
}

