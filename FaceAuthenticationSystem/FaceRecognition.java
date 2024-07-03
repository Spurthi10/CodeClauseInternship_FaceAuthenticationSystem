import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.face.LBPHFaceRecognizer;

public class FaceRecognition {
    public static boolean recognizeFace(Mat face, String filename) {
        LBPHFaceRecognizer recognizer = LBPHFaceRecognizer.create();
        recognizer.read(filename);

        Mat labels = new Mat();
        Mat histograms = new Mat();
        recognizer.predict(face, labels, histograms);

        int predictedLabel = (int) labels.get(0, 0)[0];
        return predictedLabel == 1;  // Assuming label 1 corresponds to the stored face
    }

    public static void main(String[] args) {
        Mat face = Imgcodecs.imread("face.jpg");
        boolean recognized = recognizeFace(face, "face.yml");
        System.out.println("Face recognized: " + recognized);
    }
}
