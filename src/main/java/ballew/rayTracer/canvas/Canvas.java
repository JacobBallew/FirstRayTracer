package ballew.rayTracer.canvas;

import ballew.rayTracer.domain.Color;
import ballew.rayTracer.ppm.CanvasPPM;
import ballew.rayTracer.utils.LIBUltra;

import java.util.Arrays;
import java.util.List;

import static ballew.rayTracer.utils.LIBUltra.log;

public class Canvas {

    private int xCol;
    private int yRow;
    private final double DEFAULT_RGB_VALUE = 0;
    private Color[][] pixels;

    public Canvas(int dimension) {
        this.xCol = dimension;
        this.yRow = dimension;
        pixels = new Color[xCol][yRow];
        init();
    }

    public Canvas(int xCol, int yRow) {
        // array[ROW][COL]
        this.xCol = xCol;
        this.yRow = yRow;
        pixels = new Color[yRow][xCol];
        init();
    }

    private void init() {
        // Initialize pixel array
        for (int r = 0; r < yRow; r++) {
            for (int c = 0; c < xCol; c++) {
                pixels[r][c] = new Color(DEFAULT_RGB_VALUE);
            }
        }
    }

    public void writePixel(int yRow, int xCol, Color c) {
        if ((xCol >= 0 && xCol < getWidth() - 1) && (yRow >= 0 && yRow < getHeight() - 1))
            pixels[yRow][xCol] = c;
    }

    public void writePixelBold(int yRow, int xCol, Color c) {
        int yRowTop = yRow - 1;
        int yRowBottom = yRow + 1;
        int xColRight = xCol + 1;
        int xColLeft = xCol - 1;

        // Center
        writePixel(yRow, xCol, c);

        // Top
        writePixel(yRowTop, xCol, c);

        // Bottom
        writePixel(yRowBottom, xCol, c);

        // Left
        writePixel(yRow, xColLeft, c);

        // Right
        writePixel(yRow, xColRight, c);
    }

    public Color pixelAt(int row, int col) {
        return pixels[row][col];
    }

    public int getWidth() {
        return this.xCol;
    }

    public int getHeight() {
        return this.yRow;
    }

    public static Color scalePixel(Color c) {
        int scale = Integer.valueOf(CanvasPPM.COLOR_SCALE);

        // Scale
        double r = c.getRed() * scale;
        double g = c.getGreen() * scale;
        double b = c.getBlue() * scale;

        // Clamp values
        if (r < 0) {
            r = 0;
        }
        if (r > scale) {
            r = scale;
        }
        if (g < 0) {
            g = 0;
        }
        if (g > scale) {
            g = scale;
        }
        if (b < 0) {
            b = 0;
        }
        if (b > scale) {
            b = scale;
        }

        // Return scaled pixel/color
        return new Color(r, g, b);
    }

    public static Color deScalePixel(Color c) {
        int scale = Integer.valueOf(CanvasPPM.COLOR_SCALE);

        // Scale
        double r = c.getRed() / scale;
        double g = c.getGreen() / scale;
        double b = c.getBlue() / scale;

        // Clamp values
        if (r < 0) {
            r = 0;
        }
        if (r > scale) {
            r = scale;
        }
        if (g < 0) {
            g = 0;
        }
        if (g > scale) {
            g = scale;
        }
        if (b < 0) {
            b = 0;
        }
        if (b > scale) {
            b = scale;
        }

        // Return scaled pixel/color
        return new Color(r, g, b);
    }

    public void setSolidColor(Color c) {
        for (int i = 0; i < yRow; i++) {
            for (int j = 0; j < xCol; j++) {
                pixels[i][j] = c;
            }
        }
    }

    public int getYMid() {
        return getHeight() / 2;
    }

    public int getXMid() {
        return getWidth() / 2;
    }

    // Static Methods
    public static void writePixel(Canvas canvas, int yRow, int xCol, Color c) {
        if ((xCol >= 0 && xCol < canvas.getWidth() - 1) && (yRow >= 0 && yRow < canvas.getHeight() - 1))
            canvas.writePixel(yRow, xCol, c);
    }

    public static Color pixelAt(Canvas canvas, int row, int col) {
        return canvas.pixelAt(row, col);
    }


    public void print() {
        log("Canvas Print Out");
        for (int k = 0; k < xCol; k++) {
            System.out.print("   " + LIBUltra.padInt(k) + "         ");
        }
        System.out.println();
        for (int i = 0; i < yRow; i++) {
            System.out.print(LIBUltra.padInt(i) + " ");
            for (int j = 0; j < xCol; j++) {

                Color current = pixels[i][j];
                System.out.print("[" + current.getRed() + "|" + current.getGreen() + "|" + current.getBlue() + "] ");
                ;
            }
            System.out.println();
        }
    }
}
