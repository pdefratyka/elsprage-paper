package com.elsprage.paper.common.exception;

public class TagException extends RuntimeException {

    public TagException(String message){

    }

    public static class TagDoesNotExistException extends TagException {
        public TagDoesNotExistException(long id){
            super("Tag with id: "+id+" does not exists");
        }
    }
}
