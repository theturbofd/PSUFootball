/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Giovanni Ramos
 */
public class GamePanelmodel extends JPanel implements KeyListener, ActionListener {

    private JButton player;
    private JButton enemy1;
    private JButton enemy2;
    private JSlider gameSpeed;
    private JPanel gamePanel;
    //
    private Timer tim;
    private JButton easy, medium, hard;
    private JLabel score, attempts;
    private Player createPlayer = new Player();
    private Linebacker createEnemy = new Linebacker();
    private int delay = 1000;
    private int default1 = 100;
    private int p1 = 100;
    private int p2 = 100;
    private int lb1 = 1000;
    private int edefault1 = 1000;
    private int edefault2 = 100;
    private int edefault3 = 1000;
    private int edefault4 = 400;
    private int lb2 = 100;
    private int lb3 = 1000;
    private int lb4 = 400;
    private int e1 = 0;
    private int e2 = 0;
    private int m1 = 70;
    private int m2 = 0;
    private int h1 = 140;
    private int h2 = 0;
    private int pscore = 0;
    private int pattempt = 0;
    private int sizeW = 70;
    private int sizeL = 50;
    private int initvalue = 40;
    private int min = 40;
    private int max = 60;

    private JButton p12;

    public JButton getP1() {
        return p12;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(JButton p12) {
        this.p12 = p12;
    }

    public void init() {
        p12 = new JButton();

    }

    public GamePanelmodel() {

        super();
        setBackground(new Color(153, 255, 153));
        setLayout(null);
        gamePanel = this;

        //Sets timer
        tim = new Timer(delay, new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                actionPerformed1(ae);

            }
        });
        tim.start();
        tim.setRepeats(true);

        //Sets buttons to the objects made in their classes
        player = createPlayer.getP1();
        enemy1 = createEnemy.getEnemy1();
        enemy2 = createEnemy.getEnemy2();
        score = new JLabel();
        attempts = new JLabel();
        gameSpeed = new JSlider(min, max, initvalue);

        //Sets difficulty
        easy = new JButton();
        medium = new JButton();
        hard = new JButton();

        //Sets all the labels for the button
        player.setText("P1");
        enemy1.setText("LB1");
        enemy2.setText("LB2");
        easy.setText("Easy");
        medium.setText("Med");
        hard.setText("Hard");
        score.setText("Score: " + pscore);
        attempts.setText("Missed Attempts: " + pattempt);

        //Adds the buttons
        gamePanel.add(player);
        gamePanel.add(enemy1);
        gamePanel.add(enemy2);
        gamePanel.add(easy);
        gamePanel.add(medium);
        gamePanel.add(hard);

        //Set up rectangles
        Rectangle r1 = new Rectangle(default1, default1, 50, 50);
        Rectangle r2 = new Rectangle(edefault1, edefault2, sizeW, sizeL);
        Rectangle r3 = new Rectangle(edefault3, edefault4, sizeW, sizeL);

        //Sets the shape and placement of the objects
        easy.setBounds(new Rectangle(e1, e2, 70, 25));
        medium.setBounds(new Rectangle(m1, m2, 70, 25));
        hard.setBounds(new Rectangle(h1, h2, 70, 25));
        player.setBounds(r1);
        enemy1.setBounds(r2);
        enemy2.setBounds(r3);
        gameSpeed.setBounds(new Rectangle(210, 0, 100, 20));
        gamePanel.setFocusable(true);
        gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                int k = ke.getKeyCode();
                if (k == ke.VK_LEFT) {
                    p1 = p1 - gameSpeed.getValue();
                    if (p1 <= 0) {
                        p1 = p1 + gameSpeed.getValue();
                    }
                }
                if (k == ke.VK_RIGHT) {
                    p1 = p1 + gameSpeed.getValue();
                    if (p1 >= 1220) {
                        pscore++;
                        score.setText("Score: " + pscore);
                        p1 = default1;
                        p2 = default1;
                        lb1 = edefault1;
                        lb2 = edefault2;
                        setLb3(edefault3);
                        lb4 = edefault4;
                        player.setBounds(new Rectangle(default1, default1, 50, 50));
                        enemy1.setBounds(new Rectangle(edefault1, edefault2, sizeW, sizeL));
                        enemy2.setBounds(new Rectangle(edefault3, edefault4, sizeW, sizeL));
                    }
                }
                if (k == ke.VK_UP) {
                    p2 = p2 - gameSpeed.getValue();
                    if (p2 <= 20) {
                        p2 = p2 + gameSpeed.getValue();
                    }
                }
                if (k == ke.VK_DOWN) {
                    p2 = p2 + gameSpeed.getValue();
                    if (p2 >= 590) {
                        p2 = p2 - gameSpeed.getValue();
                    }
                }
                getPlayer().setBounds(new Rectangle(p1, p2, 50, 50));
                gamePanel.requestFocusInWindow();
            }
        });

        //Creates action listener for difficulty
        easy.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int a = 50;
                actionPerformed2(e, a);
            }
        });
        medium.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int a = 100;
                actionPerformed2(e, a);

            }
        });
        hard.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int a = 150;
                actionPerformed2(e, a);
            }
        });
        gamePanel.add(gameSpeed);
        requestFocusInWindow();
    }

    public void actionPerformed1(ActionEvent ae) {

        // Sets Line backer 1
        if (lb1 > p1) {
            lb1 = lb1 - gameSpeed.getValue();
            getEnemy1().setBounds(new Rectangle(lb1, lb2, sizeW, sizeL));
        }
        if (lb2 > p2) {
            lb2 = lb2 - gameSpeed.getValue();
            getEnemy1().setBounds(new Rectangle(lb1, lb2, sizeW, sizeL));
        }
        if (lb1 < p1) {
            lb1 = lb1 + gameSpeed.getValue();
            getEnemy1().setBounds(new Rectangle(lb1, lb2, sizeW, sizeL));
        }
        if (lb2 < p2) {
            lb2 = lb2 + gameSpeed.getValue();
            getEnemy1().setBounds(new Rectangle(lb1, lb2, sizeW, sizeL));
        }

        //Sets Line backer 2
        if (getLb3() > p1) {
            setLb3(getLb3() - gameSpeed.getValue());
            getEnemy2().setBounds(new Rectangle(getLb3(), lb4, sizeW, sizeL));
        }
        if (lb4 > p2) {
            lb4 = lb4 - gameSpeed.getValue();
            getEnemy2().setBounds(new Rectangle(getLb3(), lb4, sizeW, sizeL));
        }
        if (getLb3() < p1) {
            setLb3(getLb3() + gameSpeed.getValue());
            getEnemy2().setBounds(new Rectangle(getLb3(), lb4, sizeW, sizeL));
        }
        if (lb4 < p2) {
            lb4 = lb4 + gameSpeed.getValue();
            getEnemy2().setBounds(new Rectangle(getLb3(), lb4, sizeW, sizeL));
        }

        // Sets Collision
        if (lb1 <= (p1 + 50) || getLb3() <= (p1 + 50)) {
            pattempt++;
            attempts.setText("Missed Attempts: " + pattempt);
            p1 = default1;
            p2 = default1;
            lb1 = edefault1;
            lb2 = edefault2;
            setLb3(edefault3);
            lb4 = edefault4;
            player.setBounds(new Rectangle(default1, default1, 50, 50));
            enemy1.setBounds(new Rectangle(edefault1, edefault2, sizeW, sizeL));
            enemy2.setBounds(new Rectangle(edefault3, edefault4, sizeW, sizeL));
        }
        gamePanel.requestFocusInWindow();
    }

    public void actionPerformed2(ActionEvent ae, int a) {
        sizeL = a;
        enemy1.setBounds(new Rectangle(edefault1, edefault2, sizeW, sizeL));
        enemy2.setBounds(new Rectangle(edefault3, edefault3, sizeW, sizeL));
        gamePanel.requestFocusInWindow();
    }

    /**
     * @return the player
     */
    public JButton getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(JButton player) {
        this.player = player;
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

    /**
     * @return the score1
     */
    public JLabel getScore() {
        return score;
    }

    /**
     * @param score the score1 to set
     */
    public void setScore(JLabel score) {
        this.score = score;
    }

    /**
     * @return the attempts
     */
    public JLabel getAttempts() {
        return attempts;
    }

    /**
     * @param attempts the attempts to set
     */
    public void setAttempts(JLabel attempts) {
        this.attempts = attempts;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int getLb3() {
        return lb3;
    }

    private void setLb3(int lb3) {
        this.lb3 = lb3;
    }

}
