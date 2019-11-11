/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projettp1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author Pierre Laury Méridien
 */

/**
 * Cette classe gère les affichages
 */
public class Message extends JFrame implements ActionListener {

    // Déclaration des constantes
    private static final String INSTRUCTIONS = "Le but est de remettre en ordre les chiffre en un temps record";
    private static final String APROPOS = "420-C37-BB, Automne 2019\nTravail pratique 1\nProfesseur : Najoua Ghrieb"
            + "   \n\n                                                   Description du travail\n===================================="
            + "=============================== \nProgramme java qui permet de remettre en ordre croissant  des "
            + "chiffres,\nmis de manière aléatoire au départ, par l’ordinateur.\n\n\nAuteur: Pierre Laury Méridien\n\n\n"
            + "ENJOY!!!\n\n";
    private static final String MSG1 = "Instructions";
    private static final String MSG2 = "À Propos";

    // Déclaration des variables
    private JPanel panel1, panel2, panel3; // Les panneaux
    private JTextArea text; // Pour Afficher les informations
    private JButton okBtn; // Le bouton OK
    private JLabel label; // Un label pour Affichage
    private JSeparator sep1, sep2, sep3; // Les séparateurs
    private JScrollPane scPane; // Pour permettre la mobilité de l'affichage

    /**
     * Constructeur vide
     */
    public Message() {
    }

    /**
     * Méthode qui gère l'affichage des informations sur le jeu.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Instanciation des variables
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        text = new JTextArea();
        okBtn = new JButton("OK");
        label = new JLabel();
        sep1 = new JSeparator();
        sep2 = new JSeparator();
        sep3 = new JSeparator();
        scPane = new JScrollPane();

        if (null != e.getActionCommand()) {
            switch (e.getActionCommand()) {
                case MSG1: {
                    initPanelInstructions(); // Appel de la méthode qui construit le panel de l'affichage des instructions.
                    break;
                }
                case "A propos": {
                    initPanelAPropos(); // Appel de la méthode qui construit le panel de l'affichage de "A propos".
                    break;
                }
                default:
                    System.exit(0);
            }
        } else {
            System.exit(0);
        }

        okBtn.addActionListener((ActionEvent event) -> {
            this.dispose(); // Appel de la méthode qui ferme la fenetre d'affichage
        });

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }

    /**
     * Méthode qui construit le panneau d'affichage de l'instruction.
     */
    private void initPanelInstructions() {
        this.setTitle(MSG1);
        label.setText(INSTRUCTIONS);
        GroupLayout panel2Layout = new GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sep1)
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(sep1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        okBtn.setText("OK");
        GroupLayout panel3Layout = new GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sep2, GroupLayout.Alignment.TRAILING)
                        .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(okBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(180, Short.MAX_VALUE))
                        .addComponent(sep3)
        );
        panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(sep2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(okBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(sep3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
        );
        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
        );

    }

    /**
     * Méthode qui construit le panneau qui affiche "A Propos" du jeu
     */
    private void initPanelAPropos() {
        setTitle(MSG2);
        setFont(new Font("Century Schoolbook", 1, 18)); // NOI18N
        panel1.setBackground(new Color(0, 51, 153));
        text.setBackground(new Color(51, 102, 255));
        text.setColumns(20);
        text.setFont(new Font("Times New Roman", 1, 14)); // NOI18N
        text.setForeground(new Color(255, 255, 0));
        text.setRows(5);
        text.setText(APROPOS);
        scPane.setViewportView(text);
        okBtn.setText("OK");
        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scPane)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(okBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(223, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scPane, GroupLayout.PREFERRED_SIZE, 224,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(okBtn, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addContainerGap())
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
        );
    }
}
