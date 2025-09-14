/* 
 Class: CMSC203 CRN 22608
 Program: Assignment #1
 Instructor: Ahmed Tarek
 Summary of Description: This program is made to evaluate the users ESP (extrasensory perception) by making them guess a random color from a 7 colors in 11 total rounds.
 Due Date: 09/09/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Leo Chen
*/

package a1;

import java.util.Random;
import java.util.Scanner;

public class Assignment1 {
	
	public static void main(String[] srgs) {
		Scanner keyboard = new Scanner(System.in);
		Random rnd = new Random();
		String name, description, dueDate, tempColor = "", mNum, inputHolder, colorGuess;
		final String red = "red", orange = "orange", yellow = "yellow", green = "green", blue = "blue", violet = "violet", white = "white";
		int tempNum, roundNum = 1, correct = 0;
		
		System.out.print("Enter your name: ");
		name = keyboard.nextLine();
		System.out.print("What is your MC M number: M");
		mNum = keyboard.nextLine();
		System.out.print("Describe yourself: ");
		description = keyboard.nextLine();
		System.out.print("Due date: ");
		dueDate = keyboard.next();
		System.out.println("");
		
		for (int i = 0; i < 11; i++) {//round iterator
			System.out.println("\nRound " + roundNum);
			tempNum = rnd.nextInt(7) + 1;//randomly picks a number between 1 and 7
			switch (tempNum) {//assigns the the color that corresponds to the number generated
			case 1:
				tempColor = red;
			break;
			case 2:
				tempColor = orange;
			break;
			case 3:
				tempColor = yellow;
			break;
			case 4:
				tempColor = green;
			break;
			case 5:
				tempColor = blue;
			break;
			case 6:
				tempColor = violet;
			break;
			case 7:
				tempColor = white;
			break;
			}
			
			System.out.println("\nI am thinking of a color.");
			System.out.println("Is it red, orange, yellow, green, blue, violet, white?");
			System.out.print("Enter your guess: ");
			inputHolder = keyboard.next();
			colorGuess = inputHolder.toLowerCase();
			//input validation loop
			while (!(colorGuess.equals("red") || colorGuess.equals("orange") || colorGuess.equals("yellow") || colorGuess.equals("green") ||colorGuess.equals("blue") || colorGuess.equals("violet") ||colorGuess.equals("white"))) {
				System.out.println("\nSilly goose thats not one of the options :)");
				System.out.println("Is it red, orange, yellow, green, blue, violet, white?");
				System.out.print("Enter your guess: ");
				inputHolder = keyboard.next();
				colorGuess = inputHolder.toLowerCase();
			}
			
			//checks to see if the color guessed in correct
			if (tempColor.equals(colorGuess))
				correct++;
			
			System.out.println("\nI was thinking " + tempColor);
			
			if (roundNum == 11) {
				System.out.println("\nGame Over\n");
			} else {
				roundNum++;
			}
		}
		
		System.out.println("Your guess " + correct + " out of 11");
		System.out.println("Name: " + name);
		System.out.println("MC M number: M" + mNum);
		System.out.println("Description: " + description);
		System.out.println("Due Date: " + dueDate);
		keyboard.close();
	}
}
