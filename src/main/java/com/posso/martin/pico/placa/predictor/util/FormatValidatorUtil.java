package com.posso.martin.pico.placa.predictor.util;

/**
 *
 * @author Martin Posso
 */
public class FormatValidatorUtil {
    
    /**
     * Private constructor to avoid instances of the class
     */
    private FormatValidatorUtil(){}
    
    /**
     * Method to check whether the entered plate format is valid
     * 
     * @param plate plate number of a car 
     * @return It returns the value of true if the plate number has a valid format, otherwise it returns false
     */
    public static boolean checkPlateFormat(String plate){
        return plate.matches("^[A-Z]{3}-\\d{4}$");
    }
    
    
    /**
     * Method to check whether the entered date format is valid
     * 
     * @param date date entered as a String
     * @return It returns the value of true if the date has a valid format, otherwise it returns false
     */
    public static boolean checkDateFormat(String date){
        return date.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }
    
    
    /**
     * Method to check whether the entered hour format is valid
     * 
     * @param hour hour entered as a String
     * @return It returns the value of true if the hour has a valid format, otherwise it returns false
     */
    public static boolean checkHourFormat(String hour){
        return hour.matches("^\\d{2}:\\d{2}$");
    }
    
}
