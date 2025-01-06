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
    private static int b = 0 , p = 0 , r = 0 , yl = 0 , g = 0 ;
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


    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
        setIcon(new ImageIcon(getClass().getResource(imagesrc)));
    }

    private String RandShape (){
        Random random = new Random();
        String result = null;
        while(result == null){

            switch (random.nextInt() % 5){
                case 0:
                    if (b < 14) result = Candies.BLUECANDY.path;
                    b++;
                    break;
                case 1:
                    if (g < 14) result = Candies.GREENCANDY.path;
                    g++;
                    break;
                case 2:
                    if (r < 14) result = Candies.REDCANDY.path;
                    r++;
                    break;
                case 3:
                    if (yl < 14) result = Candies.YELLOWNDY.path;
                    yl++;
                    break;
                case 4:
                    if (p < 14) result = Candies.PURPLECANDY.path;
                    p++;
                    break;
            }
        }
        return result;
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
