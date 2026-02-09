package com.posso.martin.pico.placa.predictor.service.impl;

import com.posso.martin.pico.placa.predictor.model.PredictionResult;
import com.posso.martin.pico.placa.predictor.service.PicoPlacaService;
import com.posso.martin.pico.placa.predictor.util.HolidayCalendar;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Martin Posso
 */
public class ImplPicoPlacaService implements PicoPlacaService{
    
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

    private List<Integer> getRestrictedNumbers(DayOfWeek day) {
        List<Integer> restrictedNums = new ArrayList<>();
        switch(day){
            case MONDAY -> {
                restrictedNums.add(1);
                restrictedNums.add(2);
            }
            case TUESDAY -> {
                restrictedNums.add(3);
                restrictedNums.add(4);
            }
            case WEDNESDAY -> {
                restrictedNums.add(5);
                restrictedNums.add(6);
            }
            case THURSDAY -> {
                restrictedNums.add(7);
                restrictedNums.add(8);
            }
            case FRIDAY -> {
                restrictedNums.add(9);
                restrictedNums.add(0);
            }
        }
        
        return restrictedNums;
    }

    private boolean isRushHour(LocalTime time) {
        LocalTime morningStart = LocalTime.of(6, 0);
        LocalTime morningEnd = LocalTime.of(9, 30);
        LocalTime noonStart = LocalTime.of(16, 0);
        LocalTime noonEnd = LocalTime.of(20, 0);
        
        boolean isMorningRush = time.isAfter(morningStart) && time.isBefore(morningEnd);
        boolean isNoonRush = time.isAfter(noonStart) && time.isBefore(noonEnd);
        
        return isMorningRush || isNoonRush;
    }

    
    
}
