package ballew.rayTracer.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TupleTest {

    @Test
    public void isPoint() {
        Tuple p = new Tuple(1,2,3,1);
        Assert.assertEquals(true, p.isPoint());
    }


}