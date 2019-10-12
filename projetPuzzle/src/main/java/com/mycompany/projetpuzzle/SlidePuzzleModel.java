/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetpuzzle;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Pierre L. Méridien
 */
class SlidePuzzleModel {

    private int rows = 4;
    private int cols = 4;
    private JButton[][] contents;
    private boolean[] used;
    private ArrayList<JButton> btnList;
    private Controller info;
//    private SlidePuzzleGUI info;

    //================================================= constructor
    public SlidePuzzleModel(Controller info) {
        this.info = info;
    }

    public SlidePuzzleModel() {
        info = new Controller();
        reset();               // Initialize and shuffle tiles.
    } //end constructor

//    public SlidePuzzleModel(SlidePuzzleGUI info) {
//        this.info = info;
//
//        reset();               // Initialize and shuffle tiles.
//    }//end cons
    public void reset() {

        info = new Controller();
//        info = new SlidePuzzleGUI();
//        rows = cols = info.getDim();
//        System.out.println("dim: " + info.getSlide().getDim());
//        rows = cols = info.getSlide().getDim();
        System.out.println("rows = " + rows);
        System.out.println("cols = " + cols);

        used = new boolean[rows * cols];
        contents = new JButton[rows][cols];
        btnList = new ArrayList<>();
        System.out.println("=====================Avant===================");
        for (int i = 0; i < contents.length; i++) {
            for (int j = 0; j < contents[i].length; j++) {
                int val = (int) (rows * cols * Math.random());
                while (used[val]) {
                    val = (int) (rows * cols * Math.random());
                }
                used[val] = true;
                if (val != 0) {
                    contents[i][j] = new JButton(Integer.toString(val));
                    System.out.println(contents[i][j].getText());
//                    pane.getContentPane().add(contents[i][j]);  
                    btnList.add(new JButton(contents[i][j].getText()));
                } else {
                    contents[i][j] = new JButton();
                    contents[i][j].setText("");
//                    contents[i][j].setBackground(Color.red);
//                    System.out.println(contents[i][j]);
//                    contents[i][j].remove();
                }
            }
        }
//        for (int i = 0; i < contents.length; i++) {
//            for (int j = 0; j < contents[i].length; j++) {
//                btnList.add(new JButton(contents[i][j].getText()));
//            }
//
//        }
    }

//}
//                //--- Set last tile face to null to mark empty space
//                emptyTile = contents[ROWS - 1][COLS - 1];
//                emptyTile.setFace(null);
//                //-- Shuffle - Exchange each tile with random tile.
//                for (int r = 0; r < ROWS; r++) {
//                    for (int c = 0; c < COLS; c++) {
//                        exchangeTiles(r, c, (int) (Math.random() * ROWS), (int) (Math.random() * COLS));
//                    }
//                }
//            }//end reset
//==================================================== moveTile
// Move a tile to empty position beside it, if possible.
// Return true if it was moved, false if not legal.
//    public boolean moveTile(int r, int c) {
//        //--- It's a legal move if the empty cell is next to it.
//        return checkEmpty(r, c, -1, 0) || checkEmpty(r, c, 1, 0)
//                || checkEmpty(r, c, 0, -1) || checkEmpty(r, c, 0, 1);
//    }//end moveTile
//================================================== checkEmpty
// Check to see if there is an empty position beside tile.
// Return true and exchange if possible, else return false.
//    private boolean checkEmpty(int r, int c, int rdelta, int cdelta) {
//        int rNeighbor = r + rdelta;
//        int cNeighbor = c + cdelta;
//        //--- Check to see if this neighbor is on board and is empty.
//        if (isLegalRowCol(rNeighbor, cNeighbor)
//                && contents[rNeighbor][cNeighbor] == emptyTile) {
//            exchangeTiles(r, c, rNeighbor, cNeighbor);
//            return true;
//        }
//        return false;
//    }//end checkEmpty
//=============================================== isLegalRowCol
// Check for legal row, col
//    public boolean isLegalRowCol(int r, int c) {
//        return r >= 0 && r < ROWS && c >= 0 && c < COLS;
//    }//end isLegalRowCol
//=============================================== exchangeTiles
// Exchange two tiles.
//    private void exchangeTiles(int r1, int c1, int r2, int c2) {
//        Tile temp = contents[r1][c1];
//        contents[r1][c1] = contents[r2][c2];
//        contents[r2][c2] = temp;
//    }//end exchangeTiles
//=================================================== isGameOver
//    public boolean isGameOver() {
//        for (int r = 0; r < ROWS; r++) {
//            for (int c = 0; c < ROWS; c++) {
//                Tile trc = contents[r][c];
//                return trc.isInFinalPosition(r, c);
//            }
//        }
//--- Falling thru loop means nothing out of place.
//        return true;
//    }//end isGameOver
    public JButton[][] getContents() {
        return contents;
    }

    public ArrayList<JButton> getBtnList() {
        return btnList;
    }

}//end class SlidePuzzleModel

