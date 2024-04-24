// package Perimeter;

// package Perimeter;

import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

public class Perimeter {

    public static void main(String[] args) {
        System.out.println("This program prints the permiter of any shape with agiven points");
        Perimeter.testPerimeter();
        
    }

    private static FileResource file;
    //private static Shape shape;
    public static void testPerimeter() {
        file = new FileResource();
        Shape shape = new Shape(file);
        double perimeter = getPerimeter(shape);
        double totalPoint = getTotalPoints(shape);
        double average = getAverage(perimeter,totalPoint);
        double largest = getLargestSide(shape);
        System.out.println(shape.getPoints());
        System.out.println("total perimeter is " + perimeter);
        System.out.println("total Point is " + totalPoint);
        System.out.println("total average is " + average);
        System.out.println("Largest size is " + largest);
    }

    private static double getPerimeter(Shape shape) {
        Point lastPoint = shape.getLastPoint();
        double totalPermiter = 0;
        for (Point currentpoint : shape.getPoints()) {
            totalPermiter += lastPoint.distance(currentpoint);
             lastPoint = currentpoint;
        }
        return totalPermiter;
    }
    
    private static double getAverage(double sum, double totalPoints){
         return (sum / totalPoints);
    }
    
    private static double getTotalPoints(Shape s){
        double count = 0;
    for(Point point : s.getPoints()){
        count ++;
    }
    System.out.println("count " + count);
    return count;
    }
    
      private static double getLargestSide(Shape s){
        double largest = 0;
        for(Point point : s.getPoints()){
            if(point.getX() > largest){
            largest= point.getX();
            }
        }
        return largest;
    }
}
