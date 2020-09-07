
package space;

//Ракета
public class Rocket extends BaseObject{
    
    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void move() {
        setY(y - 1);  //11 - Ракета летит вверх (т.е. y уменьшается на 1)
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'R');
    }
    
    
}
