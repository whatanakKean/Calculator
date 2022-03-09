import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage mainStage) throws Exception {
        //setting up UI from FXML file into stage
        Parent root = FXMLLoader.load(getClass().getResource("CalculatorInterface.fxml"));
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        
        //setting up logo, title
        Image image = new Image("https://th.bing.com/th/id/OIP.0D4484MfIolBC9XYyWjwcgHaHa?w=219&h=219&c=7&r=0&o=5&pid=1.7");
        mainStage.getIcons().add(image);
        mainStage.setTitle("Calculator");
        mainStage.setResizable(false);
        mainStage.show();
    }
}
