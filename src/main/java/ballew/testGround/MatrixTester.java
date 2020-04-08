package ballew.testGround;

import ballew.rayTracer.domain.Matrix;
import ballew.rayTracer.domain.Tuple;
import org.springframework.util.StopWatch;

public class MatrixTester {


    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        /*
        double[][] input1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 8, 7, 6},
                {5, 4, 3, 2}};

        double[][] input2 = {
                {-2, 1, 2, 3},
                {3, 2, 1, -1},
                {4, 3, 6, 5},
                {1, 2, 7, 8}};
//        double[][] input1 = {
//                {2, 3, 1},
//                {2, -7, 4}};
//
//        double[][] input2 = {
//                {3, 4, 5},
//                {1, 1, 4},
//                {2, 1, 4}};

        Matrix m1 = new Matrix(input1, 4, 4);
        Matrix m2 = new Matrix(input2, 4, 4);

        watch.start();
        Matrix m3 = Matrix.multiplyByMatrix(m1, m2);
        watch.stop();
        m1.print();
        m2.print();


        m3.print();

        System.out.println(watch.getTotalTimeSeconds());

         */

        /*
        double[][] input1 = {
                {1, 2, 3, 4},
                {2, 4, 4, 2},
                {8, 6, 4, 1},
                {0, 0, 0, 1}};

        Matrix m = new Matrix(input1,4,4);
        Tuple t1 = new Tuple(
                3,
                2,
                4,
                2
        );

        System.out.println(Matrix.multiplyByTuple(m, t1));


        Matrix a = new Matrix(new double[][]{
                {0, 9, 3, 0},
                {9, 8, 0, 8},
                {1, 8, 5, 3},
                {0, 0, 5, 8}}, 4, 4);
        Matrix b = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}, 3, 3);
        Matrix m2 = Matrix.transpose(a);
        m2.print();

        Matrix m3 = Matrix.transpose(Matrix.createIdentityMatrix());
        System.out.println(m3.equals(Matrix.createIdentityMatrix()));

         */
        Matrix a = new Matrix(new double[][]{
                {1, 5, 0},
                {-3, 2, 7},
                {0, 6, -3}}, 3, 3);

        Matrix a2 = new Matrix(new double[][]{
                {1, 5, 0, 5},
                {-3, 2, 7, 2},
                {0, 6, -3, 8},
                {1, 2, 3, 4}}, 4, 4);

        Matrix.subMatrix(a2, 1, 3).print();
    }
}
