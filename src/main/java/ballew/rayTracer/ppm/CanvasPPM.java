package ballew.rayTracer.ppm;

import ballew.rayTracer.canvas.Canvas;
import ballew.rayTracer.domain.Color;
import ballew.rayTracer.utils.LIBUltra;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * PPM or Portable Pixmap, a simple image file
 */
public class CanvasPPM {

    public static final String IDENTIFIER = "P3";
    public static final String COLOR_SCALE = "255";

    private String identifier;
    private String colorScale;
    private int width;
    private int height;
    private Canvas canvas;

    public CanvasPPM(Canvas canvas) {
        this.canvas = canvas;
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();
        identifier = CanvasPPM.IDENTIFIER;
        colorScale = CanvasPPM.COLOR_SCALE;
    }

    public void savePPM(String pathToSave) {
        File file = new File(pathToSave);

        try {
            FileWriter writer = new FileWriter(file);

            // Write header
            writer.write(CanvasPPM.IDENTIFIER + "\n");
            writer.write(canvas.getWidth() + " " + canvas.getHeight() + "\n");
            writer.write(CanvasPPM.COLOR_SCALE + "\n");

            // Write pixels
            for (int i = 0; i < canvas.getHeight(); i++) {
                for (int j = 0; j < canvas.getWidth(); j++) {
                    Color scaledPixel = Canvas.scalePixel(canvas.pixelAt(i, j));

                    if (j < canvas.getWidth() - 1) {
                        writer.write((int)Math.ceil(scaledPixel.getRed()) + " " + (int)Math.ceil(scaledPixel.getGreen()) + " " + (int)Math.ceil(scaledPixel.getBlue()) + " ");
                    } else {
                        writer.write((int)Math.ceil(scaledPixel.getRed()) + " " + (int)Math.ceil(scaledPixel.getGreen()) + " " + (int)Math.ceil(scaledPixel.getBlue()) + "\n");
                    }
                }
            }

            // Close down
            writer.write("\n");
            writer.close();
            LIBUltra.log("File Saved to: " + pathToSave);
        } catch (IOException ex) {
            LIBUltra.log(ex.toString());
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getColorScale() {
        return colorScale;
    }

    public void setColorScale(String colorScale) {
        this.colorScale = colorScale;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
