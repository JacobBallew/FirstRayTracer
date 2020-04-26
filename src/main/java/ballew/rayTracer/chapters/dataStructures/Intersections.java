package ballew.rayTracer.chapters.dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Intersections {

    List<Intersect> intersectList;

    public Intersections(){
        intersectList = new ArrayList<>();
    }

    public List<Intersect> getIntersectList() {
        return intersectList;
    }

    public void add(Intersect i){
        intersectList.add(i);
    }

    public void add (Intersect... i){
        for(Intersect inter : i){
            intersectList.add(inter);
        }
    }

    public int getCount(){
        return intersectList.size();
    }

    public Intersect getIntersect(int index){
        return intersectList.get(index);
    }

    public double getIntersectElement(int intersectIndex){
        return intersectList.get(intersectIndex).tValue();
    }
}
