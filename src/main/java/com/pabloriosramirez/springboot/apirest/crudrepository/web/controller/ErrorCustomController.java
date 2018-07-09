/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */

package com.pabloriosramirez.springboot.apirest.crudrepository.web.controller;

import com.pabloriosramirez.springboot.apirest.crudrepository.web.controller.exception.util.ErrorDetails;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Pablo Rios
 */
@RestController
public class ErrorCustomController implements ErrorController {

    //GET 
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/error", headers = "Accept=application/json")
    public ResponseEntity<?> getError(HttpServletRequest httpRequest, WebRequest request) {
        String errorMsg = "";
        int httpErrorCode = (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
        HttpStatus status;
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Código de error HTTP: 400 - La solicitud contiene sintaxis errónea";
                status = HttpStatus.BAD_REQUEST;
                break;
            }
            case 401: {
                errorMsg = "Código de error HTTP: 401 - Necesita autorización para ingresar al recurso, autentificación es posible pero ha fallado o aún no ha sido provista.";
                status = HttpStatus.UNAUTHORIZED;
                break;
            }
            case 404: {
                errorMsg = "Código de error HTTP: 404 - Recurso no encontrado. Servidor web no encuentra la página o recurso solicitado.";
                status = HttpStatus.NOT_FOUND;
                break;
            }
            case 500: {
                errorMsg = "Código de error HTTP: 500 - Error interno del servidor.";
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            }
            default: {
                errorMsg = "Código de error HTTP:" + httpErrorCode + " - Favor comuniquese con el administrador del sistema.";
                status = HttpStatus.valueOf(httpErrorCode);
                break;
            }
        }

        return new ResponseEntity(new ErrorDetails(errorMsg, request.getDescription(false)), status);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
