package com.posso.martin.pico.placa.predictor.service.impl;

import com.posso.martin.pico.placa.predictor.model.PredictionResult;
import com.posso.martin.pico.placa.predictor.service.PicoPlacaService;
import com.posso.martin.pico.placa.predictor.util.HolidayCalendar;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Martin Posso
 */
public class PicoPlacaServiceImpl implements PicoPlacaService{
    
    private static LocalTime MORNING_START = LocalTime.of(6, 0);
    private static LocalTime MORNING_END = LocalTime.of(9, 30);
    private static LocalTime AFTERNOON_START = LocalTime.of(16, 0);
    private static LocalTime AFTERNOON_END = LocalTime.of(20, 0);
    
    
    /**
     * Method to check whether or not a car has "Pico y Placa" depending on the 
     * plate, date and time;
     * 
     * @param plate number of a car plate
     * @param date a specific date with format dd/MM/yyyy
     * @param time an hour in 24-hour format
     * @return It returns a PredictionResult object w
     */
    @Override
    public PredictionResult checkPicoPlaca(String plate, LocalDate date, LocalTime time){
        
        DayOfWeek day = date.getDayOfWeek();
        
        boolean isWeekend = day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY);
        
        if(isWeekend || HolidayCalendar.isHoliday(date))
            return new PredictionResult(false, "Free Circulation. It's weekend or holiday");
        
        int plateLastDigit = Integer.parseInt(plate.substring(plate.length()-1));
        List<Integer> restrictedNumbers = getRestrictedNumbers(day);
        
        if(!restrictedNumbers.contains(plateLastDigit)){
            return new PredictionResult(false, "Free Circulation. Your vehicle does not have Pico y Placa today");
        }
        
        if(isRushHour(time)){
            return new PredictionResult(true, "Restricted Circulation. Your vehicle cannot circulate between 6:00-9:30 or 16:00-20:00");
        }else{
            return new PredictionResult(true, "Restricted Circulation. Your vehicle can circulate right now, but careful of the restricted hours");
        }
        
    }

    /**
     * Method to get the restricted numbers according to the day
     * 
     * @param day a day of the week
     * @return It returns a list of integers that represent the restricted numbers depending on the day. The list will be empty if it is a weekend day.
     */
    private List<Integer> getRestrictedNumbers(DayOfWeek day) {
        return switch(day){
            case MONDAY -> List.of(1,2);
            case TUESDAY -> List.of(3,4);
            case WEDNESDAY -> List.of(5,6);
            case THURSDAY -> List.of(7,8);
            case FRIDAY -> List.of(9,0);
            default -> Collections.emptyList();
        };
        
        
    }

    /**
     * Method to know if the time is a rush hour
     * 
     * @param time an hour in 24-hour format
     * @return It returns true if the time evaluated is between MORNING_START-MORNING_END or AFTERNOON_START-AFTERNOON_END ranges. Otherwise it returns false
     */
    private boolean isRushHour(LocalTime time) {
        boolean isMorningRush = !time.isBefore(MORNING_START) && !time.isAfter(MORNING_END);
        boolean isNoonRush = !time.isBefore(AFTERNOON_START) && !time.isAfter(AFTERNOON_END);
        
        return isMorningRush || isNoonRush;
    }

    
    
}
