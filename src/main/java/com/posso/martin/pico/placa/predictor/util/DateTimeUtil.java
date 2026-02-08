package com.posso.martin.pico.placa.predictor.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * @author Martin Posso
 */
public class DateTimeUtil {
    
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    
    /**
     * Private constructor to avoid instances of the class
     */
    private DateTimeUtil(){}
    
    /**
     * Method to parse a String to LocalDate.
     * 
     * @param date date with the format dd/MM/yyyy
     * @return It returns a LocalDate object
     */
    public static LocalDate parseDate(String date){
        return LocalDate.parse(date, DATE_FORMAT);
    }
    
    /**
     * Method to parse a String to LocalTime.
     * 
     * @param time time with the format HH:mm
     * @return It returns a LocalTime object
     */
    public static LocalTime parseTime(String time){
        return LocalTime.parse(time, TIME_FORMAT);
    }
}
