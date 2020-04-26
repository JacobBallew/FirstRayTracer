package ballew.rayTracer.domain;

import ballew.rayTracer.utils.LIBUltra;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageTranscoder;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void translation_1() {
        Matrix transform = Matrix.translation(5, -3, 2);
        Point p = new Point(-3, 4, 5);

        Assert.assertEquals(new Point(2, 1, 7), Point.toPoint(Matrix.multiplyByTuple(transform, p)));
    }

    @Test
    public void translation_2() {
        Matrix transform = Matrix.translation(5, -3, 2);
        Matrix inv = Matrix.inverse(transform);
        Point p = new Point(-3, 4, 5);

        Assert.assertEquals(new Point(-8, 7, 3), Point.toPoint(Matrix.multiplyByTuple(inv, p)));
    }

    @Test
    public void translation_3() {
        Matrix trans = Matrix.translation(5, -3, 2);
        Vector v = new Vector(-3, 4, 5);

        Assert.assertEquals(v, Vector.toVector(Matrix.multiplyByTuple(trans, v)));
    }

    @Test
    public void scaling_1() {
        Matrix trans = Matrix.scaling(2, 3, 4);
        Point p = new Point(-4, 6, 8);
        Assert.assertEquals(new Point(-8, 18, 32), Point.toPoint(Matrix.multiplyByTuple(trans, p)));
    }

    @Test
    public void scaling_2() {
        Matrix trans = Matrix.scaling(2, 3, 4);
        Vector p = new Vector(-4, 6, 8);
        Assert.assertEquals(new Point(-8, 18, 32), Vector.toVector(Matrix.multiplyByTuple(trans, p)));
    }

    @Test
    public void scaling_3() {
        Matrix trans = Matrix.scaling(2, 3, 4);
        Matrix inv = Matrix.inverse(trans);
        Vector v = new Vector(-4, 6, 8);

        Assert.assertEquals(new Vector(-2, 2, 2), Vector.toVector(Matrix.multiplyByTuple(inv, v)));
    }

    @Test
    public void rotationX() {
        Point p = new Point(0, 1, 0);
        Matrix halfQ = Matrix.rotationX(Math.PI / 4);
        Matrix fullQ = Matrix.rotationX(Math.PI / 2);

        Assert.assertEquals(new Point(0, LIBUltra.round4places(Math.sqrt(2) / 2), LIBUltra.round4places(Math.sqrt(2) / 2)), Point.toPoint(Matrix.multiplyByTuple(halfQ, p)));
        Assert.assertEquals(new Point(0, 0, 1), Point.toPoint(Matrix.multiplyByTuple(fullQ, p)));
    }

    @Test
    public void rotationY() {
        Point p = new Point(0, 0, 1);
        Matrix halfQ = Matrix.rotationY(Math.PI / 4);
        Matrix fullQ = Matrix.rotationY(Math.PI / 2);

        Assert.assertEquals(
                new Point(LIBUltra.round4places(Math.sqrt(2) / 2), 0, LIBUltra.round4places(Math.sqrt(2) / 2)),
                Point.toPoint(Matrix.multiplyByTuple(halfQ, p)));
        Assert.assertEquals(new Point(1, 0, 0), Point.toPoint(Matrix.multiplyByTuple(fullQ, p)));

    }

    @Test
    public void rotationZ() {
        Point p = new Point(0, 1, 0);
        Matrix halfQ = Matrix.rotationZ(Math.PI / 4);
        Matrix fullQ = Matrix.rotationZ(Math.PI / 2);

        Assert.assertEquals(
                new Point(-LIBUltra.round4places(Math.sqrt(2) / 2), LIBUltra.round4places(Math.sqrt(2) / 2), 0),
                Point.toPoint(Matrix.multiplyByTuple(halfQ, p)));
        Assert.assertEquals(new Point(-1, 0, 0), Point.toPoint(Matrix.multiplyByTuple(fullQ, p)));

    }
}