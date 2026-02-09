package com.posso.martin.pico.placa.predictor.util;


import com.posso.martin.pico.placa.predictor.exception.InvalidDateException;
import com.posso.martin.pico.placa.predictor.exception.InvalidTimeException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

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
    public static LocalDate parseDate(String date) throws InvalidDateException{
        try{
            return LocalDate.parse(date, DATE_FORMAT);
        }catch(DateTimeParseException e){
            System.err.println(e.getMessage());
            throw new InvalidDateException("The date does not exists. Please enter a real date");
        }
    }
    
    /**
     * Method to parse a String to LocalTime.
     * 
     * @param time time with the format HH:mm
     * @return It returns a LocalTime object
     */
    public static LocalTime parseTime(String time) throws InvalidTimeException{
        
        try{
            return LocalTime.parse(time, TIME_FORMAT);
        }catch(DateTimeParseException e){
            System.err.println(e.getMessage());
            throw new InvalidTimeException("The date does not exists. Please enter a real time");
        }
        
    }
}
