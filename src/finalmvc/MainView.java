package finalmvc;

public class MainView {

    public Jframeview Model1;

    MainView(secondController inp) {

        Model1 = new Jframeview(inp);

    }

    Jframeview getX() {
        return Model1;
    }

    void setX(GamePanelmodel x) {
        this.Model1 = Model1;
    }

}
