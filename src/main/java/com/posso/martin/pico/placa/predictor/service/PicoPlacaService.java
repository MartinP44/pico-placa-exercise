package com.posso.martin.pico.placa.predictor.service;

import com.posso.martin.pico.placa.predictor.model.PredictionResult;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author marti
 */
public interface PicoPlacaService {
    public PredictionResult checkPicoPlaca(String plate, LocalDate date, LocalTime time);
}
