package ballew.rayTracer.chapters.chapter_01;

import ballew.rayTracer.domain.Point;
import ballew.rayTracer.domain.Vector;
import ballew.rayTracer.utils.LIBUltra;

public class Projectile {

    private Point position;
    private Vector velocity;

    public Projectile(Point position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void printMe() {
        String format = "%-10s     %-10s     %-10s     %-15s     %-15s     %-15s %n";
        String x = "X= " + LIBUltra.round2places(position.getX());
        String y = "Y= " + LIBUltra.round2places(position.getY());
        String z = "Z= " + LIBUltra.round2places(position.getZ());
        String vX = "Vel X= " + LIBUltra.round2places(velocity.getX());
        String vY = "Vel Y= " + LIBUltra.round2places(velocity.getX());
        String vZ = "Vel Z= " + LIBUltra.round2places(velocity.getX());
        System.out.format(format, x, y, z, vX, vY, vZ);
    }

    @Override
    public String toString() {
        return "X=" + position.getX() + "  Y=" + position.getY() + "  Z=" + position.getZ();
    }
}
