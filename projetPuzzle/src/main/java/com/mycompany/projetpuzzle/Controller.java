/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetpuzzle;

/**
 *
 * @author Pierre L. Méridien
 */
public class Controller {
    
    private SlidePuzzleGUI slide;

    public Controller(SlidePuzzleGUI slide) {
        this.slide = slide;
    }

    public Controller() {
    }

    public SlidePuzzleGUI getSlide() {
        return slide;
    }    
    
}
