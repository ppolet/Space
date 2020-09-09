
package space;

//НЛО
public class Ufo extends BaseObject{
    
    //картинка для отрисовки
    private static final int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
    };
    
    public Ufo(double x, double y) {
        super(x, y, 3);
    }
    
    //14
    @Override
    public void move() {
        double dx = Math.random() * 2 - 1;  //-1..1
        double dy = Math.random() * 2 - 1;  //-1..1        
        x += dx;
        if(y + dy <= Space.game.getHeight() / 2){
            y += dy;
        }
        
        //14.в С вероятностью 10% корабль должен стрелять - вызывать метод fire.
        if (Math.random()<0.1){
            fire();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }
    
    public void fire(){
        Space.game.getBombs().add(new Bomb(x, y));
    }
}
