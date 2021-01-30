import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Tutorial11 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX 8 Tutorial 11 - menus ");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 600, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);

        //File menu
        Menu fileMenu = new Menu("File");
        MenuItem item1 = new MenuItem("New Project          Ctrl+Shift+N");
        MenuItem item2 = new MenuItem("Open Project         Ctrl+Shift+O");
        MenuItem item3 = new MenuItem("Exit");
        item3.setOnAction(e -> Platform.exit());
        fileMenu.getItems().addAll(item1, item2, new SeparatorMenuItem(), item3);

        //toolBar
        Menu toolbars = new Menu("Tool Bar");
        toolbars.getItems().addAll(
                new CheckMenuItem("File"),
                new CheckMenuItem("Run"),
                new CheckMenuItem("Debug")
        );
        //View Menu
        Menu viewMenu = new Menu("View");
        CheckMenuItem check1 = new CheckMenuItem("Editor");
        check1.setSelected(true);
        CheckMenuItem check2 = new CheckMenuItem("Line Number");
        check2.setSelected(true);
        viewMenu.getItems().addAll(check1, check2, new SeparatorMenuItem(), toolbars);

        //Mode Menu
        Menu mode = new Menu("Mode");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem mode1 = new RadioMenuItem("Desktop");
        mode1.setToggleGroup(tGroup);
        RadioMenuItem mode2 = new RadioMenuItem("Tablet");
        mode2.setToggleGroup(tGroup);
        mode2.setSelected(true);

        mode.getItems().addAll(mode1, mode2);

        menuBar.getMenus().addAll(fileMenu, viewMenu,mode);


        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
