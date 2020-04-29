package ballew.rayTracer.primatives;

import ballew.rayTracer.utils.LIBUltra;

public interface Primitive {

    public LIBUltra.SHAPE_TYPES getShapeType();
    public int getID();
}
