package Game;

import GameObjects.Candy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

;
public class Game extends JPanel implements ActionListener {

    public static final long serialVersionId = 1l;
    Timer gameloop = new Timer(50 , this);
    Candy [][] candies;
    public Game (){
        candies = new Candy [8][8];
        int fromx , fromy , tox , toy;
        setFocusable(true);
        setLayout(new GridLayout(8 ,8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Candy candy = new Candy(i , j);
                candies[i][j] = candy;
                add(candy);
            }
        }
        addMouseListener(new MouseAdapter() {
            int fromx , fromy , tox , toy;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Component component = getComponentAt(e.getPoint());
                Candy candy = (Candy) component;
                fromx = candy.geti();
                fromy = candy.getj();
                System.out.println(" " + fromx + " " + fromy);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Component component = getComponentAt(e.getPoint());
                Candy candy = (Candy) component;
                tox = candy.geti();
                toy = candy.getj();
                System.out.println(" " + tox + " " + toy);
                if (Math.abs(fromx - tox) == 1 || Math.abs(fromy - toy) == 1){
                    Candy temp;
                    temp = candies[fromx][fromy];
                    candies[fromx][fromy] = candies[tox][toy];
                    candies[tox][toy] = temp;
                }
            }
        });
//        addMouseMotionListener(new MouseMotionAdapter() {
//            int fromx , fromy , tox , toy;
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                super.mouseDragged(e);
//                Component component = getComponentAt(e.getPoint());
//                Candy candy = (Candy) component;
//                fromx = candy.geti();
//                fromy = candy.getj();
//                System.out.println(" " + fromx + " " + fromy);
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//            }
//        });

        gameloop.start();
    }



    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                candies[i][j].paint(g2d);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
