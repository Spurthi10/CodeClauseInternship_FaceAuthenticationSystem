// Updated main class to handle registration and login
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class Main extends Application {
    private DatabaseHandler dbHandler = new DatabaseHandler();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Face Authentication System");

        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();
        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();
        Button btnRegister = new Button("Register");
        Button btnLogin = new Button("Login");

        VBox vbox = new VBox(lblUsername, txtUsername, lblPassword, txtPassword, btnRegister, btnLogin);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

        btnRegister.setOnAction(e -> {
            // Handle registration
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            Mat face = FaceCapture.captureFace();
            byte[] faceData = convertMatToBytes(face);
            dbHandler.insertUser(username, password, faceData);
        });

        btnLogin.setOnAction(e -> {
            // Handle login
            String username = txtUsername.getText();
            Mat face = FaceCapture.captureFace();
            byte[] faceData = convertMatToBytes(face);
            // Perform face recognition and authentication
        });
    }

    private byte[] convertMatToBytes(Mat face) {
        // Convert Mat to byte array for database storage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
