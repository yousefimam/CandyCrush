package GameObjects;

import Game.Candies;
import Game.GlobalPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;


public class Candy extends JLabel {
    int x , y;
    String imagesrc;

    public Candy(int x , int y) {
        this.x = x;
        this.y = y;
        Random r;
        imagesrc = RandShape();
        setIcon(new ImageIcon(getClass().getResource(imagesrc)));
//        addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                System.out.println("Hi");
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
//                System.out.println(" " + x + " " + y);
//            }
//        });
//        addMouseMotionListener(new MouseMotionAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                System.out.println("Dragged");
//                System.out.println(" " + x + " " + y);
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//                Component component = getComponentAt(e.getPoint());
//                Candy candy = (Candy) component;
//                System.out.println("Moved To : " + " " + candy.geti() + " " + candy.getj());
//            }
//        });
    }

    private String RandShape (){
        Random random = new Random();
        switch (random.nextInt() % 5){
            case 0:
                return Candies.BLUECANDY.path;
            case 1:
                return Candies.GREENCANDY.path;
            case 2:
                return Candies.REDCANDY.path;
            case 3:
                return Candies.YELLOWNDY.path;
            case 4:
                return Candies.PURPLECANDY.path;
        }
        return Candies.PURPLECANDY.path;
    }
    public int geti() {
        return x;
    }

    public int getj() {
        return y;
    }

    public void setXY(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public void update(){

    }

//    public void draw(Graphics2D g2d){
//        g2d.drawImage(objImage() ,null , null);
//    }
//
//    public Image objImage (){
//        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagesrc));
//        return imageIcon.getImage();
//    }
}
