package content;

import javafx.scene.input.KeyCode;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Michał Martyniak on 19.03.2016.
 */
public class Snake {
    private Point head;             //coordinates of snake's head
    private ArrayList<Point> body;  //holds body segments

    /*  create snake that has ony HEAD with given coordinates   */
    public Snake(int staryAtX, int startAtY) {
        head = new Point(staryAtX,startAtY);      //head always exist
        body = new ArrayList<>();                 //at the begining body is empty
    }

    /*  changes the coordinates of snake's head (and convert old head to new body element)  */
    //change to boolean later(for collision)
    public void move(KeyCode key){
        body.add(head);                 //save head as a body now

        switch (key){
            case W:
                head.translate(0,-1);   //x stays the same, y one upper
                break;
            case S:
                head.translate(0,1);    //x stays the same, y one down
                break;
            case A:
                head.translate(-1,0);   //x one left, y stays the same
                break;
            case D:
                head.translate(1,0);    //x one right, y stays the same
                break;
            default:                    //no other key is allowed currently(we can add something in here later)
                break;
        }
    }

    /*  returns list of ALL coordinates that belong to that snake */
    public ArrayList<Point> wholeSnake(){
        ArrayList<Point> wholeSnakeList = body;
        wholeSnakeList.add(head);
        return wholeSnakeList;
    }

    //TODO collision method(firstly with borders)
    //TODO collison with it's body( when snake make a closed circle)
    
}