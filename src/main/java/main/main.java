package main;

import Game.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class main {
//    private Thread t1;
//    private Thread t2;
//    char [][] board;
//    String input = "a";
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
//        frame.setSize(950 , 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Game());
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Candy Crush Saga");
        Image im = null;
        try {
            ClassLoader myclass = main.class.getClassLoader();
            System.out.println(myclass.getClass());
            InputStream is = myclass.getResourceAsStream("Main/icon.png");
            im = ImageIO.read(is);
        }
        catch (IOException e){
            e.getMessage();
        }
        frame.setIconImage(im);

    }


//
//    private class TOne implements Runnable {
//        public void run() {
//            while(!input.equals("c")){
//                System.out.flush();
//                for (int i = 0; i < board.length; i++) {
//                    for (int i1 = 0; i1 < board.length; i1++) {
//                        System.out.print( board[i][i1] + " ");
//                    }
//                    System.out.println();
//                }
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
//
//    private class TTwo implements Runnable {
//        public void run() {
//            input = scanner.next();
//            char temp;
//            if (input.equals("x")){
//                temp = board[2][1] ;
//                board[2][1] = board[3][1];
//                board[3][1] = temp;
//            }
//        }
//    }
//
//    public main() {
//        board = new char[][] {
//                {'o', 'o', 'o', 'o'},
//                {'o', 'o', 'o', 'o'},
//                {'o', 'x', 'o', 'o'},
//                {'o', 'o', 'x', 'x'}
//        };
//        Thread t1 = new Thread(new TOne());
//        t1.start();
//        Thread t2 = new Thread(new TTwo());
//        t2.start();
//    }
}
