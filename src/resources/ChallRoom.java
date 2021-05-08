package resources;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChallRoom extends Room {

    private Button start;
    private Label challLabel;
    private boolean locked;
    private Monster m1;
    private Monster m2;
    private Monster m3;
    private boolean setup;
    private boolean complete;

    public ChallRoom(String roomNumber) {
        super(roomNumber);
        locked = false;
        start = new Button("Start");
        challLabel = new Label("Do you wish to start the Challenge Room!");
        challLabel.setStyle("-fx-text-fill: #FAEBD7");
        challLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        complete = false;
        setup = false;
        start.setFocusTraversable(false);
        start.setOnAction(e -> {
            start.setVisible(false);
            challLabel.setVisible(false);
            locked = true;
            addMultiMonsters();
            this.setIsSafe(false);
        });


    }

    public void setUp() {
        if (!setup) {
            this.getChildren().addAll(start, challLabel);
            start.relocate(100, 100);
            challLabel.relocate(100, 70);
            m1 = new MonsterOne(this.getPlayer());
            m2 = new MonsterTwo(this.getPlayer());
            m3 = new MonsterThree(this.getPlayer());
            setup = true;
        }
    }
    public void addMultiMonsters() {
        this.getMonsters().add(m1);
        this.getMonsters().add(m2);
        this.getMonsters().add(m3);
        //for (int i = 0; i < this.getMonsters().size(); i++) {
        //    this.getChildren().add(this.getMonsters().get(i));
        //}
        this.getChildren().addAll(m1, m2, m3);
        this.getMonsters().get(0).relocate(590, 225);
        this.getMonsters().get(1).relocate(390, 225);
        this.getMonsters().get(2).relocate(490, 425);
    }

    public Button getStart() {
        return start;
    }

    public void setStart(Button start) {
        this.start = start;
    }

    public Label getChallLabel() {
        return challLabel;
    }

    public void setChallLabel(Label challLabel) {
        this.challLabel = challLabel;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public void lockDoors() {
        if (this.getnDoor() != null) {
            this.getnDoor().setClosed();
        }
        if (this.geteDoor() != null) {
            this.geteDoor().setClosed();
        }
        if (this.getsDoor() != null) {
            this.getsDoor().setClosed();
        }
        if (this.getwDoor() != null) {
            this.getwDoor().setClosed();
        }
    }
    public void checkChall() {
        if (this.getMonsters().size() == 0 && !complete) {
            this.getPlayer().setMoneyValue(this.getPlayer().getMoneyValue() + 150);
            complete = true;
        }
    }
}
