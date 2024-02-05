package com.codechallenge.creditmanagement.modificacionestatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallenge.creditmanagement.modificacionestatus.model.CreditRequestLog;
import com.codechallenge.creditmanagement.modificacionestatus.model.Motivo;
import com.codechallenge.creditmanagement.modificacionestatus.repository.CreditLogRepository;
import com.codechallenge.creditmanagement.modificacionestatus.repository.MotivoRepository;

@Service
public class ModificacionEstatusService implements ModificacionEstatusInterface {

    @Autowired
    private CreditLogRepository creditLogRepository;
    
    @Autowired
    private MotivoRepository motivoRepository;

    @Override
    public boolean existeSolicitudConError(Long idSolicitud) {
        return creditLogRepository.existsByIdSolicitudAndEstatus(idSolicitud, "ERROR");
    }
    
    public void registrarEnLogConError(Long idSolicitud, List<Motivo> motivo) {
    	CreditRequestLog log = new CreditRequestLog();
    	Motivo mot = new Motivo();
        log.setIdSolicitud(idSolicitud);
        mot.setCodigo(motivo.get(0).toString());
        mot.setDescripcion(motivo.get(1).toString());
        Motivo savedMotivo = motivoRepository.save(mot);
        log.setMotivo(savedMotivo);

        creditLogRepository.save(log);
    }
}
