package com.posso.martin.pico.placa.predictor.service;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author marti
 */
public interface PicoPlacaService {
    public boolean checkPicoPlaca(String plate, LocalDate date, LocalTime time);
}
