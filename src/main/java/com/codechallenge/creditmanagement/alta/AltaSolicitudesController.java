package com.codechallenge.creditmanagement.alta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.creditmanagement.alta.dto.AltaSolicitudRequest;

@RestController
@RequestMapping("/solicitud/alta")
public class AltaSolicitudesController {

    private final AltaSolicitudesService altaSolicitudesService;

    @Autowired
    public AltaSolicitudesController(AltaSolicitudesService altaSolicitudesService) {
        this.altaSolicitudesService = altaSolicitudesService;
    }

    @PostMapping
    public ResponseEntity<String> altaSolicitud(@RequestBody AltaSolicitudRequest solicitudRequest) {
        altaSolicitudesService.procesarAltaSolicitud(solicitudRequest);
        return new ResponseEntity<>("Solicitud ingresada exitosamente.", HttpStatus.OK);
    }
}
