import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Face Authentication System");

        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();
        Button btnRegister = new Button("Register");
        Button btnLogin = new Button("Login");

        VBox vbox = new VBox(lblUsername, txtUsername, btnRegister, btnLogin);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

        btnRegister.setOnAction(e -> {
            // Handle registration
            String username = txtUsername.getText();
            registerUser(username);
        });

        btnLogin.setOnAction(e -> {
            // Handle login
            String username = txtUsername.getText();
            loginUser(username);
        });
    }

    private void registerUser(String username) {
        // Open camera and capture face for registration
    }

    private void loginUser(String username) {
        // Open camera and capture face for authentication
    }

    public static void main(String[] args) {
        launch(args);
    }
}
