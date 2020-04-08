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

    // Constructors
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

    // Class Methods

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

    public void fill(double num) {
        for (int i = 0; i < yRow; i++) {
            for (int j = 0; j < xCol; j++) {
                elements[i][j] = num;
            }
        }
    }

    public double getIndex(int yRow, int xCol) {
        return elements[yRow][xCol];
    }

    public void insertAt(double numToInsert, int yRow, int xCol) {
        elements[yRow][xCol] = numToInsert;
    }

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

    public static Matrix multiplyByIdentity4x4(Matrix m1) {
        return Matrix.multiplyByMatrix(m1, createIdentityMatrix());
    }

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
        return Tuple.fromList(res);
    }

    public static Tuple multiplyByTupleIdentity(Tuple t1) {
        return Matrix.multiplyByTuple(createIdentityMatrix(), t1);
    }

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

    public static Matrix createIdentityMatrix() {
        double[][] identityInput = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        return new Matrix(identityInput, 4, 4);
    }

    public static double determinant(Matrix m) {
        return m.elements[0][0] * m.elements[1][1] - m.elements[0][1] * m.elements[1][0];
    }

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
}
