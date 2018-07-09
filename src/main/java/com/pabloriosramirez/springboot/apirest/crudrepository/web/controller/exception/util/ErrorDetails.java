/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */

package com.pabloriosramirez.springboot.apirest.crudrepository.web.controller.exception.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorDetails {

    private String date;
    private String message;
    private String details;

    public ErrorDetails(String message, String details) {
        super();
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.date = dt1.format(new Date()); 
        this.message = message;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
