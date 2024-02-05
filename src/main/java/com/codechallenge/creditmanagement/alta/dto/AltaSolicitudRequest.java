package com.codechallenge.creditmanagement.alta.dto;

public class AltaSolicitudRequest {
	private String promotor;
    private String empresa;
    private ClienteRequest cliente;
    private SolicitudRequest solicitud;

    public String getPromotor() {
        return promotor;
    }

    public void setPromotor(String promotor) {
        this.promotor = promotor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public ClienteRequest getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequest cliente) {
        this.cliente = cliente;
    }

    public SolicitudRequest getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudRequest solicitud) {
        this.solicitud = solicitud;
    }
}
