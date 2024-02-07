package package1;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TextField textField1;

	@FXML
	TextField textField2;

	@FXML
	Button myButton;

	long low;
	long high;

	public void homeMenu(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void RockPaperScissors(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("RPS.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void GuessNumber(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("GuessNumber.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void rockButton(ActionEvent r) throws IOException {
		Random rm = new Random();
		int computer_choice = rm.nextInt(3);
		Alert alert = new Alert(AlertType.INFORMATION);
		if (computer_choice == 0) {
			System.out.println("Computer Chose Rock!");
			System.out.println("Tie Game!");
			
			alert.setTitle("Computer Chose Rock");
            alert.setContentText("Tie Game!");
            alert.showAndWait();
		} else if (computer_choice == 1) {
			System.out.println("Computer Chose Paper!");
			System.out.println("Computer Wins!");
			
			alert.setTitle("Computer Chose Paper");
            alert.setContentText("Computer Wins!");
            alert.showAndWait();
		} else if (computer_choice == 2) {
			System.out.println("Computer Chose Scissors!");
			System.out.println("Player Wins!");
			
			alert.setTitle("Computer Chose Scissors");
            alert.setContentText("Player Wins");
            alert.showAndWait();
		}
	}

	public void paperButton(ActionEvent p) throws IOException {
		Random rm = new Random();
		int computer_choice = rm.nextInt(3);
		Alert alert = new Alert(AlertType.INFORMATION);
		if (computer_choice == 0) {
			System.out.println("Computer Chose Rock!");
			System.out.println("Player Wins!");
			
			alert.setTitle("Computer Chose Rock");
            alert.setContentText("Player Wins!");
            alert.showAndWait();
		} else if (computer_choice == 1) {
			System.out.println("Computer Chose Paper!");
			System.out.println("Tie Game!");
			
			alert.setTitle("Computer Chose Paper");
            alert.setContentText("Tie Game!");
            alert.showAndWait();
		} else if (computer_choice == 2) {
			System.out.println("Computer Chose Scissors!");
			System.out.println("Computer Wins!");
			
			alert.setTitle("Computer Chose Scissors");
            alert.setContentText("Computer Wins");
            alert.showAndWait();
		}
	}

	public void scissorsButton(ActionEvent event) throws IOException {
		Random rm = new Random();
		int computer_choice = rm.nextInt(3);
		Alert alert = new Alert(AlertType.INFORMATION);
		if (computer_choice == 0) {
			System.out.println("Computer Chose Rock!");
			System.out.println("Computer Wins!");
			
			alert.setTitle("Computer Chose Rock");
            alert.setContentText("Computer Wins");
            alert.showAndWait();
		} else if (computer_choice == 1) {
			System.out.println("Computer Chose Paper!");
			System.out.println("Player Wins!");
			
			alert.setTitle("Computer Chose Paper");
            alert.setContentText("Player Wins!");
            alert.showAndWait();
		} else if (computer_choice == 2) {
			System.out.println("Computer Chose Scissors!");
			System.out.println("Tie Game!");
			
			alert.setTitle("Computer Chose Scissors");
            alert.setContentText("Tie Game!");
            alert.showAndWait();
		}
	}

	long guess;

	@FXML
	Button guessButton;

	@FXML
	TextField textField3;

	long guessedNumber;

	static long[] nums = new long[3];

	public void guessing(ActionEvent event) throws IOException {
		nums = values(low, high, guessedNumber);
		printArray(nums);
//		setValues(low, high, guessedNumber);
		root = FXMLLoader.load(getClass().getResource("SubGuessNumber.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void setValues(long low, long high, long guessedNumber) {
		low = nums[0];
		high = nums[1];
		guessedNumber = nums[2];
	}

	public void printArray(long[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public long[] values(long low, long high, long guessedNumber) {
		Random rm = new Random();
		low = Long.parseLong(textField1.getText());
		high = Long.parseLong(textField2.getText());
		guessedNumber = rm.nextLong(low, high + 1);
		nums[0] = low;
		nums[1] = high;
		nums[2] = guessedNumber;
		return nums;
	}

	public void guessing2(ActionEvent event) throws IOException {
		try {
			long lowNum = nums[0];
			long highNum = nums[1];
			long guessedNum = nums[2];
			// values(low, high, guessedNumber);
			Alert alert = new Alert(AlertType.INFORMATION);
			// System.out.println(guessedNumber);
			guess = Long.parseLong(textField3.getText());
			System.out.println("Guess: " + guess);

//			System.out.println(guessedNumber);
			if (textField3.getText().isEmpty()) {
				// Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Input Not Valid!");
				alert.showAndWait();
			} else {
				int attempts = 0;
				int tries = (int) Math.ceil(Math.log(highNum)) + 1;
				System.out.println("Number of tries: " + tries);
				System.out.println("Guessed Number: " + guessedNum);

				while (attempts < tries) {
				    boolean loop = true;
				    while (loop) {
				        if (guess > guessedNum) {
				            alert.setTitle("Attempt " + (attempts));
				            alert.setContentText("Guess is too high!");
				            alert.showAndWait();
				            loop = false;
				        } else if (guess < guessedNum) {
				            alert.setTitle("Attempt " + (attempts));
				            alert.setContentText("Guess is too low!");
				            alert.showAndWait();
				            loop = false;
				        } else {
				            alert.setTitle("Attempt " + (attempts));
				            alert.setContentText("You guessed the number! It was " + guessedNum + "!");
				            alert.showAndWait();
				            loop = false;
				            // Go Home
				            try {
				            	root = FXMLLoader.load(getClass().getResource("Home.fxml"));
				        		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				        		scene = new Scene(root);
				        		stage.setScene(scene);
				        		stage.show();
				            } catch (IOException e) {
				                e.printStackTrace();
				            }
				        }
				        // Increment attempts for each guess (whether correct or not)
				        attempts += 1;
				    }
				    // Break the outer loop if a guess attempt has been made
				    break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input!");
		}
	}

//	PROTOTYPE
	
//	public static void alert(long guess, long guessedNum, int attempts, int tries) {
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Attempt " + attempts);
//
//		while (true) {
//			switch (attempts) {
//			case 0:
//				if (guess > guessedNum) {
//					alert.setTitle("Attempt " + attempts);
//					alert.setContentText("Guess it too high!");
//					break;
//				} else if (guess < guessedNum) {
//					alert.setTitle("Attempt " + attempts);
//					alert.setContentText("Guess it too low!");
//					break;
//				} else {
//					System.out.println("You guessed the number! It was " + guessedNum + "!");
//					System.out.println("It took " + (attempts + 1) + " attempts!");
//					break; // Exit the loop if the guess is correct.
//				}
//			case 1:
//				if (guess > guessedNum) {
//					alert.setTitle("Attempt " + attempts);
//					alert.setContentText("Guess it too high!");
//					break;
//				} else if (guess < guessedNum) {
//					alert.setTitle("Attempt " + attempts);
//					alert.setContentText("Guess it too low!");
//					break;
//				} else {
//					System.out.println("You guessed the number! It was " + guessedNum + "!");
//					System.out.println("It took " + (attempts + 1) + " attempts!");
//					break; // Exit the loop if the guess is correct.
//				}
//			default:
//
//			}
//		}
//	}

	
//	public void guessNumber(ActionEvent event) throws IOException {
//		Random rm = new Random();
//		try {
//			Alert alert = new Alert(AlertType.ERROR);
//
//			low = Integer.parseInt(textField1.getText());
//			high = Integer.parseInt(textField2.getText());
//			if (low > high) {
//				alert.setContentText("Low Value Should be Less Than High Value!");
//				alert.showAndWait();
//			}
//
//			guessedNumber = rm.nextLong(low, high + 1);
//			System.out.println(guessedNumber);
//
//		} catch (NumberFormatException e) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Input Error");
//			if (low > high) {
//				alert.setContentText("Low Value Should be Less Than High Value!");
//			} else if (textField1.getText().isEmpty() && textField2.getText().isEmpty()) {
//				alert.setContentText("Input Not Valid!");
//			} else if (textField1.getText().isEmpty()) {
//				alert.setContentText("No Low Value Input!");
//			} else if (textField2.getText().isEmpty()) {
//				alert.setContentText("No High Value Input!");
//			}
//			alert.showAndWait();
//		}
//	}
}