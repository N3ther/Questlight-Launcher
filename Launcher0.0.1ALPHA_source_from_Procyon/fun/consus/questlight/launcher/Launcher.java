// 
// Decompiled by Procyon v0.5.36
// 

package fun.consus.questlight.launcher;

import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;
import javafx.scene.web.WebEngine;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.event.Event;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;

public class Launcher extends Application
{
    public void start(final Stage primaryStage) throws Exception {
        System.out.println("Setting up variables");
        final String gameVersion = "Game Version: 0.0.5a";
        final String launcherVersion = "Launcher Version: 0.0.1a";
        final Boolean debug = false;
        System.out.println("Creating launcher window");
        primaryStage.setTitle("Questlight Launcher");
        System.out.println("Loading JavaFX elements");
        final Button playButton = new Button("Play!");
        playButton.setText("Play!");
        playButton.setStyle("-fx-font-size: 2em");
        playButton.setPrefSize(310.0, 100.0);
        playButton.setOnAction((EventHandler)new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent event) {
                try {
                    Runtime.getRuntime().exec("cmd /c start \"\" Questlight.bat");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final Button githubButton = new Button("Github");
        githubButton.setText("GitHub");
        githubButton.setStyle("-fx-font-size: 2em");
        githubButton.setPrefSize(165.0, 50.0);
        githubButton.setOnAction((EventHandler)new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent event) {
                final WebView githubView = new WebView();
                final WebEngine gitEngine = githubView.getEngine();
                gitEngine.load("http://github.com/Questlight/Questlight-Alpha");
                final Text URL = new Text();
                URL.setText("Please note: GitHub does not look the best in the launcher, please go to https://github.com/Questlight/Questlight-Alpha in your favorite browser!");
                final VBox secondaryLayout = new VBox(new Node[] { (Node)githubView, (Node)URL });
                final Scene secondScene = new Scene((Parent)secondaryLayout, 640.0, 480.0);
                final Stage git = new Stage();
                git.setTitle("Questlight's GitHub Page");
                URL.wrappingWidthProperty().bind((ObservableValue)git.widthProperty());
                git.setScene(secondScene);
                git.setX(primaryStage.getX() + 200.0);
                git.setY(primaryStage.getY() + 100.0);
                URL.wrappingWidthProperty().bind((ObservableValue)git.widthProperty());
                git.setTitle("GitHub Browser");
                git.show();
            }
        });
        final Button exit = new Button("Exit");
        exit.setText("Exit");
        exit.setStyle("-fx-font-size: 2em");
        exit.setPrefSize(165.0, 50.0);
        exit.setOnAction(e -> Platform.exit());
        final VBox githubExit = new VBox(new Node[] { (Node)githubButton, (Node)exit });
        final Text gameVer = new Text();
        gameVer.setText(gameVersion);
        final Text launcherVer = new Text();
        launcherVer.setText(launcherVersion);
        final Text blank1 = new Text();
        final Text blank2 = new Text();
        final CheckBox debugMode = new CheckBox();
        debugMode.setText("Debug Mode");
        debugMode.setOnAction((EventHandler)new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent event) {
                if (debugMode.isSelected()) {
                    final Boolean debug = true;
                    System.out.println("Debug mode enabled");
                }
                else {
                    false;
                }
            }
        });
        final VBox versions = new VBox(new Node[] { (Node)gameVer, (Node)blank1, (Node)launcherVer, (Node)blank2, (Node)debugMode });
        final HBox topBar = new HBox(new Node[] { (Node)playButton, (Node)versions, (Node)githubExit });
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load("http://questlightupdate.tumblr.com");
        final VBox root = new VBox(new Node[] { (Node)topBar, (Node)webView });
        System.out.println("Drawing window");
        final Scene scene = new Scene((Parent)root, 600.0, 400.0);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(final String[] args) {
        Application.launch(args);
    }
}
