package finalmvc;

import java.awt.*;
import javax.swing.*;

public class InitialController //extends JFrame
{

    public InitialController() {

        secondController inp = new secondController();
        MainView v = new MainView(inp);
        v.getX();

    }
}
