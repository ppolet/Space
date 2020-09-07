
package space;

//Бомба
public class Bomb extends BaseObject{
    
    //10
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void move() {
        setY(y + 1);  //10 - бомба падает вниз  - просто увеличиваем y на 1.
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'B');
    }
    
    
}
