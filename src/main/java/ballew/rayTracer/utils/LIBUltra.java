package ballew.rayTracer.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LIBUltra {

    public static final double EQUALITY_EPSILON = 0.000000001;

    public static void log(String messg){
        System.out.println(messg);
    }

    public static boolean isEqual(double a, double b) {
        if (Math.abs((a - b)) < EQUALITY_EPSILON) {
            return true;
        } else {
            return false;
        }
    }

    public static double round2places(double input){
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.valueOf(df.format(input));
    }

    public static double round3places(double input){
        DecimalFormat df = new DecimalFormat("0.000");
        return Double.valueOf(df.format(input));
    }

    public static double round4places(double input){
        DecimalFormat df = new DecimalFormat("0.0000");
        return Double.valueOf(df.format(input));
    }

    public static void printFormated(List<String> messages){
        String format = "%-40s%s%n";
    }

    public static String padInt(int i){
        return String.format("%02d" , i);
    }

    public static double round5places(double input){
        DecimalFormat df = new DecimalFormat("0.00000");
        return Double.valueOf(df.format(input));
    }

    public static double randomDouble(double lower, double upper){
        return ThreadLocalRandom.current().nextDouble(lower, upper + 1);
    }



    public static final int ONE_SECOND = 1000;
    public static final int HALF_SECOND = 500;
}
