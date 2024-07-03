import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

public class FaceCapture {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static Mat captureFace() {
        VideoCapture camera = new VideoCapture(0);
        if (!camera.isOpened()) {
            System.out.println("Error: Camera is not available.");
            return null;
        }

        Mat frame = new Mat();
        camera.read(frame);

        CascadeClassifier faceDetector = new CascadeClassifier("path/to/haarcascade_frontalface_default.xml");
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(frame, faceDetections);

        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(frame, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

        camera.release();
        return frame;
    }

    public static void saveFace(Mat face, String filename) {
        Imgcodecs.imwrite(filename, face);
    }

    public static void main(String[] args) {
        Mat face = captureFace();
        if (face != null) {
            saveFace(face, "face.jpg");
        }
    }
}
