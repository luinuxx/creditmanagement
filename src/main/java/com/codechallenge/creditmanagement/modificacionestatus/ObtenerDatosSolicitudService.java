package com.codechallenge.creditmanagement.modificacionestatus;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallenge.creditmanagement.alta.model.Client;
import com.codechallenge.creditmanagement.alta.model.CreditRequest;
import com.codechallenge.creditmanagement.alta.repository.ClientRepository;
import com.codechallenge.creditmanagement.alta.repository.CreditRequestRepository;

@Service
public class ObtenerDatosSolicitudService implements ObtenerDatosSolicitudInterface {
	@Autowired
    private CreditRequestRepository datosSolicitudRepository;
    @Autowired
    private ClientRepository clienteRepository; 

    @Override
    public CreditRequest obtenerDatosSolicitud(Long idSolicitud) {
    	Optional<CreditRequest> optionalCreditRequest = datosSolicitudRepository.findById(idSolicitud);
        return optionalCreditRequest.orElse(null); 
    }

    @Override
    public Client obtenerCliente(Long idSolicitud) { 
    	Optional<Client> optionalClientRequest = clienteRepository.findById(idSolicitud);
    	return optionalClientRequest.orElse(null); 
    }
}