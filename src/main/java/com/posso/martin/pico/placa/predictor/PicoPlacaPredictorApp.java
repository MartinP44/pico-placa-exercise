package com.posso.martin.pico.placa.predictor;

import com.posso.martin.pico.placa.predictor.view.JFInputForm;


/**
 *
 * @author Martin Posso
 */
public class PicoPlacaPredictorApp {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInputForm().setVisible(true);
            }
        });
        
    }
}
