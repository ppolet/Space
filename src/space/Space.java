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
    
    public static Space game;   //10

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

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }
    
    
    public void run(){
        
    }
    
    public void draw(){
        
    }
    
    public void sleep(int ms){
        
    }
    
    //15 - Метод должен возвращать один общий список всех объектов типа BaseObject
    public List<BaseObject> getAllItems(){
        List<BaseObject> list = new ArrayList<>();
        list.addAll(ufos);
        list.addAll(bombs);
        list.addAll(rockets);
        list.add(ship);
        return list;
    }
    
    //15 - Метод должен двигать все объекты по одному разу
    public void moveAllItems(){
        for(BaseObject obj: getAllItems()){
            obj.move();
        }
    }
    
    //16 - Если список НЛО пуст - создай один корабль в центре сверху
    public void createUfo(){
        if (ufos.isEmpty()){
            ufos.add(new Ufo(width/2, 0));
        }
    }
    
    //16 - проверить - не пересеклись между собой какая-нибудь бомба и корабль
    public void checkBombs(){
        for(Bomb b: bombs){
            //пересеклись - корабль и бомба умирают  - die()
            if(b.isIntersect(ship)){
                ship.die();
                b.die();
            }
            //Если бомба упала за границу экрана y > height бомба тоже умирает
            if (b.getY()>=height){
                b.die();
            }
        }
    }
    
    //16 - Надо проверить - не пересеклись между собой какая-нибудь ракета и НЛО
    public void checkRockets(){
        for(Rocket r: rockets){
            for(Ufo u: ufos){
                // ракета и нло умирают  - die()
                if(r.isIntersect(u)){
                    r.die();
                    u.die();
                }
            }
            // Если ракета улетела за границу экрана y < 0, ракета тоже умирает
            if(r.getY() < 0){
                r.die();
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
