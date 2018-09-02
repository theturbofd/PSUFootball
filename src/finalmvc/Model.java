package finalmvc;

public class Model {

    public GamePanelmodel Model1 = new GamePanelmodel();
    public ScorePanelModel Model2 = new ScorePanelModel(Model1);

    GamePanelmodel getBot() {
        return Model1;
    }

    void setBot(GamePanelmodel x) {
        this.Model1 = Model1;
    }

    ScorePanelModel getTop() {
        return Model2;
    }

    void setTop(ScorePanelModel x) {
        this.Model2 = Model2;
    }

}
