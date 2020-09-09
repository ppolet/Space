/*
У нас будет космический корабль, который стреляет ракетами в НЛО.
А НЛО в свою очередь сбрасывает на корабль бомбы.
*/
package space;

//Космос

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
     /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем холст для отрисовки.
        Canvas canvas = new Canvas(width, height);

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Игра работает, пока корабль жив
        while (ship.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если "стрелка влево" - сдвинуть фигурку влево
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    //Если "пробел" - запускаем шарик
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            //двигаем все объекты игры
            moveAllItems();

            //проверяем столкновения
            checkBombs();
            checkRockets();
            //удаляем умершие объекты из списков
            removeDead();

            //Создаем НЛО (1 раз в 10 ходов)
            createUfo();

            //Отрисовываем все объекты на холст, а холст выводим на экран
            canvas.clear();
            draw(canvas);
            canvas.print();

            //Пауза 300 миллисекунд
            Space.sleep(300);
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }
   
     
    public void draw(Canvas canvas){
        //draw game
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++) {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }

        for (BaseObject object : getAllItems()) {
            object.draw(canvas);
        }
    }
    
    public static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(Space.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception in void sleep: " + ex.getMessage());
        }
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
        } else if (Math.random()<0.1){
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
    
    //16 - В это методе удали из списков ufos, rockets, bombs все мертвые объекты (isAlive() == false)
    public void removeDead(){
        for(int i = 0; i < ufos.size(); i++){
            if (!ufos.get(i).isAlive()){
                ufos.remove(i);
            }
        }
        for(int i = 0; i < rockets.size(); i++){
            if (!rockets.get(i).isAlive()){
                rockets.remove(i);
            }
        }
        for(int i = 0; i < bombs.size(); i++){
            if (!bombs.get(i).isAlive()){
                bombs.remove(i);
            }
        }
    }
    
    public static void main(String[] args) {
        game = new Space(20, 20);
        game.setShip(new SpaceShip(10, 18));
        game.run();
    }
    
}
