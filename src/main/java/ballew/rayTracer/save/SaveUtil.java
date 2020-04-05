package ballew.rayTracer.save;

import ballew.rayTracer.ppm.CanvasPPM;
import ballew.rayTracer.utils.LIBUltra;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveUtil {

    public static void savePPM(CanvasPPM canvasPpm, String pathToSave) {
        File file = new File(pathToSave);

        try {
            FileWriter writer = new FileWriter(file);

            // Write header
            writer.write(canvasPpm.getIdentifier() + "\n");
            writer.write(canvasPpm.getWidth() + " " + canvasPpm.getHeight() + "\n");
            writer.write(canvasPpm.getColorScale() + "\n");

            // Write pixels
            for(int i = 0; i < canvasPpm.getHeight(); i++){
                for(int j = 0; j < canvasPpm.getWidth(); j++){

                }
            }



            // Close down
            writer.close();
            LIBUltra.log("File Saved to: " + pathToSave);
        } catch (IOException ex) {
            LIBUltra.log(ex.toString());
        }
    }
}
