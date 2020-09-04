
package space;

//--- базовый класс для всех объектов
public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;
    private boolean isAlive; //5 - жив объект или уже нет
    
    public BaseObject(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        isAlive = true;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isAlive() {
        return isAlive;
    }
    
    public void draw(){
        
    }
    
    public void move(){
        
    }
    
    public void die(){
        isAlive = false;
    }
    
    //6 - Он будет определять - "пересеклись" объекты или нет. Если пересеклись - возвращать true, если нет - false.
    /*
    Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия:
    eсли центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.
    Или еще проще:
    дистанция_между_объектами < max (радиус_первого_объекта, радиус_второго_объекта).
    */
    public boolean isIntersect(BaseObject o){
        double distance = Math.sqrt(Math.pow(x - o.getX(), 2) + Math.pow(y - o.getY(), 2));
        return (distance < Math.max(radius, o.getRadius()));
    }
}
