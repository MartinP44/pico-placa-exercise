package com.posso.martin.pico.placa.predictor.controller;

import com.posso.martin.pico.placa.predictor.exception.InvalidPlateException;
import com.posso.martin.pico.placa.predictor.exception.InvalidTimeException;
import com.posso.martin.pico.placa.predictor.exception.InvalidDateException;
import com.posso.martin.pico.placa.predictor.model.Plate;
import com.posso.martin.pico.placa.predictor.model.PredictionResult;
import com.posso.martin.pico.placa.predictor.service.impl.PicoPlacaServiceImpl;
import com.posso.martin.pico.placa.predictor.util.DateTimeUtil;
import com.posso.martin.pico.placa.predictor.util.FormatValidatorUtil;
import com.posso.martin.pico.placa.predictor.view.JFInputForm;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Martin Posso
 */
public class PredictorController {

    private PicoPlacaServiceImpl picoPlacaService;
    private JFInputForm inputForm;
    
    public PredictorController(PicoPlacaServiceImpl picoPlacaService, JFInputForm inputForm) {
        this.picoPlacaService = picoPlacaService;
        this.inputForm = inputForm;
        
    }
    
    public void makePrediction(){
        Plate plate = new Plate(inputForm.getPlate());
        String dateS = inputForm.getDate();
        String timeS = inputForm.getTime();
        String numPlate = plate.getPlateNumber();
        
        try{
            // Format validating
            FormatValidatorUtil.checkPlateFormat(numPlate);
            FormatValidatorUtil.checkDateFormat(dateS);
            FormatValidatorUtil.checkTimeFormat(timeS);
            
            LocalDate date = DateTimeUtil.parseDate(dateS);
            LocalTime time = DateTimeUtil.parseTime(timeS);
            
            PredictionResult result = picoPlacaService.checkPicoPlaca(numPlate, date, time);
            
            inputForm.showPredictionResult(!result.isIsCirculationAllowed(), result.getMessage());
            
        }catch(InvalidPlateException | InvalidDateException | InvalidTimeException e){
            System.err.println(e.getMessage());
        }
    }
    
}
