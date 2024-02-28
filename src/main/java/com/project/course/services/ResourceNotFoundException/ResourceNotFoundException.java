package com.project.course.services.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}