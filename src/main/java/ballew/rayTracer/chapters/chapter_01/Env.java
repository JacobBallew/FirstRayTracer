package ballew.rayTracer.chapters.chapter_01;

import ballew.rayTracer.domain.Vector;

public class Env {

    private Vector gravity;
    private Vector wind;

    public Env(Vector gravity, Vector wind) {
        this.gravity = gravity;
        this.wind = wind;
    }

    public Vector getGravity() {
        return gravity;
    }

    public void setGravity(Vector gravity) {
        this.gravity = gravity;
    }

    public Vector getWind() {
        return wind;
    }

    public void setWind(Vector wind) {
        this.wind = wind;
    }
}
