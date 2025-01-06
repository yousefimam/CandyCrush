package GameObjects;

import javax.swing.*;
import java.awt.*;

public class Board {

    int Width , Height;
    public Board(int x, int y) {
       Width = x;
       Height = y;
    }

    public void update(){

    }

    public void draw(Graphics2D g2d){

    }

    public Image objImage (){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Objects/bomb.png"));
        return imageIcon.getImage();
    }
}
