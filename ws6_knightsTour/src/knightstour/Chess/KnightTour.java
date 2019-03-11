package knightstour.Chess;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KnightTour extends JFrame {
   // private int[][] board = new int[8][8];
    private JButton[][] squares = new JButton[8][8]; // buttons for each squares of chess board
    private final static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private final static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int currentRow, currentColumn; // moveNumber is btw 0 and 7
    private Container contents;
    private static int click;
    private static int squaresTouched;
    private static int steps = 1;


    //constructor
    KnightTour(){
        super("Knight's Tour");

        currentRow = 0;
        currentColumn = 0;
        click = 0;
       // moveNumber = 0; // moveNumber should be btw 0 and 7
        squaresTouched = 0;

        /*for(int i = 0; i < 8; ++i){
            for(int j = 0; j < 8; ++j){
                board[i][j] = 0;
            }
        }*/

        contents = getContentPane(); // create pane
        contents.setLayout(new GridLayout(8,8));


        // make chess board
        for(int i = 0; i < 8; ++i){
            for(int j = 0; j < 8; ++j){
                squares[i][j] = new JButton();
                if((i + j) % 2 != 0) {
                    squares[i][j].setBackground(Color.black);
                    squares[i][j].setOpaque(true);
                    squares[i][j].setBorderPainted(false);
                }
                if((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.white);
                    squares[i][j].setOpaque(true);
                    squares[i][j].setBorderPainted(false);
                }
                contents.add(squares[i][j]);

                //anonymous inner class for button event handling
                squares[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        for(int i = 0; i < 8; ++i){
                            for(int j= 0; j < 8; ++j){
                                if(e.getSource() == squares[i][j]){
                                    if(click == 0){
                                        currentRow = i;
                                        currentColumn = j;
                                        squares[currentRow][currentColumn].setBackground(Color.red);
                                        squares[currentRow][currentColumn].setOpaque(true);
                                        squares[currentRow][currentColumn].setBorderPainted(false);
                                        squares[currentRow][currentColumn].setText(Integer.toString(steps++));
                                        click++;
                                    }
                                    showValidMoves(); //check the move is in rage
                                    doClick(i, j);
                                    return;
                                }
                            }
                        }
                    }
                });
            }
        }

        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null); // locate the frame on center of screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showValidMoves(){
        int moveCount = 0;
        //should be less then 8 and more then 0
        for(int a = 0; a < 8; ++a){
            if(currentRow + vertical[a] < 8 && currentRow + vertical[a] >= 0
            && currentColumn + horizontal[a] < 8 && currentColumn + horizontal[a] >= 0
            && squares[currentRow + vertical[a]][currentColumn + horizontal[a]].getBackground() != Color.red){

                moveCount++;
                squares[currentRow + vertical[a]][currentColumn + horizontal[a]].setBackground(Color.green);

            }
        }
        if(moveCount > 0) //after checking the vaild move, return back to event handler
            return;

        squaresTouched++; //count steps

        // when there is no more step to move, pop up the message
        JOptionPane.showMessageDialog(null, "The knight moved " + squaresTouched + " steps",
                "Tour Finished", JOptionPane.PLAIN_MESSAGE);
    }

    private boolean isValidMove(int i, int j){
        // get absolute value using Math.abs
        int row = Math.abs(i - currentRow);
        int col = Math.abs(j - currentColumn);

        if( ((row == 1 && col == 2) || (row == 2 && col == 1)) && (squares[i][j].getBackground() != Color.red) ){
            squaresTouched++;
            return true;
        }
        return false;
    }

    private void doClick(int i, int j){
        if (!isValidMove(i, j))
            return;

        // when column and row are both valid
        currentRow = i;
        currentColumn = j;
        squares[currentRow][currentColumn].setBackground(Color.red);
        squares[currentRow][currentColumn].setText(Integer.toString(steps++)); //count steps and display it on chessboard squares

        // chang the green squares back to chess board's black and white color
        for(int a = 0; a < 8; ++a){
            for(int b = 0; b < 8; ++b){
                if(squares[a][b].getBackground() == Color.green){
                    if((a + b) % 2 != 0) {
                        squares[a][b].setBackground(Color.black);
                        squares[a][b].setOpaque(true);
                        squares[a][b].setBorderPainted(false);
                    }
                    if((a + b) % 2 == 0) {
                        squares[a][b].setBackground(Color.white);
                        squares[a][b].setOpaque(true);
                        squares[a][b].setBorderPainted(false);
                    }
                }
            }
        }

        showValidMoves();
    }

    public static void main(String[] args){
        new KnightTour();
    }
}
