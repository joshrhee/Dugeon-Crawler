package resources;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Door extends ImageView {
    private Image closed;
    private Image open;
    private boolean isOpen = true;

    public Door() {
        closed = new Image("content/door0.png");
        open = new Image("content/door1.png");
        this.setImage(open);
    }

    public void setOpen() {
        this.setImage(open);
        isOpen = true;
    }

    public void setClosed() {
        this.setImage(closed);
        isOpen = false;
    }



    public Image getClosed() {
        return closed;
    }

    public Image getOpen() {
        return open;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
