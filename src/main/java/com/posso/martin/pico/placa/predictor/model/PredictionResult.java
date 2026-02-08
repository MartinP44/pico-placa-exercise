package com.posso.martin.pico.placa.predictor.model;

/**
 *
 * @author Martin Posso
 */
public class PredictionResult {
    
    private boolean isCirculationAllowed;
    private String message;
    

    public PredictionResult(boolean isCirculationAllowed, String message) {
        this.isCirculationAllowed = isCirculationAllowed;
        this.message = message;
    }
    
    
}
