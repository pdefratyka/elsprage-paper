package com.elsprage.paper.common.exception;

public class TopicException extends RuntimeException {

    public TopicException(String message){

    }

    public static class TopicDoesNotExistException extends TopicException{
        public TopicDoesNotExistException(long id){
            super("Topic with id: "+id+" does not exists");
        }
    }
}
