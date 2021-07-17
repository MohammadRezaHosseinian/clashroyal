package code.heros;

public class Position {
    private double width;
    private double height;

    public Position(double x, double y){
        this.height = y;
        this.width = x;
    }

    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
