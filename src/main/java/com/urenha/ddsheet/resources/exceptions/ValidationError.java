package com.urenha.ddsheet.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

    public ValidationError() {
    }

    public ValidationError(long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<ValidationMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationMessage> errors) {
        this.errors = errors;
    }

    public void addError(String fieldName, String message){
        this.errors.add(new ValidationMessage(fieldName, message));
    }
}
