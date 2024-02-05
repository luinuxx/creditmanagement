# Proyecto de Gestión de Solicitudes de Crédito

## Descripción
Este proyecto implementa servicios para la gestión de solicitudes de crédito, incluyendo la alta y modificación de estatus de las solicitudes.

## Estructura del Proyecto
- **alta-solicitudes:** Contiene el servicio de alta de solicitudes.
- **modificacion-estatus:** Contiene el servicio de modificación de estatus de solicitudes.

## Tecnologías Utilizadas
- Java
- Spring Boot
- Hibernate
- PostgreSQL
- Docker

## Servicios Implementados

### Alta de Solicitudes
- **Path:** `/solicitud/alta`
- **Método:** POST
- **Ejemplo de Petición:**
  ```json
  {
    "promotor": "SLP34/CURP",
    "empresa": "XXXXX",
    "cliente": {
      "nombre": "PERLA TOMASA",
      "apellidoPaterno": "CABRERA",
      "apellidoMaterno": "ROMAN"
    },
    "solicitud": {
      "idSolicitud": "110102044798",
      "monto": 167000,
      "producto": "IMSS",
      "tipoSolicitudStr": "CREDITO NUEVO",
      "idTipoSolicitud": "394",
      "tasa": 39,
      "plazo": 0,
      "frecuencia": "Semanal/Mensual/Catorcenal",
      "fechaSolicitud": "20220727"
    }
  }
### Modificación de Estatus de Solicitudes
- **Path:** `/solicitud/modificar`
- **Método:** POST
- **Ejemplo de Petición:**
  ```json
  {
  "idSolicitud": "110102044798",
  "idEstatus": "APROB",
  "motivo": [
    {"codigo": "123", "descripcion": "Documentos incompletos"}
  ],
  "fechaCambio": "20220727"
  }

## Configuración y ejecución
- Clona este repositorio: git clone <URL_DEL_REPOSITORIO>
- Abre cada servicio en tu entorno de desarrollo.
- Configura las propiedades del archivo application.properties para la conexión a la base de datos PostgreSQL.
- Ejecuta cada servicio como una aplicación Spring Boot.
