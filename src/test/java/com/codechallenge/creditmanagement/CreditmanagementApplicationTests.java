package com.codechallenge.creditmanagement;




import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CreditmanagementApplicationTests {
	 @Autowired
	    private TestRestTemplate restTemplate;
	/*@Test
	void contextLoads() {
	}*/
	@Test
    public void testProcesarAltaSolicitud() {
        // Configuración de la petición de prueba
        String url = "/solicitud/alta";
        String requestBody = ""; 
        try {
        	 InputStream inputStream = getClass().getClassLoader().getResourceAsStream("solicitudAlta.json");

             if (inputStream != null) {
                 try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                     requestBody = scanner.useDelimiter("\\A").next();
                 }
             } else {
                 System.err.println("No se pudo cargar el archivo JSON");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        // Realiza la solicitud HTTP
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        // Verifica que la respuesta sea exitosa (código HTTP 2xx)
        assert(response.getStatusCode().is2xxSuccessful());
    }

}
