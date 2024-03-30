package code;

import image.Pixel;
import image.APImage;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */
    private static APImage x;
    public static void main(String[] args) {
        //x = new APImage("cyberpunk2077.jpg");
        //x.draw();

        //grayScale("cyberpunk2077.jpg");
        //blackAndWhite("cyberpunk2077.jpg");
        //edgeDetection("cyberpunk2077.jpg",20);
        //reflectImage("cyberpunk2077.jpg");
        rotateImage("cyberpunk2077.jpg");
    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        x = new APImage(pathOfFile);

        for (Pixel p : x) {
            int a = getAverageColour(p);
            p.setGreen(a);
            p.setRed(a);
            p.setBlue(a);
        }

        x.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        return (pixel.getBlue() + pixel.getGreen() + pixel.getRed()) / 3;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        x = new APImage(pathOfFile);

        for (Pixel p : x) {
            if (getAverageColour(p) >= 128) {
                p.setGreen(255);
                p.setRed(255);
                p.setBlue(255);
            } else {
                p.setGreen(0);
                p.setRed(0);
                p.setBlue(0);
            }
        }

        x.draw();
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        x = new APImage(pathToFile);
        Pixel asd;

        for (int i = x.getWidth()-1; i > 0; i--) {
            for (int j = x.getHeight()-1; j > 0; j--) {
                Pixel p = x.getPixel(i,j);
                Pixel left = x.getPixel(i-1,j);
                Pixel down = x.getPixel(i,j-1);
                if (Math.abs(getAverageColour(p)-getAverageColour(left)) > threshold || Math.abs(getAverageColour(p)-getAverageColour(down)) > threshold) {
                    asd = new Pixel(0,0,0);
                } else asd = new Pixel(255,255,255);
                x.setPixel(i,j,asd);
            }
        }

        x.draw();
    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {
        x = new APImage(pathToFile);
        Pixel[][] arr = new Pixel[x.getWidth()][x.getHeight()];
        APImage y = new APImage(x.getWidth(),x.getHeight());
        int a = 0, b = 0;

        for (int i = x.getWidth()-1; i >= 0; i--) {
            for (int j = 0; j < x.getHeight(); j++) {
                arr[a][b++] = x.getPixel(i,j);
            }
            a++;
            b=0;
        }
        for (int i = 0; i < x.getWidth(); i++) {
            for (int j = 0; j < x.getHeight(); j++) {
                Pixel p = arr[i][j];
                y.setPixel(i,j,p);
            }
        }
        y.draw();
    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {

    }

}
