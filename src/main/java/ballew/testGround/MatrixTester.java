package ballew.testGround;

import ballew.rayTracer.domain.Matrix;
import ballew.rayTracer.domain.Point;
import ballew.rayTracer.domain.Vector;
import ballew.rayTracer.utils.LIBUltra;
import io.cucumber.java.it.Ma;
import io.cucumber.java.tr.Ve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTester {


    public static void main(String[] args) {

        // Initial Point
        Point p = new Point(1, 0, 1);

        // Transform Matrices
        Matrix rotate = Matrix.rotationX(Math.PI / 2);
        Matrix scale = Matrix.scaling(5, 5, 5);
        Matrix translate = Matrix.translation(10, 5, 7);

        // Apply rotation
        Point p2 = Point.toPoint(Matrix.multiplyByTuple(rotate, p));
        System.out.println("Rotate: " + p2);

        // Apply Scale
        Point p3 = Point.toPoint(Matrix.multiplyByTuple(scale, p2));
        System.out.println("Scale: " + p3);

        // Apply translation
        Point p4 = Point.toPoint(Matrix.multiplyByTuple(translate, p3));
        System.out.println("Translate: " + p4);

        List<Matrix> matrixList = Arrays.asList(rotate,scale,translate);
        Matrix finalTransform = Matrix.chainTransformations(matrixList);
        Point p5 = Point.toPoint(Matrix.multiplyByTuple(finalTransform, p));
        System.out.println("Chained: " + p5);
    }
}
