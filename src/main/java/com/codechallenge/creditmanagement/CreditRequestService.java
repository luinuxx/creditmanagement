package com.codechallenge.creditmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallenge.creditmanagement.alta.repository.CreditRequestRepository;

@Service
public class CreditRequestService {

    @Autowired
    private CreditRequestRepository creditRequestRepository; 

    public boolean existeSolicitud(Long idSolicitud) {
        // Implementa la lógica para verificar la existencia de la solicitud en credit_request.
        // Puedes utilizar el repositorio para realizar consultas en la base de datos.

        // Ejemplo ficticio:
        return creditRequestRepository.existsById(idSolicitud);
    }
    
    public boolean actualizarEstatusSolicitud(Long idSolicitud, String nuevoEstatus) {
        try {
        	creditRequestRepository.actualizarEstatus(idSolicitud, nuevoEstatus);
        	return true;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
        
    }
}
