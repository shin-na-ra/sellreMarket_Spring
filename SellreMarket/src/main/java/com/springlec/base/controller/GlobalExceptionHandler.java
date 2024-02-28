package com.springlec.base.controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errorpage"); // 에러 페이지의 JSP 파일명 또는 경로
        return modelAndView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFoundException(NoHandlerFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errorpage"); // 에러 페이지의 JSP 파일명 또는 경로
        return modelAndView;
    }
}