/*
У нас будет космический корабль, который стреляет ракетами в НЛО.
А НЛО в свою очередь сбрасывает на корабль бомбы.
*/
package space;

//Космос

import java.util.ArrayList;
import java.util.List;

public class Space {

    private int width;
    private int height;
    private SpaceShip ship;
    private List<Ufo> ufos = new ArrayList<>();         //список для хранения всех НЛО
    private List<Rocket> rockets = new ArrayList<>();   //список для хранения всех ракет
    private List<Bomb> bombs = new ArrayList<>();       //список для хранения всех бомб

    public Space(int width, int height){
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }
    
    public void setShip(SpaceShip ship){
        this.ship = ship;
    }
    
    public void run(){
        
    }
    
    public void draw(){
        
    }
    
    public void sleep(int ms){
        
    }
    
    public static void main(String[] args) {
        
    }
    
}