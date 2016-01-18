package bz.pock.restcontroller.impl;

import bz.pock.restcontroller.dto.MessageDTO;
import bz.pock.restcontroller.dto.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

@ControllerAdvice
public class ControllerValidationHandler {
    @Autowired
    private MessageSource msgSource;

    /**
     * Transfomateur d'exception en message d'erreur.
     *
     * @param ex argument non valide
     * @return message
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        FieldError error = result.getFieldError();

        return processFieldError(error);
    }

    /**
     * Transforme une erreur.
     *
     * @param error erreur existante
     * @return message
     */
    private MessageDTO processFieldError(FieldError error) {
        MessageDTO message = null;
        if (error != null) {
            Locale currentLocale = LocaleContextHolder.getLocale();
            String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
            message = new MessageDTO(MessageType.ERROR, msg);
        }
        return message;
    }
}
