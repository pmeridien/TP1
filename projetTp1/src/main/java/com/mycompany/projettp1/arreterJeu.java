/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projettp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pierre Laury Méridien
 */

/**
 * Cette classe gère le mode arrêt du jeu
 */
public class arreterJeu implements ActionListener {

    // Déclaration des variables
    private Cadre jeu; // Objet qui fait référence à la classe Cadre
    private Logic stop; // Objet qui fait référence à la classe Logic

    /**
     * Constructeur avec paramètre
     *
     * @param jeu pour prendre les informations de la classe Cadre
     */
    public arreterJeu(Cadre jeu) {
        this.jeu = jeu;
    }

    /**
     * Constructeur prenant avec paramètre
     *
     * @param stop pour prendre les informations de la classe Logic
     */
    public arreterJeu(Logic stop) {
        this.stop = stop;
    }

    /**
     * Méthode qui gère l'arrêt et la continuité du jeu
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        stop = new Logic();
        if ("PAUSE".equals(event.getActionCommand())) {
            jeu.getGameButton().setText("CONTINUER");
            jeu.repaint();
            stop.moveTile(0, 0);
        } else {
            jeu.getGameButton().setText("PAUSE");
            jeu.repaint();
            stop.moveTile(0, 0);
        }
    }
}
