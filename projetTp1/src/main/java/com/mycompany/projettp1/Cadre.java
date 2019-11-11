/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projettp1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author Pierre Laury Méridien
 */
/**
 * Cette classe contient toutes les parties de l'interface graphiques du jeu
 */
public class Cadre extends JFrame {

    // Déclaration des constantes
    private static final String MSG = "MESSAGE";
    private static final String WIN = "Super...!";

    // Déclaration des variables
    private JPanel controlPanel; // Panneau principal.
    private JButton gameButton; // Le bouton pause.
    private JMenuBar menuBar; // La bar de menu .
    private JMenu game, help, time, move, level; // Les options de menu.
    private JMenuItem restart, score, exit, level1, level2, level3, level4,
            level5, level6, level7, level8; // Les éléments sou-menu.
    private JMenuItem itemInstruction, itemAPropos; // Sou-menus.
    private JMenu text; // Pour afficher la valeur du  compteur.
    private JSeparator space; // Séparateur.
    private int dim, rows, cols; // Variables pour le format du jeu.
    private GraphicsPanel puzzleGraphics; //  Objet faisant reférence à la classe GraphicsPanel.
    private Logic puzzleModel; // Objet faisant référence à la classe Logic.
    private static int compteur = 0; // Variable statique pour le déplacement.

    /**
     * Conctructeur sans paramètre.
     *
     */
    public Cadre() {

        controlPanel = new JPanel();
        setJMenuBar(createMenuBar(controlPanel));
        setWindow();
        restart.addActionListener(new NewGame());
        level1.addActionListener(new NewGame());
        level2.addActionListener(new NewGame());
        level3.addActionListener(new NewGame());
        level4.addActionListener(new NewGame());
        level5.addActionListener(new NewGame());
        level6.addActionListener(new NewGame());
        level7.addActionListener(new NewGame());
        level8.addActionListener(new NewGame());
        itemInstruction.addActionListener(new Message());
        itemAPropos.addActionListener(new Message());
        exit.addActionListener(new Message());
        gameButton.addActionListener(new arreterJeu(this));
    }

    /**
     * Méthode pour la récupération de la dimension pour le format du jeu.
     *
     * @return : La dimension
     */
    public int getDim() {
        return dim;
    }

    /**
     * Méthode qui initialise la dimension pour le format du jeu.
     *
     * @param dim la dimension
     */
    public void setDim(int dim) {
        this.dim = dim;
    }

    /**
     * Méthode pour la récupération du bouton pause.
     *
     * @return : La dimension
     */
    public JButton getGameButton() {
        return gameButton;
    }

    /**
     * Méthode qui construit le barre de menu avec les options.
     *
     * @return : La barre de menu
     */
    private JMenuBar createMenuBar(JPanel controlPanel) {
        // Instanciantion des boutons
        menuBar = new JMenuBar();
        game = new JMenu("Jeu");
        help = new JMenu("Aide");
        time = new JMenu("Temps");
        move = new JMenu("Déplacements :");
        restart = new JMenuItem("Redémarrer");
        score = new JMenuItem("Scores élevé");
        exit = new JMenuItem("Quitter");
        level = new JMenu("Niveau");
        level1 = new JMenuItem("3 x 3");
        level2 = new JMenuItem("4 x 4");
        level3 = new JMenuItem("5 x 5");
        level4 = new JMenuItem("6 x 6");
        level5 = new JMenuItem("7 x 7");
        level6 = new JMenuItem("8 x 8");
        level7 = new JMenuItem("9 x 9");
        level8 = new JMenuItem("10 x 10");
        gameButton = new JButton("PAUSE");
        itemInstruction = new JMenuItem("Instructions");
        itemAPropos = new JMenuItem("A propos");
        text = new JMenu("0");
        space = new JSeparator();

        space.setOrientation(SwingConstants.VERTICAL);

        // Ajouts des options dans la barre de menu
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

        add(gameButton, BorderLayout.SOUTH); // Ajoout du bouton "PAUSE" sur le panneau 

        menuBar.add(game);
        menuBar.add(help);
        menuBar.add(time);
        menuBar.add(space);
        menuBar.add(move);
        menuBar.add(text);

        return menuBar;
    }

    /**
     * Méthode qui construit la fenetre du jeu
     */
    private void setWindow() {
        rows = cols = 4;
        if (this.dim != 0) {
            rows = cols = this.dim;
        }

        puzzleGraphics = new GraphicsPanel(this); // création de l'interface graphique

        dispose(); //  Appelle de la méthode qui  ferme le frame
        puzzleGraphics.repaint(); // mise à jour de l'interface graphique

        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(puzzleGraphics, BorderLayout.CENTER);
        add(controlPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        validate();
        setVisible(true);
        setResizable(true);
    }

    /**
     * Cette Classe crée l'interface graphique du jeu
     */
    class GraphicsPanel extends JPanel implements MouseListener {

        // Déclaration des constantes
        private static final int CELL_SIZE1 = 120; // La longueur pour les boutons du puzzle
        private static final int CELL_SIZE2 = 50; // La largeur pour les boutons du puzzle

        // Déclarations des variables
        private int rows, cols; // nombre de rangée et de colonne
        private Cadre info; // Objet faisant référence à la classe Cadre

        /**
         * Constructeur prenant en paramètre l'objet faisant référence à la
         * classe Cadre
         *
         * @ param info contenant les info de la classe Cadre
         */
        private GraphicsPanel(Cadre info) {
            rows = cols = 4;
            this.info = info;
            puzzleModel = new Logic(this);

            if (info.getDim() != 0) {
                rows = cols = info.getDim();
            }

            setPreferredSize(new Dimension(CELL_SIZE1 * cols, CELL_SIZE2 * rows));
            addMouseListener(this);  // appel de la méthode qui gère le déplacement des puzzles
        }

        /**
         * Récupération des information de l'objet info
         * @return les informations liés à la classe Cadre
         */
        public Cadre getInfo() {
            return info;
        }

        /**
         * Méthode qui affiche les puzzles
         */
        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            if ("PAUSE".equals(gameButton.getText())) {
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        int x = c * CELL_SIZE1;
                        int y = r * CELL_SIZE2;
                        String text = puzzleModel.getFace(r, c);
                        if (text != null) {
                            g.setColor(Color.CYAN);
                            g.fillRect(x + 2, y + 2, CELL_SIZE1 - 2, CELL_SIZE2 - 2);
                            g.setColor(Color.black);
                            g.drawString(text, x + 50, y + (3 * CELL_SIZE2) / 4);
                        }
                    }
                }
            } else {
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        int x = c * CELL_SIZE1;
                        int y = r * CELL_SIZE2;
                        String text = puzzleModel.getFace(r, c);
                        if (text != null) {
                            g.setColor(Color.CYAN);
                            g.fillRect(x + 2, y + 2, CELL_SIZE1 - 2, CELL_SIZE2 - 2);
                            g.setColor(Color.black);
                            g.drawString("Zz", x + 50, y + (3 * CELL_SIZE2) / 4);
                        }
                    }
                }
            }
        }

        /**
         * Méthode qui gère le click de la souris sur les puzzles pour les
         * déplacer
         */
        @Override
        public void mousePressed(MouseEvent e) {
            if ("PAUSE".equals(gameButton.getText())) {
                compteur++;
                text.setText(Integer.toString(compteur));

                int col = e.getX() / CELL_SIZE1;
                int row = e.getY() / CELL_SIZE2;

                if (!puzzleModel.moveTile(row, col)) {
                    Toolkit.getDefaultToolkit().beep();
                }
                this.repaint();
            }
            // Condition d'affichage pour la fin du jeu.
            if (puzzleModel.isGameOver()) {
                JOptionPane.showMessageDialog(null, WIN, MSG, JOptionPane.INFORMATION_MESSAGE);
                controlPanel.removeAll();
                setWindow();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    } //Fin de la classe GraphicsPanel

    /**
     * Classe qui gère l'initialisation du jeu
     */
    public class NewGame implements ActionListener {

        // Déclarations des variables.
        private String chaine;
        private int valeur = 4; // Valeur du format par défaut.

        /**
         * Méthode qui initialise le jeu
         */
        public void actionPerformed(ActionEvent e) {
            compteur = 0;
            text.setText(Integer.toString(compteur));
            try {
                chaine = e.getActionCommand().substring(0, 2).trim();
                valeur = Integer.parseInt(chaine);
                setDim(valeur);
                controlPanel.removeAll();
                setWindow();

            } catch (Exception event) {
                setDim(4);
                puzzleModel.reset(); // Réinitialisation des puzzles
                puzzleGraphics.repaint(); // Mise à jour de l'interface graphique
            }
        }
    } // Fin de la classe NewGame;

}// Fin de la classe Cadre

