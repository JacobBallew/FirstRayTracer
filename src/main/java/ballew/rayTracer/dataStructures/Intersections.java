package ballew.rayTracer.dataStructures;

import ballew.rayTracer.utils.LIBUltra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Intersections {

    List<Intersect> intersectList;


    public Intersections() {
        intersectList = new ArrayList<>();
    }

    public Intersections(List<Intersect> intersects) {
        intersectList = intersects;
    }

    public Intersections(Intersect... i) {
        intersectList = new ArrayList<>();
        add(i);
    }

    public List<Intersect> getIntersectList() {
        return intersectList;
    }

    public void add(Intersect i) {
        intersectList.add(i);
    }

    public void add(Intersect... i) {
        for (Intersect inter : i) {
            intersectList.add(inter);
        }
    }

    public void add(List<Intersect> intersects) {
        for (Intersect inter : intersects) {
            intersectList.add(inter);
        }
    }

    public int getCount() {
        return intersectList.size();
    }

    public Intersections sort() {
        Collections.sort(intersectList, new Comparator<Intersect>() {
            @Override
            public int compare(Intersect o1, Intersect o2) {
                return (int) o1.tValue() - (int) o2.tValue();
            }
        });
        return this;
    }

    public void print() {
        intersectList.forEach(i -> {
            System.out.println("T Value: " + i);
        });
    }

    public Intersect hit() {
        // Hit is the record with the lowest non negative tValue
        this.sort();
        for (Intersect in : intersectList) {
            if(in.tValue() >= 0){
                return in;
            }
        }
        return null;
    }

    // Static methods
    public static Intersect hit(Intersections intsc) {
        return intsc.hit();
    }

    public static Intersections sort(Intersections ins) {
        return ins.sort();
    }

    // Getters and Setters
    public Intersect getIntersect(int index) {
        return intersectList.get(index);
    }

    public double getIntersectElement(int intersectIndex) {
        return intersectList.get(intersectIndex).tValue();
    }

    public Intersect get(int index) {
        return intersectList.get(index);
    }


}
