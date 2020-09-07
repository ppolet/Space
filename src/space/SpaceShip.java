package space;

//Космический корабль
public class SpaceShip extends BaseObject{
    //картинка корабля для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };

    private double dx = 0; //12 - будет хранить направление движения корабля
    
    //12.a
    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }
    
    @Override
    public void move() {
        x = x + dx;
        checkBorders(x, y, radius);  //13 - проверить, не вылез ли корабль за границы космоса [0, Space.game.getWidth()]
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'M');
    }
    
    //12.в - корабль каждый ход идет на 1 влево
    public void moveLeft(){
        dx = -1;
    }
    
    //12.г - корабль каждый ход идет на 1 вправо
    public void moveRight(){
        dx = 1;
    }
    
    //13
    public void fire(){
        Space.game.getRockets().add(new Rocket(x-2, y));
        Space.game.getRockets().add(new Rocket(x+2, y));
    }

}
