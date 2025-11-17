package com.ecommerce.carritocompras.exception;

import com.ecommerce.carritocompras.util.Constantes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class CarritoExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e, RedirectAttributes redirectAttributes) {
        String mensaje = e.getMessage();
        if (mensaje == null || mensaje.isEmpty()) {
            mensaje = "Ha ocurrido un error inesperado";
        }
        redirectAttributes.addFlashAttribute(Constantes.ATTR_ERROR, mensaje);
        return Constantes.REDIRECT_PRODUCTOS;
    }
}

