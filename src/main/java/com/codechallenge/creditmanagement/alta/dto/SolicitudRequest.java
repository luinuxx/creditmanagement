package com.codechallenge.creditmanagement.alta.dto;

public class SolicitudRequest {
	private Long idSolicitud;
	private Double monto;
	private String producto;
	private String tipoSolicitudStr;
    private String idTipoSolicitud;
    private Double tasa;
    private Integer plazo;
    private String frecuencia;
    private String fechaSolicitud;
    
    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto){
        this.monto = monto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTipoSolicitudStr() {
        return tipoSolicitudStr;
    }

    public void setTipoSolicitudStr(String tipoSolicitudStr) {
        this.tipoSolicitudStr = tipoSolicitudStr;
    }

    public String getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(String idTipoSolicitud){
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
