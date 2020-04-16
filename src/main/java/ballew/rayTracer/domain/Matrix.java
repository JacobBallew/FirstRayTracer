package ballew.rayTracer.domain;

import ballew.rayTracer.utils.LIBUltra;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    // Static Variables
    public static final int DEFAULT_SIZE = 4;

    // Class Variables
    private int xCol;
    private int yRow;
    private double[][] elements;

    /*----------------------------------------
        Constructors
     ----------------------------------------*/
    public Matrix() {
        this.xCol = DEFAULT_SIZE;
        this.yRow = DEFAULT_SIZE;
        this.elements = new double[yRow][xCol];
    }

    public Matrix(int size) {
        this.xCol = size;
        this.yRow = size;
        this.elements = new double[yRow][xCol];
    }

    public Matrix(int yRow, int xCol) {
        this.xCol = xCol;
        this.yRow = yRow;
        this.elements = new double[yRow][xCol];
    }

    public Matrix(double[][] input, int row, int col) {
        this.xCol = col;
        this.yRow = row;
        this.elements = new double[yRow][xCol];
        for (int i = 0; i < yRow; i++) {
            for (int j = 0; j < xCol; j++) {
                elements[i][j] = input[i][j];
            }
        }
    }

    /*----------------------------------------
        Class Methods
     ----------------------------------------*/

    @Override
    public boolean equals(Object o) {
        Matrix mo = (Matrix) o;
        for (int i = 0; i < yRow; i++) {
            for (int j = 0; j < xCol; j++) {
                if (!LIBUltra.isEqual(this.elements[i][j], mo.elements[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Fill a matrix with a particular value
     *
     * @param num
     */
    public void fill(double num) {
        for (int i = 0; i < yRow; i++) {
            for (int j = 0; j < xCol; j++) {
                elements[i][j] = num;
            }
        }
    }

    /**
     * Get Element at Index row, col
     *
     * @param yRow
     * @param xCol
     * @return
     */
    public double getIndex(int yRow, int xCol) {
        return elements[yRow][xCol];
    }

    /**
     * Insert element at index row col
     *
     * @param numToInsert
     * @param yRow
     * @param xCol
     */
    public void insertAt(double numToInsert, int yRow, int xCol) {
        elements[yRow][xCol] = numToInsert;
    }

    /**
     * Print the matrix nicely
     */
    public void print() {
        System.out.println();
        System.out.println("Matrix: " + yRow + " by " + xCol);
        for (int i = 0; i < yRow; i++) {
            for (int j = 0; j < xCol; j++) {
                System.out.print("[" + elements[i][j] + "] ");
            }
            System.out.println();
        }
    }

    /*-------------------------
    Static methods
    --------------------------*/

    /**
     * Multiply Matrix A by Matrix B
     *
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix multiplyByMatrix(Matrix m1, Matrix m2) {
        if (m1.xCol == m2.yRow) {
            Matrix result = new Matrix(m1.yRow, m2.xCol);

            double tempSum;
            double interimSum = 0;
            for (int i = 0; i < m1.yRow; i++) {
                for (int j = 0; j < m1.xCol; j++) {
                    for (int k = 0; k < m2.xCol; k++) {
                        tempSum = (m1.elements[i][k]) * (m2.elements[k][j]);
                        interimSum += tempSum;
                    }
                    result.elements[i][j] = interimSum;
                    interimSum = 0;
                }
            }
            return result;
        } else {
            LIBUltra.log("Matrices cannot be multiplied together. Invalid sizes");
            return null;
        }
    }

    /**
     * Multiply a matrix by the Identity Matrix (Like multiplying a number by "1")
     *
     * @param m1
     * @return
     */
    public static Matrix multiplyByIdentity4x4(Matrix m1) {
        return Matrix.multiplyByMatrix(m1, createIdentityMatrix());
    }

    /**
     * Multiply a matrix by a tuple
     *
     * @param a
     * @param t
     * @return a new tuple
     */
    public static Tuple multiplyByTuple(Matrix a, Tuple t) {
        List<Double> tupleLst = Tuple.toList(t);
        List<Double> res = new ArrayList<>();

        double interimSum = 0;
        for (int i = 0; i < a.yRow; i++) {
            for (int j = 0; j < a.xCol; j++) {
                double tempSum = a.elements[i][j] * tupleLst.get(j);
                interimSum += tempSum;
            }
            res.add(interimSum);
            interimSum = 0;
        }
//        res.forEach(i -> {
//            System.out.println(i);
//        });
        return Tuple.fromList(res);
    }

    /**
     * Multiply Tuple by matrix Identity
     *
     * @param t1
     * @return
     */
    public static Tuple multiplyByTupleIdentity(Tuple t1) {
        return Matrix.multiplyByTuple(createIdentityMatrix(), t1);
    }


    /**
     * Transpose (Flip Columns and Rows)
     *
     * @param m1
     * @return
     */
    public static Matrix transpose(Matrix m1) {
        // Only works with even matrices, 4x4, 3x3
        Matrix res = new Matrix(m1.elements.length);
        for (int i = 0; i < m1.yRow; i++) {
            for (int j = 0; j < m1.xCol; j++) {
                res.elements[j][i] = m1.elements[i][j];
            }
        }
        return res;
    }

    /**
     * Create an Identity Matrix
     *
     * @return
     */
    public static Matrix createIdentityMatrix() {
        double[][] identityInput = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        return new Matrix(identityInput, 4, 4);
    }

    /**
     * Calculate the determinant of a 2x2 matrix
     *
     * @param m
     * @return
     */
    public static double determinant2x2(Matrix m) {
        if (m.elements.length == 2) {
            return m.elements[0][0] * m.elements[1][1] - m.elements[0][1] * m.elements[1][0];
        } else {
            LIBUltra.log("Error, can only calculate determinant of a 2x2");
            return 0;
        }
    }

    /**
     * Calculate Determinant of an any sized matrix
     *
     * @param m
     * @return
     */
    public static double determinant(Matrix m) {
        double det = 0;
        if (m.elements.length == 2) {
            return determinant2x2(m);
        } else {
            for (int i = 0; i < m.elements.length; i++) {
                det = det + m.elements[0][i] * coFactor(m, 0, i);
            }
        }
        return det;
    }

    /**
     * Get SubMatrix at desired Row and Col
     *
     * @param m1
     * @param row
     * @param col
     * @return
     */
    public static Matrix subMatrix(Matrix m1, int row, int col) {
        // Only works with square matrices, 4x4, 3x3
        Matrix res = new Matrix(m1.elements.length - 1);
        int ii = 0;
        int jj = 0;
        for (int i = 0; i < m1.yRow; i++) {
            if (i != row) {
                for (int j = 0; j < m1.xCol; j++) {
                    if (j != col) {
                        res.elements[ii][jj] = m1.elements[i][j];
                        jj++;
                    }
                }
                jj = 0;
                ii++;
            }
        }
        return res;
    }

    /**
     * Calculates the Determinant of a submatrix
     *
     * @param m
     * @param row
     * @param col
     * @return
     */
    public static double minor(Matrix m, int row, int col) {
        return Matrix.determinant(Matrix.subMatrix(m, row, col));
    }

    /**
     * Get CoFactor
     *
     * @param m
     * @param row
     * @param col
     * @return
     */
    public static double coFactor(Matrix m, int row, int col) {
        double minor = minor(m, row, col);
        return Math.pow(-1, row + col) * minor;
    }

    /**
     * Checks if this matrix can be inverted
     *
     * @param m
     * @return
     */
    public static boolean isInvertible(Matrix m) {
        // If determinant is == 0 then it is not invertible
        return determinant(m) != 0;
    }

    /**
     * Creates the inverse of said matrix
     *
     * @param m
     * @return
     */
    public static Matrix inverse(Matrix m) {
        Matrix m2 = null;
        double ogDet = determinant(m);

        if (Matrix.isInvertible(m)) {
            m2 = new Matrix(m.elements.length);
            for (int i = 0; i < m2.getSize(); i++) {
                for (int j = 0; j < m2.getSize(); j++) {
                    double co = coFactor(m, i, j);
                    m2.elements[j][i] = co / ogDet;
                }
            }
        } else {
            LIBUltra.log("Matrix is not Invertible");
        }
        return m2;
    }
    /*---------------------------------
    Transformation (Motion) methods*/

    public static Matrix translation(double x, double y, double z) {
        Matrix res = Matrix.createIdentityMatrix();
        res.insertAt(x, 0, 3);
        res.insertAt(y, 1, 3);
        res.insertAt(z, 2, 3);
        return res;
    }

    public static Matrix scaling(double x, double y, double z) {
        Matrix res = Matrix.createIdentityMatrix();
        res.insertAt(x, 0, 0);
        res.insertAt(y, 1, 1);
        res.insertAt(z, 2, 2);
        return res;
    }

    public static Matrix rotationX(double radians) {
        Matrix rotTrans = createIdentityMatrix();
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 1, 1);
        rotTrans.insertAt(LIBUltra.round4places(-Math.sin(radians)), 1, 2);
        rotTrans.insertAt(LIBUltra.round4places(Math.sin(radians)), 2, 1);
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 2, 2);
        //rotTrans.print();
        return rotTrans;
    }

    public static Matrix rotationY(double radians) {
        Matrix rotTrans = createIdentityMatrix();
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 0, 0);
        rotTrans.insertAt(LIBUltra.round4places(Math.sin(radians)), 0, 2);
        rotTrans.insertAt(LIBUltra.round4places(-Math.sin(radians)), 2, 0);
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 2, 2);
        //rotTrans.print();
        return rotTrans;
    }

    public static Matrix rotationZ(double radians) {
        Matrix rotTrans = createIdentityMatrix();
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 0, 0);
        rotTrans.insertAt(LIBUltra.round4places(-Math.sin(radians)), 0, 1);
        rotTrans.insertAt(LIBUltra.round4places(Math.sin(radians)), 1, 0);
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 1, 1);
        //rotTrans.print();
        return rotTrans;
    }

    public static Matrix rotationZ_deg(double deg) {
        Matrix rotTrans = createIdentityMatrix();
        double radians = Math.toRadians(deg);
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 0, 0);
        rotTrans.insertAt(LIBUltra.round4places(-Math.sin(radians)), 0, 1);
        rotTrans.insertAt(LIBUltra.round4places(Math.sin(radians)), 1, 0);
        rotTrans.insertAt(LIBUltra.round4places(Math.cos(radians)), 1, 1);
        //rotTrans.print();
        return rotTrans;
    }

    public static Matrix shearing(double xy, double xz, double yx, double yz, double zx, double zy) {
        Matrix shearTrans = createIdentityMatrix();
        shearTrans.insertAt(xy, 0, 1);
        shearTrans.insertAt(xz, 0, 2);
        shearTrans.insertAt(yx, 1, 0);
        shearTrans.insertAt(yz, 1, 2);
        shearTrans.insertAt(zx, 2, 0);
        shearTrans.insertAt(zy, 2, 1);
        return shearTrans;
    }

    public static Matrix chainTransformations(List<Matrix> matrices) {
        Matrix res = matrices.get(matrices.size() - 1);
        for (int i = matrices.size() - 2; i >= 0; i--) {
            res = Matrix.multiplyByMatrix(res, matrices.get(i));
        }
        return res;
    }


    /*-------------------------
    Getters and Setters
     ------------------------*/
    public int getxCol() {
        return xCol;
    }

    public void setxCol(int xCol) {
        this.xCol = xCol;
    }

    public int getyRow() {
        return yRow;
    }

    public void setyRow(int yRow) {
        this.yRow = yRow;
    }

    public double[][] getElements() {
        return elements;
    }

    public void setElements(double[][] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return elements.length;
    }
}
