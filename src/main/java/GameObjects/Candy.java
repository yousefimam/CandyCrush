package GameObjects;

import Game.Candies;
import Game.Game;

import javax.swing.*;
import java.util.Random;


public class Candy extends JLabel {
    int x , y , imageval;

    Boolean match = false;
    private static int b = 0 , p = 0 , r = 0 , yl = 0 , g = 0 ;

    private static int cap = (int) Math.ceil((double) (Game.Rows * Game.Col) / 5);
    String imagesrc;

    public Candy(int x , int y) {
        this.x = x;
        this.y = y;
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

    public int getImageval() {
        return imageval;
    }

    private String RandShape (){
        Random random = new Random();
        String result = null;
        while(result == null){

            switch (random.nextInt() % 5){
                case 0:
                    if (b < cap) result = Candies.BLUECANDY.path;
                    imageval = Candies.BLUECANDY.val;
                    b++;
                    break;
                case 1:
                    if (g < cap) result = Candies.GREENCANDY.path;
                    imageval = Candies.GREENCANDY.val;
                    g++;
                    break;
                case 2:
                    if (r < cap) result = Candies.REDCANDY.path;
                    imageval = Candies.REDCANDY.val;
                    r++;
                    break;
                case 3:
                    if (yl < cap) result = Candies.YELLOWNDY.path;
                    imageval = Candies.YELLOWNDY.val;
                    yl++;
                    break;
                case 4:
                    if (p < cap) result = Candies.PURPLECANDY.path;
                    imageval = Candies.PURPLECANDY.val;
                    p++;
                    break;
            }
        }
        if(b < cap - 2 && yl < cap - 2 && g < cap - 2 && p < cap - 2 && r < cap - 2){
            b = 0;
            g = 0;
            yl = 0;
            p = 0;
            r = 0;
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

    public Boolean getMatch() {
        return match;
    }

    public void setMatch(Boolean match) {
        this.match = match;
    }
}
