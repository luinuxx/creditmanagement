package com.codechallenge.creditmanagement.modificacionestatus;

import com.codechallenge.creditmanagement.alta.model.Client;
import com.codechallenge.creditmanagement.alta.model.CreditRequest;

public interface ObtenerDatosSolicitudInterface {
    CreditRequest obtenerDatosSolicitud(Long idSolicitud);
    Client obtenerCliente(Long idCliente);
}
