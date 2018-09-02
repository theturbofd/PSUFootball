/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Giovanni Ramos
 */
public final class Player {

    private JButton p1;

    public Player() {
        p1 = new JButton();

    }

    /**
     * @return the p1
     */
    public JButton getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(JButton p1) {
        this.p1 = p1;
    }
}
