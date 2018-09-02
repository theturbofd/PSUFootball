package finalmvc;

import javax.swing.JFrame;

public class Jframeview extends JFrame {

    public Jframeview(secondController inp) {

        super("Final Project");
        add(inp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
    }
}
