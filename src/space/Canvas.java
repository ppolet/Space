
package space;

//Для отрисовки объектов
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
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
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] != 0){
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }
    
    //9 - Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать
    public void clear(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                setPoint(j, i, ' ');
            }
        }
    }
    
    //9 - Этот метод отрисовывает матрицу на экран.
    public void print(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Ufos: " + Space.game.getUfos().size());
    }
    
}
