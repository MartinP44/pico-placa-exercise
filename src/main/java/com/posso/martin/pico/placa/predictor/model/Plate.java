package com.posso.martin.pico.placa.predictor.model;

/**
 *
 * @author Martin Posso
 */
public class Plate {
    
    private String plateNumber;
    
    public Plate(String plateNumber){
        this.plateNumber = plateNumber;
    }   

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }   
}
