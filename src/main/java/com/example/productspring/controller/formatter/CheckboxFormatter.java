package com.example.productspring.controller.formatter;

import lombok.extern.log4j.Log4j2;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

@Log4j2
public class CheckboxFormatter implements Formatter<Boolean> {


    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        log.info("!!!!!!!! CHECKBOX FORMATTING!!!!!!!!!!!" + text);
        if(text == null){
            return false;
        }
        return text.equals("on");
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
