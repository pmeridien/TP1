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

        if ("Redémarrer".equals(event.getActionCommand())) {
            pane.dispose();
            
            pane.getPuzzleModel().reset();  
            pane.graphic();
        } else if ("3 x 3".equals(event.getActionCommand())) {
//            dim = 3;
//            pane.graphic();
//            pane.getPuzzleModel().reset(); 
        } else if ("4 x 4".equals(event.getActionCommand())) {
            dim = 4;
        } else if ("5 x 5".equals(event.getActionCommand())) {
            dim = 5;
        } else if ("6 x 6".equals(event.getActionCommand())) {
            dim = 6;
        } else if ("7 x 7".equals(event.getActionCommand())) {
            dim = 7;
        } else if ("8 x 8".equals(event.getActionCommand())) {
            dim = 8;
        } else if ("9 x 9".equals(event.getActionCommand())) {
            dim = 9;
        } else if ("10 x 10".equals(event.getActionCommand())) {
            dim = 10;
        }  else if ("PAUSE".equals(event.getActionCommand())) {
            pane.getGameButton().setText("CONTINUER");
        }  else if ("CONTINUER".equals(event.getActionCommand())) {
            pane.getGameButton().setText("PAUSE");
        }    else if ("Quiter".equals(event.getActionCommand())) {
            System.exit(0);
        } else {
            dim = 0;
        }
        
        System.out.println(dim1);
    }
}
