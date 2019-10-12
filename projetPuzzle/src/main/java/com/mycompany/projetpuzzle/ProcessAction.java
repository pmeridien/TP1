/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pierre L. Méridien
 */
public class ProcessAction implements ActionListener {

    private SlidePuzzleGUI pane;
//    private  SlidePuzzleModel puzzle;
    
    
    private int dim1, dim2, dim;

    public ProcessAction(SlidePuzzleGUI pane) {
        this.pane = pane;
    }

//    public ProcessAction(SlidePuzzleModel puzzle) {
//        this.puzzle = puzzle;

    public ProcessAction() {
        if (dim == 3 ) {
            dim1 = dim2 = 3;
        }
    }

    public ProcessAction(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    ProcessAction(int dim) {
//        System.out.println(" Je suis 3 x 3");

    }

//    }
    public int getDim1() {
        return dim1;
    }

    public int getDim2() {
        return dim2;
    }

    public void setDim1(int dim1) {
        this.dim1 = dim1;
    }

    public void setDim2(int dim2) {
        this.dim2 = dim2;
      }
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
    
        if (null == event.getActionCommand()) {
            dim = 0;
        } else switch (event.getActionCommand()) {
            case "Redémarrer":
                pane.dispose();
                pane.getPuzzleModel().reset();
                pane.graphic();
                break;
//            dim = 3;
//            pane.graphic();
//            pane.getPuzzleModel().reset();
            case "3 x 3":
                break;
            case "4 x 4":
                dim = 4;
                break;
            case "5 x 5":
                dim = 5;
                break;
            case "6 x 6":
                dim = 6;
                break;
            case "7 x 7":
                dim = 7;
                break;
            case "8 x 8":
                dim = 8;
                break;
            case "9 x 9":
                dim = 9;
                break;
            case "10 x 10":
                dim = 10;
                break;
            case "PAUSE":
                pane.getGameButton().setText("CONTINUER");
                break;
            case "CONTINUER":
                pane.getGameButton().setText("PAUSE");
                break;
            case "Quiter":
                System.exit(0);
            default:
                dim = 0;
                break;
        }
        
        System.out.println(dim1);
        
    }
}
