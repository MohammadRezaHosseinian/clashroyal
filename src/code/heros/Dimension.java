package code.heros;

/*
 **
 * this class handle dimension of heroes
 **
 */

public class Dimension {
    private double width;
    private double height;

    public Dimension(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public void setWidth(double w){
        this.width = w;
    }

    public void setHeight(double h){
        this.height = h;
    }
}
