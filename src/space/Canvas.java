
package space;

//Для отрисовки объектов
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(char[][] matrix) {
        this.matrix = matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
    
    //8 - будет "ставить точку в координатах x,y цветом c"
    public void setPoint(double x, double y, char c){
        int intX = (int)Math.round(x);
        int intY = (int)Math.round(y);
        if(!(intX<0 || intY<0 || intY>=matrix.length || intX>=matrix[0].length)){
            matrix[intY][intX] = c;
        }
    }
    
    //8 - копирует переданную ему картинку (матрицу) в матрицу Canvas. И не просто копирует, а начиная с координат x, y
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        
    }
    
}
