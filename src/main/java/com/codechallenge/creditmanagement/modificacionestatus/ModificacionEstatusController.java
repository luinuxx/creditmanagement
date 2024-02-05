package com.codechallenge.creditmanagement.modificacionestatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.creditmanagement.CreditRequestService;
import com.codechallenge.creditmanagement.alta.model.Client;
import com.codechallenge.creditmanagement.alta.model.CreditRequest;
import com.codechallenge.creditmanagement.alta.model.Notification;
import com.codechallenge.creditmanagement.alta.repository.NotificationRepository;
import com.codechallenge.creditmanagement.modificacionestatus.dto.ModificacionEstatusRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/solicitud/modificar")
public class ModificacionEstatusController {
	@Autowired
    private CreditRequestService creditRequestService;  

    @Autowired
    private ModificacionEstatusService modificacionEstatusService; 

    @Autowired
    private ObtenerDatosSolicitudService obtenerDatosSolicitudService;  
    
    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping
    public ResponseEntity<String> modificarEstatusSolicitud(@RequestBody ModificacionEstatusRequest request) {
        try {
            // 1. Verificar si existe la solicitud en credit_request.
            if (!creditRequestService.existeSolicitud(request.getIdSolicitud())) {
                return new ResponseEntity<>("La solicitud no existe en credit_request", HttpStatus.BAD_REQUEST);
            }

            // 2. Verificar si existe la solicitud en credit_request_log con estatus de error.
            if (modificacionEstatusService.existeSolicitudConError(request.getIdSolicitud())) {
                return new ResponseEntity<>("La solicitud tiene un estatus de error en credit_request_log", HttpStatus.BAD_REQUEST);
            }

            // 3. Consultar el servicio obtenerDatosSolicitud y cliente si es necesario.
            CreditRequest datosSolicitud = obtenerDatosSolicitudService.obtenerDatosSolicitud(request.getIdSolicitud());
            Client cliente = obtenerDatosSolicitudService.obtenerCliente(request.getIdSolicitud());

            // 4. Actualizar el estatus y registrar en credit_request_log si algo sale mal.
            boolean actualizacionExitosa = creditRequestService.actualizarEstatusSolicitud(request.getIdSolicitud(), request.getIdEstatus());

            if (!actualizacionExitosa) {
            	modificacionEstatusService.registrarEnLogConError(request.getIdSolicitud(), request.getMotivo());
                return new ResponseEntity<>("Error en la actualización de estatus", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
         // Enviar notificación al promotor
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
            String formattedString = localDate.format(format);
            Notification notification = new Notification(request.getIdSolicitud(), "Cambio de estatus de la solicitud.", formattedString );
            notificationRepository.save(notification);

            return new ResponseEntity<>("Modificación de estatus exitosa", HttpStatus.OK);
        } catch (Exception e) {
            // Manejar otras excepciones si es necesario.
            return new ResponseEntity<>("Error en el procesamiento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
