package Muslim_Qibla.Controllers;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

//hello i am ruining the code by useless comments
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Mushaf implements Initializable{
    @FXML
    TextField ayahSearchField;
    @FXML
    AnchorPane anchor;
    @FXML
    ImageView backgroundImage;
    @FXML
    Rectangle shadeRectangle;
    @FXML
    Rectangle menu;
    @FXML
    Line horizontalLine;
    @FXML
    Line horizontalLine2;
    @FXML
            //hello i am ruining the code by useless comments
    Rectangle quranRectangle;
    @FXML
    TextFlow quranBody;
    @FXML
    Polyline rightArrow;
    @FXML
    Polyline leftArrow;
    @FXML
    Button pageButton;
    @FXML
    Rectangle ayahSearchRec;
    @FXML
    ImageView searchIcon;
    @FXML
    Text surah;
    @FXML
    Button surahButton;
    @FXML
    Text juz;
    @FXML
    Button juzButton;
    @FXML
    ScrollPane scrollMenu;
    @FXML
    Text menuTitle;
    @FXML
    Line verticalLine;
    @FXML
    Button saveButton;
    @FXML
    Button additionButton;
    @FXML
    Button deleteButton;
    @FXML
    TextField additionTextField;
    @FXML
    Text additionText;
    @FXML
    Rectangle additionRec;
    char []arabicNumbers = new char[]{'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
    @FXML
    ChangeListener<Number> quranRectangleHeightListener =(observableValue, number, t1) -> {
        double half = quranRectangle.getLayoutY() + quranRectangle.getHeight()/2 - 25;
        double x = 250 - 187;
        double top = quranRectangle.getLayoutY() + quranRectangle.getHeight() * ( x/761);
        AnchorPane.setTopAnchor(leftArrow, half);
        AnchorPane.setTopAnchor(rightArrow, half);
        AnchorPane.setTopAnchor(quranBody,top);
    };
    @FXML
    ChangeListener<Number> quranRectangleWidthListener = ((observableValue, number, t1) -> {
        double half = quranRectangle.getLayoutX() + quranRectangle.getWidth()/2 ;

        pageButton.setLayoutX(half - 75);
        menu.setLayoutX(half - menu.getWidth()/2);
        scrollMenu.setLayoutX(menu.getLayoutX() + 50);
        horizontalLine.setLayoutX(menu.getLayoutX() + 50);
        horizontalLine2.setLayoutX(menu.getLayoutX() + 50);
    });
    @FXML
    ChangeListener<Number> quranBodyHeightListener = ((observableValue, oldValue, newValue) ->{
        changeFont(newValue.doubleValue(),"h");
    } );
    ChangeListener<Number> quranBodyWidthListener = ((observableValue, oldValue, newValue) ->{
        changeFont(newValue.doubleValue(),"w");
    } );
    ChangeListener<Number> anchorWidthListener = ((observableValue, oldValue, newValue) ->{
        int baseAnchorWidth = 1440;
        int xOffset = 119;

        double newAnchorWidth = anchor.getWidth();
        double newQuranRecWidth = 950;
        double newMenuWidth = 680;
        double newScrollMenuWidth = 605;
        double newAyahSearchRecWidth = newAnchorWidth - (baseAnchorWidth - 450 - xOffset);

        double differenceBetweenNewAndBaseAnchorWidth = newAnchorWidth - baseAnchorWidth;
        double proportion = 395.0/450;


        if(newAnchorWidth >= baseAnchorWidth){
            newQuranRecWidth = newAnchorWidth - (baseAnchorWidth - newQuranRecWidth);
            menu.setWidth(newMenuWidth);
            scrollMenu.setPrefWidth(newScrollMenuWidth);
            ayahSearchField.setPrefWidth(450);

            quranRectangle.setLayoutX(219);

            rightArrow.setLayoutX(290);

            searchIcon.setLayoutX(634.4);
            ayahSearchField.setLayoutX(220);

            quranBody.setLayoutX(290);

            surah.setLayoutX(737);
            surahButton.setLayoutX(532);

            juz.setLayoutX(425);
            juzButton.setLayoutX(219.2);
            additionTextField.setPrefWidth(400);
            additionTextField.setLayoutX(590 + differenceBetweenNewAndBaseAnchorWidth);


        }else if (newAnchorWidth < baseAnchorWidth && newAnchorWidth > baseAnchorWidth - xOffset){
            quranRectangle.setLayoutX(219 + differenceBetweenNewAndBaseAnchorWidth);
            rightArrow.setLayoutX(290 + differenceBetweenNewAndBaseAnchorWidth);
            searchIcon.setLayoutX(634.4 + differenceBetweenNewAndBaseAnchorWidth);
            ayahSearchField.setLayoutX(220 + differenceBetweenNewAndBaseAnchorWidth);
            quranBody.setLayoutX(290 + differenceBetweenNewAndBaseAnchorWidth);
            surah.setLayoutX(737 + differenceBetweenNewAndBaseAnchorWidth);
            surahButton.setLayoutX(532 + differenceBetweenNewAndBaseAnchorWidth);
            juz.setLayoutX(425 + differenceBetweenNewAndBaseAnchorWidth);
            juzButton.setLayoutX(219.2 + differenceBetweenNewAndBaseAnchorWidth);
            additionTextField.setLayoutX(590 + differenceBetweenNewAndBaseAnchorWidth);

            double half = quranRectangle.getLayoutX() + quranRectangle.getWidth()/2;

            pageButton.setLayoutX(half - 75);
            menu.setLayoutX(half - menu.getWidth()/2);
            scrollMenu.setLayoutX(menu.getLayoutX() + 50);
            horizontalLine.setLayoutX(menu.getLayoutX() + 50);
            horizontalLine2.setLayoutX(menu.getLayoutX() + 50);

            menu.setWidth(newMenuWidth);
            scrollMenu.setPrefWidth(newScrollMenuWidth);
            ayahSearchField.setPrefWidth(450);
            additionTextField.setPrefWidth(400);

        }else if (newAnchorWidth <= baseAnchorWidth - xOffset){
            newQuranRecWidth = newAnchorWidth - (baseAnchorWidth - newQuranRecWidth - xOffset);
            int min = 1100;
            if(newAnchorWidth >= min) {
                newMenuWidth = differenceBetweenNewAndBaseAnchorWidth + (newMenuWidth + xOffset);
                newScrollMenuWidth = differenceBetweenNewAndBaseAnchorWidth + (newScrollMenuWidth + xOffset);
                additionTextField.setPrefWidth(differenceBetweenNewAndBaseAnchorWidth + 400 + xOffset);

            }else{
                newMenuWidth = (min - baseAnchorWidth) + (newMenuWidth + xOffset);
                newScrollMenuWidth = (min - baseAnchorWidth) + (newScrollMenuWidth + xOffset);
                additionTextField.setLayoutX(menu.getLayoutX() + 240);
            }

            menu.setWidth(newMenuWidth);
            scrollMenu.setPrefWidth(newScrollMenuWidth);

            quranRectangle.setLayoutX(219 - xOffset);
            rightArrow.setLayoutX(290- xOffset);
            ayahSearchRec.setLayoutX(220 - xOffset);
            quranBody.setLayoutX(290- xOffset );
            surah.setLayoutX(737 - xOffset);
            surahButton.setLayoutX(532 - xOffset);
            juz.setLayoutX(425 - xOffset);
            juzButton.setLayoutX(219.2 - xOffset);

            if(anchor.getWidth() >= 1100) {
                ayahSearchField.setPrefWidth(newAyahSearchRecWidth);
                searchIcon.setLayoutX(634.4 + differenceBetweenNewAndBaseAnchorWidth);
            } else{
                newAyahSearchRecWidth = 1100 - (baseAnchorWidth - 450 - xOffset);
                ayahSearchField.setPrefWidth(newAyahSearchRecWidth);
                searchIcon.setLayoutX(634.4 - 340);
            }
            ayahSearchField.setLayoutX(220 - xOffset);

        }
        quranRectangle.setWidth(newQuranRecWidth);
    });
    ChangeListener<Number> anchorHeightListener = ((observableValue, oldValue, newValue) -> {
        scrollMenu.setPrefHeight((newValue.doubleValue() - 1024) + (645));
    });
    ChangeListener<Number> anchorHeightListener2 = ((observableValue, oldValue, newValue) -> {
        scrollMenu.setPrefHeight((newValue.doubleValue() - 1024) + (645 - 60));
    });
    //hello i am ruining the code by useless comments
    public void addListeners() {
        quranRectangle.widthProperty().addListener(quranRectangleWidthListener);
        quranRectangle.heightProperty().addListener(quranRectangleHeightListener);
        quranBody.prefHeightProperty().addListener(quranBodyHeightListener);
        quranBody.prefWidthProperty().addListener(quranBodyWidthListener);
        anchor.widthProperty().addListener(anchorWidthListener);
        anchor.heightProperty().addListener(anchorHeightListener);
        menuTitle.wrappingWidthProperty().addListener((observableValue, oldValue, newValue) ->{
            changeFont2(newValue.doubleValue());
        } );
        horizontalLine.layoutXProperty().addListener((observableValue, oldValue, newValue) ->{
            saveButton.setLayoutX(newValue.doubleValue());
            menuTitle.setLayoutX(newValue.doubleValue());
            additionText.setLayoutX(newValue.doubleValue());
            additionButton.setLayoutX(newValue.doubleValue());
            deleteButton.setLayoutX(newValue.doubleValue() + 140);
        } );
        horizontalLine.endXProperty().addListener((observableValue, oldValue, newValue) ->{
            menuTitle.setWrappingWidth(newValue.doubleValue());
            additionText.setWrappingWidth(newValue.doubleValue());
        } );
    }
    public void bindWidth(){
        backgroundImage.fitWidthProperty().bind(anchor.widthProperty());
        shadeRectangle.widthProperty().bind(anchor.widthProperty());
        horizontalLine.endXProperty().bind(menu.widthProperty().subtract(680-580));
        horizontalLine2.endXProperty().bind(menu.widthProperty().subtract(680-580));
        quranBody.prefWidthProperty().bind(quranRectangle.widthProperty().subtract(950-785));
    }
    public void bindHeight() {
        backgroundImage.fitHeightProperty().bind(anchor.heightProperty());
        shadeRectangle.heightProperty().bind(anchor.heightProperty());
        quranRectangle.heightProperty().bind(anchor.heightProperty().subtract(1024 - 761));
        menu.heightProperty().bind(anchor.heightProperty().subtract(1024 - 800));
        quranBody.prefHeightProperty().bind(anchor.heightProperty().subtract(1024-675));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        verticalLine = new Line();
        verticalLine.setStartX(0);
        verticalLine.setEndX(0);
        verticalLine.setStartY(0);
        verticalLine.setEndY(605);
        verticalLine.setStrokeWidth(2);
        verticalLine.setStroke(Paint.valueOf("white"));
        verticalLine.setVisible(true);
        verticalLine.setSmooth(true);
        verticalLine.setFill(Paint.valueOf("white"));

        horizontalLine2 = new Line();
        horizontalLine2.setLayoutX(440);
        horizontalLine2.setLayoutY(580 - 50);
        horizontalLine2.setStartX(0);
        horizontalLine2.setStartY(0);
        horizontalLine2.setEndY(0);
        horizontalLine2.setEndX(580);
        horizontalLine2.setStrokeWidth(2);
        horizontalLine2.setStroke(Paint.valueOf("white"));
        anchor.getChildren().add(horizontalLine2);
        AnchorPane.setBottomAnchor(horizontalLine2, 1024 - 605 - 252 + 50d);
        horizontalLine2.toBack();

        saveButton = new Button("حفظ");
        saveButton.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
        saveButton.setLayoutY(135);
        saveButton.setPrefWidth(130);
        saveButton.setPrefHeight(20);
        saveButton.setFont(Font.font("Tajwal",16));
        anchor.getChildren().add(saveButton);
        saveButton.toBack();

        deleteButton = new Button("حفظ");
        deleteButton.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
        deleteButton.setLayoutY(135);
        deleteButton.setPrefWidth(130);
        deleteButton.setPrefHeight(20);
        deleteButton.setFont(Font.font("Tajwal",16));
        anchor.getChildren().add(deleteButton);
        deleteButton.toBack();

        additionButton = new Button("إضافة");
        additionButton.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
        additionButton.setPrefWidth(130);
        additionButton.setPrefHeight(20);
        additionButton.setFont(Font.font("Tajwal",16));
        anchor.getChildren().add(additionButton);
        AnchorPane.setBottomAnchor(additionButton, 800-665d);
        additionButton.toBack();

        additionTextField = new TextField();
        additionTextField.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/textField.css");
        additionTextField.setFont(Font.font("noon", 16));
        additionTextField.setPrefWidth(400);
        additionTextField.setAlignment(Pos.CENTER_RIGHT);
        additionTextField.setStyle("-fx-padding: 2.5 15 2.5 0");
        anchor.getChildren().add(additionTextField);
        AnchorPane.setBottomAnchor(additionTextField, 800-665d);

        additionTextField.toBack();

        additionText = new Text("إضافة علامة جديدة");
        additionText.setFont(Font.font("noon",22));
        additionText.setFill(Paint.valueOf("White"));
        additionText.setTextAlignment(TextAlignment.RIGHT);
        additionText.setWrappingWidth(580);
        additionText.setFontSmoothingType(FontSmoothingType.GRAY);
        additionText.setBoundsType(TextBoundsType.VISUAL);
        anchor.getChildren().add(additionText);
        AnchorPane.setBottomAnchor(additionText, 800-615d);

        additionText.toBack();



        bindWidth();

        bindHeight();

        addListeners();

    }
    public void menuToFront(){
        shadeRectangle.toFront();
        menu.toFront();
        horizontalLine.toFront();
        scrollMenu.toFront();
        menuTitle.toFront();
    }
    public void menuToBack(){
        shadeRectangle.toBack();
        menu.toBack();
        horizontalLine.toBack();
        scrollMenu.toBack();
        menuTitle.toBack();
        verticalLine.toBack();
        horizontalLine2.toBack();
        saveButton.toBack();
        deleteButton.toBack();
        additionButton.toBack();
        additionTextField.toBack();
        additionText.toBack();
    }
    public String toArabicNumbers(int number) {
        String pageNumber = "";
        int temp = number;
        while(temp !=0){
            char temp2 = arabicNumbers[temp%10];
            pageNumber += temp2;
            temp/=10;
        }

        pageNumber = new StringBuilder(pageNumber).reverse().toString();

        return pageNumber;
    }
    public void changeFont(double newValue, String type){
        if (quranBody.getChildren().get(0) instanceof Text && quranBody.getHeight()!=0 && quranBody.getWidth()!=0) {
            Text text = (Text) quranBody.getChildren().get(0);
            String font = text.getFont().getFamily();
            double size = 32;
            int prefHeight = 800;
            int prefWidth = 800;
            int pref = prefWidth * prefHeight;
            if (type.equals("w")){
                newValue = newValue * quranBody.getPrefHeight();
            }else if (type.equals("h")){
                newValue =  (newValue * quranBody.getPrefWidth());
            }
            double proportion = newValue/pref;

            if (proportion < 0.05){
                size = (size * (proportion + 0.2));
            }
            else if (proportion < 0.1){
                size = (size * (proportion + 0.24));
            }else if (proportion < 0.2){
                size = (size * (proportion + 0.28));
            }
            else if (proportion <= 0.51){
                size = (size * (proportion + 0.285));
            }else if (proportion <= 1){
                size = (size * (proportion + 0.22));
            }else{
                size = (size * (proportion + 0.2));
            }

            for (int i = 0; i < quranBody.getChildren().size(); i++) {
                if(quranBody.getChildren().get(i) instanceof Text) {
                    Text temp1 = (Text) quranBody.getChildren().get(i);
                    temp1.setFont(Font.font(font, size));
                }
                //hello i am ruining the code by useless comments
            }
        }
    }
    public void changeFont2(double newValue) {

        Text text = menuTitle;
        String font = text.getFont().getFamily();
        double size = 32;

        double proportion = newValue / 580;

        if (proportion < 0.05) {
            size = (size * (proportion + 0.2));
        } else if (proportion < 0.1) {
            size = (size * (proportion + 0.24));
        } else if (proportion < 0.2) {
            size = (size * (proportion + 0.28));
        } else if (proportion <= 0.51) {
            size = (size * (proportion + 0.285));
        } else if (proportion <= 1) {
            size = (size * (proportion + 0.22));
        } else {
            size = (size * (proportion + 0.2));
        }

        menuTitle.setFont(Font.font(font, size));
    }
    public void setScrollMenuAndMenuTitle(String menuName, Node content, int style){
        double x = scrollMenu.getLayoutX();
        double y = scrollMenu.getLayoutY();
        double prefWidth = scrollMenu.getPrefWidth();
        double prefHeight;

        anchor.getChildren().remove(scrollMenu);
        anchor.getChildren().remove(menuTitle);

        anchor.heightProperty().removeListener(anchorHeightListener);
        anchor.heightProperty().removeListener(anchorHeightListener2);

        if(style != 3){
            anchor.heightProperty().addListener(anchorHeightListener);
            prefHeight = (anchor.getHeight() - 1024) + (645 );
        }else{
            anchor.heightProperty().addListener(anchorHeightListener2);
            prefHeight = (anchor.getHeight() - 1024) + (645 - 60);
        }

        AnchorPane temp = new AnchorPane();
        temp.getChildren().add(content);

        if(style == 1){
            temp.getChildren().add(verticalLine);
            verticalLine.setLayoutX(275);
            verticalLine.setLayoutY(0);
            verticalLine.setEndY(temp.getHeight());
            content.toFront();
            verticalLine.toFront();
        }

        scrollMenu = new ScrollPane(temp);

        scrollMenu.setLayoutX(x);
        scrollMenu.setLayoutY(y);
        scrollMenu.setPrefWidth(prefWidth);
        scrollMenu.setPrefHeight(prefHeight);
        scrollMenu.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollMenu.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollMenu.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/scrollPane.css");

        menuTitle.setFont(Font.font("noon" , 36));
//        changeFont2(menuTitle.getWrappingWidth());
        menuTitle.setText(menuName);
        menuTitle.setFill(Paint.valueOf("white"));

        if(style == 1) {
            menuTitle.setTextAlignment(TextAlignment.CENTER);
        }else if(style == 2 || style == 3){
            menuTitle.setTextAlignment(TextAlignment.RIGHT);
        }

        menuTitle.setLayoutY(160);
        menuTitle.setLayoutX(horizontalLine.getLayoutX());

        menuTitle.setWrappingWidth(horizontalLine.getEndX());

        menuTitle.setFill(Paint.valueOf("white"));
        menuTitle.setFontSmoothingType(FontSmoothingType.GRAY);

        anchor.getChildren().add(scrollMenu);
        anchor.getChildren().add(menuTitle);
    }
    public GridPane savepoint(){
        VBox surahName = new VBox(16);
        VBox pageNumber = new VBox(18.7);
        VBox savepointName = new VBox(10);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);

        for(int i = 0; i < 200; i++)
        {
            Text name = new Text("سورة الفاتحة");
            name.setFont(Font.font("noon",22));
            name.setFill(Paint.valueOf("White"));
            name.setFontSmoothingType(FontSmoothingType.GRAY);


            surahName.getChildren().add(name);

            Button button = new Button();
            button.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
            button.setPrefWidth(180);
            button.setPrefHeight(45);
            button.setFont(Font.font("noon",22));
            button.setText("علامة  ۱");
            button.setPadding(new Insets(-20,0, -15,0));

            savepointName.getChildren().add(button);

            VBox numbers = new VBox(7);
            numbers.setAlignment(Pos.CENTER);

            Text number = new Text("صفحة" );
            number.setFont(Font.font("noon",22));
            number.setFill(Paint.valueOf("White"));
            number.setTextAlignment(TextAlignment.CENTER);
            number.setFontSmoothingType(FontSmoothingType.GRAY);
            number.setBoundsType(TextBoundsType.VISUAL);

            numbers.getChildren().add(number);

            number = new Text("۱" );
            number.setFont(Font.font("noon",22));
            number.setFill(Paint.valueOf("White"));
            number.setTextAlignment(TextAlignment.RIGHT);
            number.setFontSmoothingType(FontSmoothingType.GRAY);
            number.setBoundsType(TextBoundsType.VISUAL);

            numbers.getChildren().add(number);

            pageNumber.getChildren().add(numbers);
        }
        int i = 10;
        gridPane.add(surahName, i, 0);
        gridPane.add(savepointName, i + 1, 0);
        gridPane.add(pageNumber, i + 2, 0);

        return gridPane;
    }
    public void saveMenu(ActionEvent ae){
        setScrollMenuAndMenuTitle("حفظ العلامة", savepoint(), 3);
        menuToFront();
        saveButton.setText("حفظ");
        saveButton.toFront();

        horizontalLine2.toFront();

        additionButton.setText("إضافة");
        additionButton.toFront();


        additionTextField.toFront();

        additionText.setText("إضافة علامة جديدة");
        additionText.toFront();
    }
    public void savepointMenu(ActionEvent ae){
        setScrollMenuAndMenuTitle("علامات", savepoint(), 3);
        menuToFront();
        saveButton.setText("إنتقل");
        saveButton.toFront();

        deleteButton.setText("حذف");
        deleteButton.toFront();

        horizontalLine2.toFront();

        additionButton.setText("تأكيد");
        additionButton.toFront();


        additionTextField.toFront();

        additionText.setText("تغيير الأسم");
        additionText.toFront();
    }
    public void surahMenu(ActionEvent ae) throws IOException {
        VBox surahs = new VBox(17);
        for(int i = 0; i < 113; i++){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Fxmls/surah.fxml"));
            AnchorPane surah = loader.load();
            Surah temp = loader.getController();
            temp.setSurahNumber(toArabicNumbers(i + 1));
            surahs.getChildren().add(surah);
        }
        setScrollMenuAndMenuTitle("الإنتقال الى سورة", surahs, 2);
        menuToFront();
    }
    public void pageMenu(ActionEvent ae){
        GridPane gridPane = new GridPane();
        GridPane leftGridPane = new GridPane();
        GridPane rightGridPane = new GridPane();

        VBox leftGridButtons = new VBox(10);
        VBox rightGridButtons = new VBox(10);

        VBox leftGridSurahNames = new VBox(10);
        VBox rightGridSurahNames = new VBox(10);

        gridPane.setHgap(40);
        rightGridPane.setHgap(20);
        leftGridPane.setHgap(20);

        gridPane.getColumnConstraints().add(new ColumnConstraints(250));

        for (int i = 1; i <= 300; i++) {
            Button button = new Button();
            button.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
            button.setPrefWidth(180);
            button.setPrefHeight(40);
            button.setFont(Font.font("Tajwal",16));

            String pageNumber = toArabicNumbers(i * 2);

            button.setText("صفحة " + pageNumber);
            leftGridButtons.getChildren().add(button);

            Text text = new Text("البَقَرَة");
            text.setFont(Font.font("noon",22));
            text.setFill(Paint.valueOf("White"));
            text.setFontSmoothingType(FontSmoothingType.GRAY);

            leftGridSurahNames.getChildren().add(text);
        }

        for (int i = 0; i < 301; i++) {
            Button button = new Button();
            button.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
            button.setPrefWidth(180);
            button.setPrefHeight(40);
            button.setFont(Font.font("Tajwal",16));

            String pageNumber = toArabicNumbers(i * 2 + 1);

            button.setText("صفحة " + pageNumber);
            rightGridButtons.getChildren().add(button);

            Text text = new Text("الفَاتِحَة");
            text.setFont(Font.font("noon",22));
            text.setFill(Paint.valueOf("White"));
            text.setFontSmoothingType(FontSmoothingType.GRAY);

            rightGridSurahNames.getChildren().add(text);
        }
        leftGridPane.add(leftGridButtons, 0,0);
        rightGridPane.add(rightGridButtons, 0,0);

        leftGridPane.add(leftGridSurahNames,1,0);
        rightGridPane.add(rightGridSurahNames,1,0);

        gridPane.add(leftGridPane,0,0);
        gridPane.add(rightGridPane,2,0);

        setScrollMenuAndMenuTitle("الإنتقال الى صفحة", gridPane, 1);

        menuToFront();
        verticalLine.setEndY(50 * 303);

        verticalLine.toFront();

        //hello i am ruining the code by useless comments
    }
    public void juzMenu(ActionEvent ae){
        GridPane gridPane = new GridPane();
        GridPane leftGridPane = new GridPane();
        GridPane rightGridPane = new GridPane();

        VBox leftGridButtons = new VBox(10);
        VBox rightGridButtons = new VBox(10);

        VBox leftGridSurahNames = new VBox(10);
        VBox rightGridSurahNames = new VBox(10);

        gridPane.setHgap(40);
        rightGridPane.setHgap(20);
        leftGridPane.setHgap(20);

        gridPane.getColumnConstraints().add(new ColumnConstraints(250));

        for (int i = 1; i <= 15; i++) {
            Button button = new Button();
            button.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
            button.setPrefWidth(180);
            button.setPrefHeight(40);
            button.setFont(Font.font("Tajwal",16));

            String juzNumber = toArabicNumbers(i*2);

            button.setText("الجزء  " + juzNumber);

            leftGridButtons.getChildren().add(button);

            Text text = new Text("البسملة");
            text.setFont(Font.font("noon",22));
            text.setFill(Paint.valueOf("White"));

            leftGridSurahNames.getChildren().add(text);
        }

        for (int i = 0; i < 15; i++) {
            Button button = new Button();
            button.getStylesheets().add("file:/C:/Users/hp/Documents/Programming%20projects/Java%20Projects/out/production/Java%20Projects/Muslim_Qibla/Css_Files/button.css");
            button.setPrefWidth(180);
            button.setPrefHeight(40);
            button.setFont(Font.font("Tajwal",16));

            String juzNumber = toArabicNumbers(i * 2 + 1);

            button.setText("الجزء  " + juzNumber);
            rightGridButtons.getChildren().add(button);

            Text text = new Text("البسملة");
            text.setFont(Font.font("noon",22));
            text.setFill(Paint.valueOf("White"));
            rightGridSurahNames.getChildren().add(text);
        }
        leftGridPane.add(leftGridButtons, 0,0);
        rightGridPane.add(rightGridButtons, 0,0);

        leftGridPane.add(leftGridSurahNames,1,0);
        rightGridPane.add(rightGridSurahNames,1,0);

        gridPane.add(leftGridPane,0,0);
        gridPane.add(rightGridPane,2,0);

        setScrollMenuAndMenuTitle("الإنتقال الى جزء", gridPane, 1);

        menuToFront();
        verticalLine.setEndY(50 * 15);

        verticalLine.toFront();
        //hello i am ruining the code by useless comments
    }
    //hello i am ruining the code by useless comments
}
