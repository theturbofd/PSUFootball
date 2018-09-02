package finalmvc;

import java.awt.*;
import javax.swing.*;

public class secondController extends JPanel {

    public secondController() {
        super();
        setBackground(Color.gray);
        Model panel = new Model();
        setLayout(new BorderLayout());
        panel.getTop().setPreferredSize(new Dimension(100, 50));
        add(panel.getTop(), "North");
        add(panel.getBot(), "Center");
    }
}
