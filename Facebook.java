import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

public class Facebook extends Application
{
   HBox h1 = new HBox();
   HBox h2 = new HBox();
   VBox root = new VBox();
   VBox Vbox2 = new VBox(2);

   public void start(Stage primaryStage)
   {  
      Label emailLabel = new Label("Email:");
      emailLabel.setPrefWidth(80);
      
      TextField User = new TextField();
      User.setPromptText("Enter Email");
      User.setPrefWidth(125);
      
      Label passwordLabel = new Label("Password:");
      passwordLabel.setPrefWidth(95);
      
      PasswordField Password = new PasswordField();
      Password.setPromptText("Enter Password");
      Password.setPrefWidth(100);
        
      Button LoginBtn = new Button("Log In");
      LoginBtn.setPrefWidth(80);
      LoginBtn.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
      
      h1.setAlignment(Pos.CENTER_LEFT);
      h1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));
      h1.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
      h1.getChildren().addAll(emailLabel,User,passwordLabel,Password,LoginBtn);
      root.getChildren().addAll(h1,h2);
         
      TextField Fname = new TextField();
      Fname.setPrefWidth(126);
      Fname.setPromptText("Enter First Name");
      
      TextField Lname = new TextField();
      Lname.setPrefWidth(126);
      Lname.setPromptText("Enter Surname");
                           
      TextField newEmail = new TextField();
      newEmail.setPrefWidth(126);
      newEmail.setPromptText("Enter Email Address");
      
      PasswordField newPassword = new PasswordField();
      newPassword.setPrefWidth(126);
      newPassword.setPromptText("Enter Password");
      
      Label SignupBtnlabel = new Label("Sign Up");
      SignupBtnlabel.setPrefWidth(126);
      SignupBtnlabel.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));
      SignupBtnlabel.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
      SignupBtnlabel.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));             
      
      Button SignupBtn = new Button("Sign Up");
      SignupBtn.setPrefWidth(126);
      SignupBtn.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));
      SignupBtn.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
      
      ImageView fbImage = new ImageView("facebook.png");
      
      Vbox2.getChildren().addAll(SignupBtnlabel,Fname,Lname,newEmail,newPassword,SignupBtn);
      Vbox2.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
      h2.getChildren().addAll(fbImage,Vbox2);
      h2.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
      
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.setTitle("FACEBOOK");
      primaryStage.show();
   }
   
}