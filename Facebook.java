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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Facebook extends Application
{
   private HBox h1 = new HBox();
   private HBox h2 = new HBox();
   private VBox root = new VBox();
   private VBox Vbox2 = new VBox(2);
   private FacebookDB fbDb = new FacebookDB();
   
   //Part 1
   @Override
   public void start(Stage primaryStage)
   {  
   
   fbDb.createDatabase();
   
      //Email label
      Label emailLabel = new Label("Email:");
      emailLabel.setPrefWidth(80);
      //Email TextField
      TextField User = new TextField();
      User.setPromptText("Enter Email: ");
      User.setPrefWidth(125);
      //Password label
      Label passwordLabel = new Label("Password:");
      passwordLabel.setPrefWidth(95);
      //Password passwordField
      PasswordField Password = new PasswordField();
      Password.setPromptText("Enter Password");
      Password.setPrefWidth(100);
      //Login Button 
      Button LoginBtn = new Button("Log In");
      LoginBtn.setPrefWidth(80);
      LoginBtn.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
      //Part 5
      LoginBtn.setOnAction(e -> {
      String email = User.getText();
      String pw = Password.getText();
      String search = fbDb.getUserPasswordFromDatabase(email);
      if(email.length() != 0)
      {
         //IF search return empty string, user does not exist
         if(search.equals(""))
         {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Invalid details entered");
            alert.setContentText("User does not exist in database");
            alert.showAndWait();
         }
         //ELSE IF search does not equal password, password is incorrect
         else if(!search.equals(pw))
         {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Invalid details entered");
            alert.setContentText("Incorrect password entered");
            alert.showAndWait();
         }
         //ELSE IF search equals passowrd, correct detals entered
         else if(search.equals(pw))
         {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("SUCCESS");
            alert.setHeaderText("");
            alert.setContentText("Correct password entered");
            alert.showAndWait();
         }

      }
         });
      
      h1.setAlignment(Pos.CENTER_LEFT);
      h1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));
      h1.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
      h1.getChildren().addAll(emailLabel,User,passwordLabel,Password,LoginBtn);
      root.getChildren().addAll(h1,h2);
      //First name TextField   
      TextField Fname = new TextField();
      Fname.setPrefWidth(126);
      Fname.setPromptText("Enter First Name");
      //Last name TextField
      TextField Lname = new TextField();
      Lname.setPrefWidth(126);
      Lname.setPromptText("Enter Surname");
       //Email TextField for signing up                    
      TextField newEmail = new TextField();
      newEmail.setPrefWidth(126);
      newEmail.setPromptText("Enter Email Address");
      //Password passwordField for signing up
      PasswordField newPassword = new PasswordField();
      newPassword.setPrefWidth(126);
      newPassword.setPromptText("Enter Password");
      //Sign up label
      Label SignupBtnlabel = new Label("Sign Up");
      SignupBtnlabel.setPrefWidth(126);
      SignupBtnlabel.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));
      SignupBtnlabel.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
      SignupBtnlabel.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));             
      //Sign up Button
      Button SignupBtn = new Button("Sign Up");
      SignupBtn.setPrefWidth(126);
      SignupBtn.setFont(Font.font("SanSerif", FontWeight.BOLD, 18));
      SignupBtn.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
      //Part 3
      SignupBtn.setOnAction( e-> {
      String firstName = Fname.getText();
      String lastName = Lname.getText();
      String email = newEmail.getText();
      String password = newPassword.getText();
      
      //Error handling null details entered
      if(firstName.length()==0)
      {
         System.out.println("Error, please enter first name");
      }
      else if(lastName.length()==0)
      {
         System.out.println("Error, please enter last name");
      }
      else if(email.length()==0)
      {
         System.out.println("Error, please enter an email address");
      }
      else if(password.length()==0)
      {
         System.out.println("Error, please enter a password");
      }
      //Creating string to be executed in database
      String sql = "INSERT INTO USER VALUES('"+email+"', '"+password+"', '"+firstName+"', '"+lastName+"') "+"ON DUPLICATE KEY UPDATE " +"password= '"+password+"' , firstname= '"+firstName+"', lastname= '"+lastName+"'";

      //Inserts string to database
      fbDb.insertIntoDatabase(sql);          
      });
      //Creating facebook image object
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