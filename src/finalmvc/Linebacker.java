/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Giovanni Ramos
 */
public class Linebacker {

    private JButton enemy1, enemy2;

    public Linebacker() {
        enemy1 = new JButton();
        enemy2 = new JButton();
    }

    /**
     * @return the enemy1
     */
    public JButton getEnemy1() {
        return enemy1;
    }

    /**
     * @param enemy1 the enemy1 to set
     */
    public void setEnemy1(JButton enemy1) {
        this.enemy1 = enemy1;
    }

    /**
     * @return the enemy2
     */
    public JButton getEnemy2() {
        return enemy2;
    }

    /**
     * @param enemy2 the enemy2 to set
     */
    public void setEnemy2(JButton enemy2) {
        this.enemy2 = enemy2;
    }
}
