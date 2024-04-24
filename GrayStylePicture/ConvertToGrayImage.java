package GrayStylePicture;

import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

class ConvertToGrayImage {

    ImageResource grayStyle(ImageResource imgSrc) {
        // Creating a blank image of same
        ImageResource outImage = new ImageResource(imgSrc.getWidth(), imgSrc.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            // taking the image componets
            Pixel inImage = imgSrc.getPixel(pixel.getX(), pixel.getY());
            int red = inImage.getRed();
            int blue = inImage.getBlue();
            int green = inImage.getGreen();
            int average = (red + blue + green) / 3;
            // setting the gray style to the blank image created
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
        return outImage;
    }

    void testGrayImage() {
        ImageResource ir = new ImageResource();
        ImageResource returnImage = grayStyle(ir);
        returnImage.draw();
    }

    void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(file);
            ImageResource greyImage = grayStyle(inImage);
            greyImage.draw();
        }
    }
}