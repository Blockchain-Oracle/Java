package GrayStylePicture;

import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

public class ImageSaver {

    void imageSaver(String newNameIntials) {
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            ImageResource imageResource = new ImageResource(file);
            String fileName = file.getName();
            String newName = newNameIntials + fileName;
            imageResource.setFileName(newName);
            imageResource.save();
        }
    }
}
