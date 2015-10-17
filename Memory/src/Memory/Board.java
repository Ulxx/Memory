/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memory;

import javax.swing.JPanel;

/**
 *
 * @author Miguel
 */
public class Board extends JPanel {
    /*
     Control del juego memory tabla 4x4 de fichas
    
     */

    private boolean visible, hold, shown;
    private int number;
    private boolean mode;
    public static final boolean Static = true;
    public static final boolean Dynamic = false;
    private Tab fichas[][];

    public Board(boolean Mode) {
        mode = Mode;
        fichas = new Tab[4][4]; 
        generateSolution();
        generateTable();  
    }
    private void generateSolution(){
    
    
    }
    
    private void generateTable(){
    
    
    }
    
    
    
    

    public boolean getMode() {
        return mode;
    }

    public void hide() {

    }

    public void show() {

    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag); //To change body of generated methods, choose Tools | Templates.
    }

    public void hold() {

    }

    public boolean isHold() {
        return hold;
    }

    public boolean isShown() {
        return shown;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setNumber() {

    }

    public int getNumber() {
        return number;
    }

}
