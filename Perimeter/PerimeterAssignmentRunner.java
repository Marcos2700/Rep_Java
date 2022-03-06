import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int points = 0;
        for(Point currPt : s.getPoints()){
            points++;
        }
        return points;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double sum = 0;
        sum = getPerimeter(s);
        return sum/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double length = 0.0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            prevPt = currPt;
            if(currDist > length){
                length = currDist;
            }
        }
        return length;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double lX = 0.0;
        Point prevPt = s.getLastPoint();
        return lX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largest = 0;
        DirectoryResource d = new DirectoryResource();
        for(File f : d.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr); 
            double length = getPerimeter(s);
            if(length > largest){
                largest = length;
            }  
        }
        return largest;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largest = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > largest){
                largest = length;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println("Numbre of points = " + points);
        double avgLength = getAverageLength(s);
        System.out.println("Average length = " + avgLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest side = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double l = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = "+ l);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String f = getFileWithLargestPerimeter();
        System.out.println("File name with largest perimeter: "+f);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
