/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetpuzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Pierre L. Méridien
 */
class SlidePuzzleGUI extends JFrame {

    //=============================================== instance variables
    private GraphicsPanel puzzleGraphics;
    private SlidePuzzleModel puzzleModel;
    private JPanel controlPanel;
    private JButton gameButton;
    private JMenuBar menuBar;
    private JMenu game, help, time, move, level;
    private JMenuItem restart, score, exit, level1, level2, level3, level4,
            level5, level6, level7, level8;
    private JMenuItem itemInstruction, itemAPropos;
    private int dim1, dim2;
//    private JButton[][] btnList;
    //end instance variables

    //====================================================== constructor
    public SlidePuzzleGUI(SlidePuzzleModel puzzleModel) {
        this.puzzleModel = puzzleModel;
    }

    public SlidePuzzleGUI() {
        super("TP1");

        //--- Create control panel
        controlPanel = new JPanel();

        setJMenuBar(createMenuBar(controlPanel));

        //--- Create a button.  Add a listener to it.
        restart.addActionListener(new ProcessAction(this));
        level1.addActionListener(new ProcessAction(this));
        level2.addActionListener(new ProcessAction(this));
        level3.addActionListener(new ProcessAction(this));
        level4.addActionListener(new ProcessAction(this));
        level5.addActionListener(new ProcessAction(this));
        level6.addActionListener(new ProcessAction(this));
        level7.addActionListener(new ProcessAction(this));
        level8.addActionListener(new ProcessAction(this));
        help.addActionListener(new ProcessAction(this));
        score.addActionListener(new ProcessAction(this));
        exit.addActionListener(new ProcessAction(this));
        time.addActionListener(new ProcessAction(this));
        move.addActionListener(new ProcessAction(this));
        itemInstruction.addActionListener(new ProcessAction(this));
        itemAPropos.addActionListener(new ProcessAction(this));

//--- Create graphics panel
        puzzleGraphics = new GraphicsPanel();

//        btnList = new JButton[dim1][dim2];
        controlPanel.setLayout(new GridLayout(dim1, dim2));
//
////        System.out.println("dim1: " + dim1);
////        System.out.println("dim2: " + dim2);
//        for (int i = 0; i < dim1; i++) {
//            for (int j = 0; j < puzzleModel.getContents().length; j++) {
//                controlPanel.add((puzzleModel.getContents()[i][j]));
////                System.out.println((puzzleModel.getContents()[i][j].getText()));
//            }
//        }
//        for (JButton b : puzzleModel.getBtnList()) {
////            System.out.println(b.getText());
////            controlPanel.add(b);
//        }
        //--- Set the layout and add the components
//        controlPanel.setLayout(new BorderLayout());
//        gameButton = new JButton("PAUSE");
//        gameButton.addActionListener(new ProcessAction(this));
//        add(gameButton, BorderLayout.SOUTH);
//        this.add(puzzleGraphics, BorderLayout.NORTH);
        add(controlPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 400);
        setVisible(true);

        this.add(puzzleGraphics, BorderLayout.CENTER);
    } //end constructor

    public GraphicsPanel getPuzzleGraphics() {
        return puzzleGraphics;
    }

    public SlidePuzzleModel getPuzzleModel() {
        return puzzleModel;
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

    public JButton getGameButton() {
        return gameButton;
    }

    private JMenuBar createMenuBar(JPanel controlPanel) {

        menuBar = new JMenuBar();
        game = new JMenu("Jeu");
        help = new JMenu("Aide");
        time = new JMenu("Temps");
        move = new JMenu("Déplacement");
        restart = new JMenuItem("Redémarrer");
        score = new JMenuItem("Scores élevé");
        exit = new JMenuItem("Quiter");
        level = new JMenu("Niveau");
        level1 = new JMenuItem("3 x 3");
        level2 = new JMenuItem("4 x 4");
        level3 = new JMenuItem("5 x 5");
        level4 = new JMenuItem("6 x 6");
        level5 = new JMenuItem("7 x 7");
        level6 = new JMenuItem("8 x 8");
        level7 = new JMenuItem("9 x 9");
        level8 = new JMenuItem("10 x 10");

        itemInstruction = new JMenuItem("Instructions");
        itemAPropos = new JMenuItem("A propos");

        level.add(level1);
        level.add(level2);
        level.add(level3);
        level.add(level4);
        level.add(level5);
        level.add(level6);
        level.add(level7);
        level.add(level8);

        game.add(restart);
        game.addSeparator();
        game.add(level);
        game.addSeparator();
        game.add(score);
        game.addSeparator();
        game.add(exit);

        help.add(itemInstruction);
        help.addSeparator();
        help.add(itemAPropos);

        menuBar.add(game);
        menuBar.add(game);
        menuBar.add(time);
        menuBar.add(move);

        return menuBar;
    }

    //////////////////////////////////////////////// class GraphicsPanel
    // This is defined inside the outer class so that
    // it can use the outer class instance variables.
    class GraphicsPanel extends JPanel implements MouseListener {

        private static final int ROWS = 4;
        private static final int COLS = 4;

        private static final int CELL_SIZE = 80; // Pixels
        private Font _biggerFont;

        //================================================== constructor
        public GraphicsPanel() {
            puzzleModel = new SlidePuzzleModel();
            dim1 = dim2 = puzzleModel.getContents().length;
//            _biggerFont = new Font("SansSerif", Font.BOLD, CELL_SIZE / 2);
//            this.setPreferredSize(
//                    new Dimension(CELL_SIZE * COLS, CELL_SIZE * ROWS));

//            this.setBackground(Color.black);
            this.addMouseListener(this);  // Listen own mouse events.

//        System.out.println("dim1: " + dim1);
//        System.out.println("dim2: " + dim2);
            for (int i = 0; i < dim1; i++) {
                for (int j = 0; j < puzzleModel.getContents().length; j++) {
                    controlPanel.add((puzzleModel.getContents()[i][j]));
//                System.out.println((puzzleModel.getContents()[i][j].getText()));
                }
            }

        }//end constructor

        //=======================================x method paintComponent
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    int x = c * CELL_SIZE;
                    int y = r * CELL_SIZE;
//                    String text = puzzleModel.getFace(r, c);
//                    if (text != null) {
//                        g.setColor(Color.gray);
//                        g.fillRect(x + 2, y + 2, CELL_SIZE - 4, CELL_SIZE - 4);
//                        g.setColor(Color.black);
//                        g.setFont(_biggerFont);
//                        g.drawString(text, x + 20, y + (3 * CELL_SIZE) / 4);
//                    }
                }
            }
        }//end paintComponent

        //======================================== listener mousePressed
        public void mousePressed(MouseEvent e) {
//            //--- map x,y coordinates into a row and col.
//            int col = e.getX() / CELL_SIZE;
//            int row = e.getY() / CELL_SIZE;
//
//            if (!puzzleModel.moveTile(row, col)) {
//                // moveTile moves tile if legal, else returns false.
//                Toolkit.getDefaultToolkit().beep();
//            }

//            this.repaint();  // Show any updates to model.
        }//end mousePressed

        //========================================== ignore these events
        public void mouseClicked(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }//end class GraphicsPanel

    ////////////////////////////////////////// inner class NewGameAction
//    public class NewGameAction implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//            puzzleModel.reset();
//            puzzleGraphics.repaint();
//        }
//    }//end inner class NewGameAction
}//end class SlidePuzzleGUI
