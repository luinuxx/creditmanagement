package com.codechallenge.creditmanagement.alta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codechallenge.creditmanagement.alta.dto.AltaSolicitudRequest;
import com.codechallenge.creditmanagement.alta.model.Client;
import com.codechallenge.creditmanagement.alta.model.CreditRequest;
import com.codechallenge.creditmanagement.alta.model.Notification;
import com.codechallenge.creditmanagement.alta.repository.ClientRepository;
import com.codechallenge.creditmanagement.alta.repository.CreditRequestRepository;
import com.codechallenge.creditmanagement.alta.repository.NotificationRepository;

import jakarta.transaction.Transactional;

@Service
public class AltaSolicitudesService {
    private final CreditRequestRepository creditRequestRepository;
    private final ClientRepository clientRepository;
    private final NotificationRepository notificationRepository;
    
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Autowired
    public AltaSolicitudesService(CreditRequestRepository creditRequestRepository, ClientRepository clientRepository, NotificationRepository notificationRepository) {
        this.creditRequestRepository = creditRequestRepository;
        this.clientRepository = clientRepository;
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public void procesarAltaSolicitud(AltaSolicitudRequest solicitudRequest) {
        // Simular la extracción de información adicional
        Client mockClient = new Client();
        mockClient.setNombre(solicitudRequest.getCliente().getNombre());
        mockClient.setApellidoPaterno(solicitudRequest.getCliente().getApellidoPaterno());
        mockClient.setApellidoMaterno(solicitudRequest.getCliente().getApellidoMaterno());

        // Simular la extracción de información adicional para la solicitud
        CreditRequest mockSolicitud = new CreditRequest();
        mockSolicitud.setIdSolicitud(solicitudRequest.getSolicitud().getIdSolicitud());
        mockSolicitud.setMonto(solicitudRequest.getSolicitud().getMonto());
        mockSolicitud.setProducto(solicitudRequest.getSolicitud().getProducto());
        mockSolicitud.setTipoSolicitudStr(solicitudRequest.getSolicitud().getTipoSolicitudStr());
        mockSolicitud.setIdTipoSolicitud(solicitudRequest.getSolicitud().getIdTipoSolicitud());
        mockSolicitud.setTasa(solicitudRequest.getSolicitud().getTasa());
        mockSolicitud.setPlazo(solicitudRequest.getSolicitud().getPlazo());
        mockSolicitud.setFrecuencia(solicitudRequest.getSolicitud().getFrecuencia());
        mockSolicitud.setFechaSolicitud(solicitudRequest.getSolicitud().getFechaSolicitud());
        mockSolicitud.setPromotor(solicitudRequest.getPromotor());
        mockSolicitud.setEmpresa(solicitudRequest.getEmpresa());
        mockSolicitud.setEstatus("Ingresado");


        // Guardar la información del cliente en la base de datos
        Client savedClient = clientRepository.save(mockClient);

        // Asignar el cliente a la solicitud simulada
        mockSolicitud.setClient(savedClient);

        // Guardar la solicitud en la base de datos
        CreditRequest savedRequest = creditRequestRepository.save(mockSolicitud);
        
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedString = localDate.format(format);
        // Enviar notificación al promotor
        Notification notification = new Notification(savedRequest.getIdSolicitud(), "Nueva solicitud ingresada.", formattedString );
        notificationRepository.save(notification);

        // Asignar un estatus inicial a la solicitud (por ejemplo, "Ingresada")
       /* creditRequest.setEstatus("Ingresada");*/

        // Establecer la fecha de solicitud como la fecha actual si no está especificada
        /*if (creditRequest.getFechaSolicitud() == null) {
            creditRequest.setFechaSolicitud(LocalDate.now());
        }*/
    }
}
