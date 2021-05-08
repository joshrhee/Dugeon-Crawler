package resources;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class VisInv extends TilePane {

    public VisInv() {
        this.setHgap(8);
        BackgroundFill bf = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        this.setBackground(new Background(bf));
        for (int i = 0; i < 5; i++) {
            this.getChildren().add(new ItemSlot());
        }
    }

    public void addItem(Item t) {
        t.setOnScreen(true);
        for (int i = 0; i < 5; i++) {
            ItemSlot is = (ItemSlot) this.getChildren().get(i);
            if (is.isEmpty()) {
                is.setItem(t);
                this.getChildren().set(i, this.getChildren().get(i));
                return;
            } else {
                this.getChildren().set(i, this.getChildren().get(i));
            }

        }
    }
    public void update() {
        for (int i = 0; i < 5; i++) {
            this.getChildren().set(i, this.getChildren().get(i));
        }
    }

}
