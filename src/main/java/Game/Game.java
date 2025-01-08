package Game;

import GameObjects.Candy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

;
public class Game extends JPanel implements ActionListener {
    public static final int Rows = 12 , Col = 8;
    public static final long serialVersionId = 1l;
    Timer gameloop = new Timer(1500 , this);
    Candy [][] candies;
    Boolean [][] matches;
    Boolean match = true;
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
        updateBoard();
//        while (match){
//            updateBoard();
//        }
        addMouseListener(new MouseAdapter() {
            int fromx , fromy , tox , toy;

//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                checkMatches();
//                updateBoard();
//                removeAll();
//                for (int i = 4; i < Rows; i++) {
//                    for (int j = 0; j < Col; j++) {
//                        add(candies[i][j]);
//                    }
//                }
//            }

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
//                    checkMatches();
                    updateBoard();
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


        public Boolean checkMatches(){
        matches = new Boolean[Rows][Col];
            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j < Col; j++) {
                    matches[i][j] = false;
                }
            }
        match = false;
        //Horizontal
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Col - 2; j++) {
                if(candies[i][j].getImageval() == candies[i][j+1].getImageval() && candies[i][j+1].getImageval() == candies[i][j+2].getImageval()){
                    matches[i][j] = true;
                    matches[i][j+1] = true;
                    matches[i][j+2] = true;
                    match = true;
                }
            }
        }
        //Vertical
        for (int i = 0; i < Rows - 2; i++) {
            for (int j = 0; j < Col; j++) {
                if(candies[i][j].getImageval() == candies[i+1][j].getImageval() && candies[i+1][j].getImageval() == candies[i+2][j].getImageval()){
                    matches[i][j] = true;
                    matches[i+1][j] = true;
                    matches[i+2][j] = true;
                    match = true;
                }
            }
        }

        return match;
    }

        public void updateBoard (){

        checkMatches();

            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j < Col; j++) {
                    if(matches[i][j]) candies[i][j].setMatch(true);
                }
            }
        //Horizontal

        for (int j = 0; j < Col; j++) {
            for (int i = Rows - 1; i >= 0; i--) {
                if(candies[i][j].getMatch()){
                    if(i == 0) {
                        candies[i][j] = new Candy(0 , j);
                        continue;
                    }
                    int fromx = i - 1 , tox = i;
                    for (int k = fromx; k >= 0 ; k--) {
                        candies[tox][j] = candies[fromx][j];
                        candies[tox][j].setXY(tox , j);
                        fromx --; tox--;
                    }
                    candies[0][j] = new Candy(0 , j);
                }
            }
            checkMatches();
        }
    }

    /*UPDATE 2*/

//    public void updateBoard (){
//
//        checkMatches();
//
//        //Horizontal
//        int rowst = 0;
//        for (int i = 0; i < Rows; i++) {
//            rowst = i;
//            for (int j = 0; j < Col; j++) {
//                if(matches[i][j]){
//                    if(i == 0) {
//                        candies[i][j] = new Candy(0 , j);
//                        continue;
//                    }
//                    int fromx = rowst - 1 , tox = rowst;
//                    for (int k = fromx; k >= 0 ; k--) {
//                        candies[tox][j] = candies[fromx][j];
//                        candies[tox][j].setXY(tox , j);
//                        fromx --; tox--;
//                    }
//                    candies[0][j] = new Candy(0 , j);
//                }
//            }
//            checkMatches();
//        }
//    }

    /**/

    //UPDATE 1;
//    public void updateBoard (){
//
//        checkMatches();
//
//        //Horizontal
//        int len = 0 , rowst = 0 , st = 0 , end = 0;
//        for (int i = Rows-1; i >= 0; i--) {
//            rowst = i;
//            for (int j = 0; j < Col; j++) {
//                if(matches[i][j]){
//                    len++;
//                    if(len <= 1)
//                        st = j;
//                    else if (len > 1)
//                        end = j;
//                }
//                else {
//                    if(len < 3) {
//                        len = 0;
//                        st = 0;
//                        end = 0;
//                    }
//                    else {
//                        break;
//                    }
//                }
//
//            }
//            if(len > 2){
//                while(end >= st){
//                    int fromx = rowst - 1 , tox = rowst;
//                    for (int j = fromx; j >= 0 ; j--) {
//                        if(fromx == -1 || tox == -1 || end == -1){
//                            System.out.println("HI");
//                        }
//                        candies[tox][end] = candies[fromx][end];
//                        candies[tox][end].setXY(tox , end);
//                        fromx --; tox--;
//                    }
//                    candies[0][end] = new Candy(0 , end);
//                    end--;
//                }
//            }
//            checkMatches();
//        }
//    }

//    public void checkMoveMatches(){
//        matches = new Boolean[Rows][Col];
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 6; j++) {
//
//            }
//        }
//    }


    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        revalidate();
        repaint();
    }

}
