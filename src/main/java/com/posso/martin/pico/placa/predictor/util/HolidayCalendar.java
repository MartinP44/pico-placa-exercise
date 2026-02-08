package com.posso.martin.pico.placa.predictor.util;

import java.time.Month;
import java.time.MonthDay;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Martin Posso
 */
public class HolidayCalendar {
    
    private static final Set<MonthDay> FIXED_HOLIDAYS = new HashSet<>();
    
    static{
        FIXED_HOLIDAYS.add(MonthDay.of(Month.JANUARY, 1));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.MAY, 1));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.MAY, 24));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.AUGUST, 10));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.OCTOBER, 9));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.NOVEMBER, 2));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.NOVEMBER, 3));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.DECEMBER, 6));
        FIXED_HOLIDAYS.add(MonthDay.of(Month.DECEMBER, 25));
    }
    
    private HolidayCalendar(){}
    
    
    public static boolean isHoliday(LocalDate date){
        return FIXED_HOLIDAYS.contains(MonthDay.from(date));
        
    }
    
    
    
    
}
