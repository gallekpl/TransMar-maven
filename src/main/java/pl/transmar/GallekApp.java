package pl.transmar;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GallekApp extends Application {
	
	private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception{
        scene = new Scene(loadFXML("sample"), 800, 480);
        stage.setTitle("Trans - Mar");
        stage.setScene(scene);
        stage.show();
   
    }
    
    static void setRoot(String fxml) throws Exception {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(GallekApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
