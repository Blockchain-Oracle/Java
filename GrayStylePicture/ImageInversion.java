package GrayStylePicture;

import edu.duke.ImageResource;
import edu.duke.Pixel;

public class ImageInversion {

    ImageResource imageInversion(ImageResource outImage) {
        // create a blank new image
        ImageResource newImage = new ImageResource(outImage.getWidth(), outImage.getHeight());

        for (Pixel pixel : newImage.pixels()) {
            Pixel inImage = outImage.getPixel(pixel.getX(), pixel.getY());
            int red = 255 - inImage.getRed();
            int blue = 255 - inImage.getBlue();
            int green = 255 - inImage.getGreen();
            pixel.setBlue(blue);
            pixel.setGreen(green);
            pixel.setRed(red);
            pxInvert.setRed(255 - pxOrignal.getred);
            pxInvert.setGreen(255 - pxOrignal.getGreen);
            pxInvert.setBlue(255 - pxOrignal.getBlue);
        }
        return newImage;
    }

    void testImageInversion() {
        ImageResource img = new ImageResource();
        ImageResource returnImageInversion = imageInversion(img);
        returnImageInversion.draw();
    }
}
