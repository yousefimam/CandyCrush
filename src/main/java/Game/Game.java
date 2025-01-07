package Game;

import GameObjects.Candy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

;
public class Game extends JPanel implements ActionListener {
    public static final int Rows = 12 , Col = 8;
    public static final long serialVersionId = 1l;
    Timer gameloop = new Timer(50 , this);
    Candy [][] candies;
    public Game (){
        candies = new Candy [Rows][Col];
        setFocusable(true);
        setLayout(new GridLayout(Rows - 4 , Col));
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Col; j++) {
                Candy candy = new Candy(i , j);
                candies[i][j] = candy;
                if(i > 3) add(candies[i][j]);
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
                if ((Math.abs(fromx - tox) == 1 && (fromy - toy) == 0) || (Math.abs(fromy - toy) == 1) && (fromx - tox) == 0){
                    Candy temp;
                    temp = candies[fromx][fromy];
                    candies[fromx][fromy] = candies[tox][toy];
                    candies[fromx][fromy].setXY(fromx , fromy);
                    temp.setXY(tox , toy);
                    candies[tox][toy] = temp;
//                   candies[fromx][fromy].setImagesrc(candies[tox][toy].getImagesrc());
//                   candies[tox][toy].setImagesrc(temp);
                    removeAll();
                    for (int i = 4; i < Rows; i++) {
                        for (int j = 0; j < Col; j++) {
                            add(candies[i][j]);
                        }
                    }
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


    //    public void checkMatches(){
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 6; j++) {
//
//            }
//        }
//    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                candies[i][j].revalidate();
//                candies[i][j].repaint();
//            }
//        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        revalidate();
        repaint();
    }

}
