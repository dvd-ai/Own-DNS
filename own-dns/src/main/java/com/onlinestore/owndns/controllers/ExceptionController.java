package com.onlinestore.owndns.controllers;

import com.onlinestore.owndns.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*
* Это мой первый контроллер для перехвата исключений
* и я не знаю как он работает. Проверим при запуске
* */
@ControllerAdvice
public class ExceptionController {


@ExceptionHandler(OrderNotFoundException.class)
public ResponseEntity<?> handleException(OrderNotFoundException e){
    return new ResponseEntity<>("Order with current id not found", HttpStatus.NOT_FOUND);

}

}
