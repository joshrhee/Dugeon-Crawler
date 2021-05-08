package resources;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.beans.EventHandler;

public class ItemSlot extends StackPane {

    private boolean isEmpty;
    private Item item;
    private int count;

    public ItemSlot() {
        this.getChildren().add(new Rectangle(50, 50, Color.GREY));
        isEmpty = true;
        this.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!isEmpty && item != null) {
                    item.setActive(true);
                    count--;
                }
                if (count == 0) {
                    removeItem();
                }
            }
        });
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void removeItem() {
        this.getChildren().remove(item);
        item = null;
        isEmpty = true;
    }
    public void setItem(Item it) {
        item = it;
        isEmpty = false;
        this.getChildren().add(item);
        this.count = 1;
    }
}
