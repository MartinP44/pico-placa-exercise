package com.posso.martin.pico.placa.predictor.controller;


import com.posso.martin.pico.placa.predictor.service.impl.ImplPicoPlacaService;
import com.posso.martin.pico.placa.predictor.view.JFInputForm;


/**
 *
 * @author Martin Posso
 */
public class PredictorController {

    private ImplPicoPlacaService picoPlacaservice;
    private JFInputForm inputForm;
    
    public PredictorController(ImplPicoPlacaService picoPlacaservice, JFInputForm inputForm) {
        this.picoPlacaservice = picoPlacaservice;
        this.inputForm = inputForm;
        
    }
    
}
