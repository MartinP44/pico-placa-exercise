package com.posso.martin.pico.placa.predictor.util;

import com.posso.martin.pico.placa.predictor.exception.InvalidPlateException;
import com.posso.martin.pico.placa.predictor.exception.InvalidDateException;
import com.posso.martin.pico.placa.predictor.exception.InvalidTimeException;
import java.util.regex.Pattern;
/**
 *
 * @author Martin Posso
 */
public class FormatValidatorUtil {
    
    private static final Pattern PLATE_PATTERN = Pattern.compile("^[A-Z]{3}-?\\d{4}$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    private static final Pattern  TIME_PATTERN = Pattern.compile("^\\d{2}:\\d{2}$");
    
    /**
     * Private constructor to avoid instances of the class
     */
    private FormatValidatorUtil(){}
    
    /**
     * Method to check whether the entered plate format is valid
     * 
     * @param plate plate number of a car 
     * @throws InvalidPlateException if null, blank, or invalid plate format.
     */
    public static void checkPlateFormat(String plate) throws InvalidPlateException{
        
        if(isBlank(plate))
            throw new InvalidPlateException("The plate cannot be left blank");
        
        if(!PLATE_PATTERN.matcher(plate).matches())
            throw new InvalidPlateException("Invalid plate format. Expected example: PVC-1234");
        
    }
    
    
    /**
     * Method to check whether the entered date format is valid
     * 
     * @param date date entered as a String
     * @throws InvalidDateException if null, blank, or invalid date format.
     */
    public static void checkDateFormat(String date) throws InvalidDateException{
        
        if(isBlank(date))
            throw new InvalidDateException("The date cannot be left blank");
        
        if(!DATE_PATTERN.matcher(date).matches())
            throw new InvalidDateException("Invalid date format. Expected example: 02/08/2026");
        
    }
    
    
    /**
     * Method to check whether the entered time format is valid
     * 
     * @param time hour entered as a String
     * @throws InvalidTimeException if null, blank, or invalid time format.
     */
    public static void checkTimeFormat(String time) throws InvalidTimeException{
        
        if(isBlank(time))
            throw new InvalidTimeException("The time cannot be left blank");
        
        if(!TIME_PATTERN.matcher(time).matches())
            throw new InvalidTimeException("Invalid time format. Expected example: 09:30, 17:43");
    }
    
    
    private static boolean isBlank(String str){
        return str == null || str.isBlank();
    }
    
    
    
}
