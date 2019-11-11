/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projettp1;

/**
 *
 * @author Pierre Laury Méridien
 */

/**
 * Cette classe gère toutes les opérations du jeu
 */
public class Logic {

    // Déclaration des variables
    private int rows, cols;
    private Tile[][] contents;  // Tableau de tiles
    private Tile emptyTile; // tile pour l'espcae vide.
    private Cadre.GraphicsPanel info; // Objet qui fait référence à la classe GraphicsPanel se trouvant dans la classe Cadre

    /**
     * Constructeur vide
     */
    public Logic() {
    }

    /**
     * Constructeur prenant en paramètre l'objet faisant référence à la classe
     * GraphicsPanel qui se trouve dans la classe Cadre.
     *
     * @param info
     */
    Logic(Cadre.GraphicsPanel info) {
        this.info = info;
        rows = cols = 4;
        if (info.getInfo().getDim() != 0) {
            rows = cols = info.getInfo().getDim();
        }
        contents = new Tile[rows][cols];

        reset();               //  Appel de la méthode qui reinitialise les puzzles et les arrange aléatoirement.
    }

    /**
     * Méthode qui récupére le chiffre à afficher sur un puzzle à la rangée et à
     * la colonne donnée
     *
     * @param row
     * @param col
     * @return un caractère
     */
    String getFace(int row, int col) {
        return contents[row][col].getFace();
    }

    /**
     * Méthode qui initialise et qui mélange les puzzles
     */
    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                contents[r][c] = new Tile(r, c, "" + (r * cols + c + 1));
            }
        }
        // Assignation du dernier tile à null pour marquer la position vide.
        emptyTile = contents[rows - 1][cols - 1];
        emptyTile.setFace(null);

        // Mélange des tiles.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                exchangeTiles(r, c, (int) (Math.random() * rows),
                        (int) (Math.random() * cols));
            }
        }
    }

    /**
     * Méthode qui déplace un puzzle vers une position vide
     *
     * @param r la rangée où se trouve le puzzle
     * @param c la colonne où se trouve le puzzle
     * @return un booléen
     */
    public boolean moveTile(int r, int c) {
        return checkEmpty(r, c, -1, 0) || checkEmpty(r, c, 1, 0)
                || checkEmpty(r, c, 0, -1) || checkEmpty(r, c, 0, 1);
    }

    /**
     * Méthode qui vérifie la position vide
     *
     * @param r la rangée de la position vide
     * @param c la colonne de la position vide
     * @param rdelta constante de position
     * @param cdelta constante de position
     * @return un booléen
     */
    private boolean checkEmpty(int r, int c, int rdelta, int cdelta) {
        int rNeighbor = r + rdelta;
        int cNeighbor = c + cdelta;
        if (isLegalRowCol(rNeighbor, cNeighbor)
                && contents[rNeighbor][cNeighbor] == emptyTile) {
            exchangeTiles(r, c, rNeighbor, cNeighbor);
            return true;
        }
        return false;
    }

    /**
     * Méthode qui vérifie la possibilité de faire un déplacement
     *
     * @param r la rangée de la position environnante
     * @param c la colonne de la position environnante
     * @return une position se basant sur la ragée et la colonne environnant le
     * puzzle à déplacer
     */
    public boolean isLegalRowCol(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    /**
     * Méthode qui échange un puzzle avec le puzzle vide
     *
     * @param r1 la rangée du puzzle à déplacer
     * @param c1 La collone du puzzle à déplacer
     * @param r2 la rangée du puzzle vide
     * @param c2 la colonne du puzzle vide
     */
    private void exchangeTiles(int r1, int c1, int r2, int c2) {
        Tile temp = contents[r1][c1];
        contents[r1][c1] = contents[r2][c2];
        contents[r2][c2] = temp;
    }

    /**
     * Méthode qui vérifie que la fin du jeu
     *
     * @return un booléen
     */
    public boolean isGameOver() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                Tile trc = contents[r][c];
                return trc.isInFinalPosition(r, c);
            }
        }
        return true;
    }
}// Fin de la classe Logic

/**
 * Classe qui gère la construction des puzzles
 */
class Tile {
    // Déclarationd des variables

    private int row;     //  Rangée de la position finale
    private int col;     // Colonne de la position finale
    private String face;  // Le caractère à afficher

    /**
     * Constructeur prenant en paramètre la rangée, la colonne et le caractère
     * du puzzle
     *
     * @param row la rangée du puzzle
     * @param col la colonne du puzzle
     * @param face le caractère du puzzle
     */
    public Tile(int row, int col, String face) {
        this.row = row;
        this.col = col;
        this.face = face;
    }

    /**
     * Méthode qui modifie le caractère
     *
     * @param newFace le nouvel caractère du puzzle
     */
    public void setFace(String newFace) {
        face = newFace;
    }

    /**
     * Méthode qui récupère le caractère
     *
     * @return le caratère
     */
    public String getFace() {
        return face;
    }

    /**
     * Méthode qui détermine la position finale
     *
     * @param r la rangée de la position
     * @param c la colonne de la position
     * @return la position
     */
    //=============================================== isInFinalPosition
    public boolean isInFinalPosition(int r, int c) {
        return r == row && c == col;
    }
}// Fin de la classe Tile

