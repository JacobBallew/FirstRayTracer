package ballew.rayTracer.primitive;

import ballew.rayTracer.utils.LIBUltra;

public interface Primitive {

    public LIBUltra.SHAPE_TYPES getShapeType();
    public int getID();
    //public Primitive transform();
}
