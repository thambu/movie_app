package com.dws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resource;
    private String id;
    private long value;

    public ResourceNotFoundException(String resource, String id, long value) {
        super(String.format("%s not found for %s : '%s'", resource, id, value));
        this.resource = resource;
        this.id = id;
        this.value = value;
    }

    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }

    public long getValue() {
        return value;
    }
}
