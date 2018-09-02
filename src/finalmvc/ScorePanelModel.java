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
public class ScorePanelModel extends JPanel {

    private JLabel score, attempts, instructions;

    public ScorePanelModel(GamePanelmodel someGamePanel) {
        super();
        setBackground(new Color(0, 204, 255));
        setLayout(null);
        score = someGamePanel.getScore();
        attempts = someGamePanel.getAttempts();
        instructions = new JLabel();
        instructions.setText("Touch the right of the screen to score a touch down! Don't get tackled!");
        add(instructions);
        add(attempts);
        add(score);
        score.setBounds(new Rectangle(0, 0, 70, 50));
        attempts.setBounds(new Rectangle(70, 0, 200, 50));
        instructions.setBounds(new Rectangle(400, 0, 400, 50));
    }

    /**
     * @return the score
     */
    public JLabel getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(JLabel score) {
        this.score = score;
    }
}
