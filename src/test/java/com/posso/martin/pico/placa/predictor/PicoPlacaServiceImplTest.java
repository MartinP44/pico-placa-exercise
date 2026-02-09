package com.posso.martin.pico.placa.predictor;

import com.posso.martin.pico.placa.predictor.model.PredictionResult;
import com.posso.martin.pico.placa.predictor.service.PicoPlacaService;
import com.posso.martin.pico.placa.predictor.service.impl.PicoPlacaServiceImpl;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



/**
 *
 * @author Martin
 */
public class PicoPlacaServiceImplTest {
    private PicoPlacaService service;

    @BeforeEach
    public void setUp() {
        service = new PicoPlacaServiceImpl();
    }

    @Test
    public void checkPicoPlaca_shouldRestrictCirculation_whenMondayRushHour_andPlateEndsIn1() {
        LocalDate monday = LocalDate.of(2026, 2, 9);
        LocalTime rushHour = LocalTime.of(8, 0);
        String plate = "PBX-1111";

        PredictionResult result = service.checkPicoPlaca(plate, monday, rushHour);

        assertTrue(result.isIsCirculationAllowed(), "Plate number ends in 1 cannot circulate on Monday at 8:00 am");
        assertEquals("Restricted Circulation. Your vehicle cannot circulate between 6:00-9:30 or 16:00-20:00", result.getMessage());
    }

    @Test
    public void checkPicoPlaca_shouldAllowCirculation_whenMonday_andPlateEndsIn3() {
        LocalDate monday = LocalDate.of(2026, 2, 9);
        LocalTime rushHour = LocalTime.of(8, 0);
        String plate = "PBX-1113";

        PredictionResult result = service.checkPicoPlaca(plate, monday, rushHour);

        assertFalse(result.isIsCirculationAllowed(), "Plate number ends in 3 can circulate on Monday at any time");
        assertEquals("Free Circulation. Your vehicle does not have Pico y Placa today", result.getMessage());
        
    }

    @Test
    public void checkPicoPlaca_shouldAllowFreeCirculation_whenWeekend() {
        LocalDate saturday = LocalDate.of(2026, 2, 14);
        LocalTime time = LocalTime.of(10, 0);
        String plate = "PBX-1111";
        
        PredictionResult result = service.checkPicoPlaca(plate, saturday, time);

        assertFalse(result.isIsCirculationAllowed(), "There are no restrictions on holidays and weekends");
        assertEquals("Free Circulation. It's weekend or holiday", result.getMessage());
    }

    @Test
    public void checkPicoPlaca_shouldRestrictCirculation_whenTimeIsRushHourBoundary_09_30_andPlateIsRestricted() {
        LocalDate monday = LocalDate.of(2026, 2, 9);
        LocalTime edgeTime = LocalTime.of(9, 30);
        String plate = "PBX-1111";
        
        PredictionResult result = service.checkPicoPlaca(plate, monday, edgeTime);

        assertTrue(result.isIsCirculationAllowed(), "At 09:30 circulation is still restricted if the plate number ends in 1");
        assertEquals("Restricted Circulation. Your vehicle cannot circulate between 6:00-9:30 or 16:00-20:00", result.getMessage());

    }
}
