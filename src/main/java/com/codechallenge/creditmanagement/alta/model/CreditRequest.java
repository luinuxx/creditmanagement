package com.codechallenge.creditmanagement.alta.model;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CreditRequest")
public class CreditRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    private String promotor;
    private String empresa;
    private Long idCliente;
    private String estatus;
    private Double monto;
    private String producto;
    private String tipoSolicitudStr;
    private String idTipoSolicitud;
    private Double tasa;
    private Integer plazo;
    private String frecuencia;
    private String fechaSolicitud;

    @ManyToOne
    private Client client;


    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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

    public Long getIdCliente(){
        return idCliente;
    }

    public void setIdCliente(Long idCliente){
        this.idCliente = idCliente;
    }

    public String getEstatus() {
        return  estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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