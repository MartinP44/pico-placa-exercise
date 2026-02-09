package com.posso.martin.pico.placa.predictor;

import com.posso.martin.pico.placa.predictor.exception.InvalidPlateException;
import com.posso.martin.pico.placa.predictor.exception.InvalidDateException;
import com.posso.martin.pico.placa.predictor.exception.InvalidTimeException;
import com.posso.martin.pico.placa.predictor.util.FormatValidatorUtil;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.ValueSource;


/**
 *
 * @author Martin Posso
 */
public class FormatValidatorUtilTest {
    
    @ParameterizedTest
    @ValueSource(strings = {
        "PVC-1834",
        "PVC1254",
        "EFG-0000",
        "MUA7831"
    })
    void checkPlateFormat_shouldNotThrow_whenPlateFormatIsValid(String plate){
        assertDoesNotThrow(() -> FormatValidatorUtil.checkPlateFormat(plate));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        " ",
        "    ",
        "\n",
        "\t"
    })
    void checkPlateFormat_shouldThrowInvalidPlateException_whenPlateIsBlank(String plate){
        InvalidPlateException excep = assertThrows(
            InvalidPlateException.class,
            () -> FormatValidatorUtil.checkPlateFormat(plate));
        
        assertEquals("The plate cannot be left blank", excep.getMessage());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "PV-1234",
        "PVCC-1234",
        "PVC-123",
        "pvc-1234",
        "PVC_1234",
        "PVC 1234"
    })
    void checkPlateFormat_shouldThrowInvalidPlateException_whenPlateFormatIsInvalid(String plate){
        InvalidPlateException excep = assertThrows(
            InvalidPlateException.class,
            () -> FormatValidatorUtil.checkPlateFormat(plate));
        
        assertEquals("Invalid plate format. Expected example: PVC-1234", excep.getMessage());
    }
    
    
    @ParameterizedTest
    @ValueSource(strings = {
        "02/08/2026",
        "31/12/1999",
        "00/00/2026",   // validating regex only
        "32/13/2026"    // validating regex only
    })
    void checkDateFormat_shouldNotThrow_whenDateFormatIsValid(String date){
        assertDoesNotThrow(() -> FormatValidatorUtil.checkDateFormat(date));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        " ",
        "    ",
        "\n",
        "\t"
    })
    void checkDateFormat_shouldThrowInvalidDateException_whenDateIsBlank(String date){
        InvalidDateException excep = assertThrows(
            InvalidDateException.class,
            () -> FormatValidatorUtil.checkDateFormat(date));
        
        assertEquals("The date cannot be left blank", excep.getMessage());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "2/08/2026",
        "02/8/2026",
        "02-08-2026",
        "02/08/26",
        "02082026",
        "aa/bb/cc"
    })
    void checkDateFormat_shouldThrowInvalidDateException_whenDateFormatIsInvalid(String date){
        InvalidDateException excep = assertThrows(
            InvalidDateException.class,
            () -> FormatValidatorUtil.checkDateFormat(date));
        
        assertEquals("Invalid date format. Expected example: 02/08/2026", excep.getMessage());
    }
    
    
    @ParameterizedTest
    @ValueSource(strings = {
        "09:30",
        "17:43",
        "00:00",
        "99:99"    // validating regex only
    })
    void checkTimeFormat_shouldNotThrow_whenTimeFormatIsValid(String time){
        assertDoesNotThrow(() -> FormatValidatorUtil.checkTimeFormat(time));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        " ",
        "    ",
        "\n",
        "\t"
    })
    void checkTimeFormat_shouldThrowInvalidTimeException_whenTimeIsBlank(String time){
        InvalidTimeException excep = assertThrows(
            InvalidTimeException.class,
            () -> FormatValidatorUtil.checkTimeFormat(time));
        
        assertEquals("The time cannot be left blank", excep.getMessage());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "9:30",
        "0930",
        "09:3",
        "09-30",
        "ab:cd"
    })
    void checkTimeFormat_shouldThrowInvalidTimeException_whenTimeFormatIsInvalid(String time){
        InvalidTimeException excep = assertThrows(
            InvalidTimeException.class,
            () -> FormatValidatorUtil.checkTimeFormat(time));
        
        assertEquals("Invalid time format. Expected example: 09:30, 17:43", excep.getMessage());
    }
    
    
    
}
