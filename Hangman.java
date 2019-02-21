/**
 *
 * @author Theodore Graham
 * @version 1.0
 * @since -DATE FINISHED-
 * Hangman.java
 *
 * This program allows a user to play Hangman with the computer.
 * --EXPLAIN THE RULES--
 * 
 */
import java.lang.StringBuilder;
import java.lang.Character;
import java.util.Random;
import java.util.Scanner;

public class Hangman
{
 //This is an array of Strings
 static String movieList[] = {"Star Wars: The Last Jedi","The Matrix","Avatar","Schindler's List","Finding Nemo","Shark Tales","The Godfather","Rocky","Zoolander","Goodfellas","Titanic","Donnie Darko","Pineapple Express","Milk","Pulp Fiction",};
 /**
  * Entry point of the program
  * @param args input arguments
  */
 public static void main(String[] args)
 {
    // Randomly select a movie
    Random rand = new Random();
    int random = rand.nextInt(15);
    String movie = movieList[random];

    // User Interface minus scanner
    System.out.println("        WELCOME TO THEO GRAHAM'S");
    System.out.println("             HANGMAN GAME");
    System.out.println("============================================");
    System.out.println("GUESS A LETTER. YOU ARE ALLOWED 7 MISTAKES.");
    System.out.println("YOU MAY GUESS ANY LETTER UPPERCASE OR LOWER.");
    System.out.println("============================================");

    StringBuilder guess = new StringBuilder(movie.length()); //builds string with length of random movie
    char[] guessArray = new char[movie.length()]; //where the movie's name is being stored
    char[] guessArrayUpp = new char[movie.length()]; //where the movies name in all caps is being stored
    char[] hiddenGuessArray = new char[movie.length()]; //where the movie's name which is hidden is being stored
    int kill = 0;
    while (kill < 7) 
    {
      //For loop to create the unhidden answer array
      for (int i=0; i<movie.length(); i++)
      {
        guessArrayUpp[i] = movie.toUpperCase().charAt(i); //movie name copied in all caps
        guessArray[i] = movie.charAt(i); //movie name copied
      }

      //For loop to create a hidden answer array
      for (int i = 0; i<movie.length(); i++)
      {
        char movieChars = movie.charAt(i);
        if (Character.isLetter(movieChars)) //leaves spaces and special characters unhidden
        {
          guess.append("*"); //hides the characters
        }
        else
        {
          guess.append(movieChars); //saves the spaces and special characters
        }
        hiddenGuessArray[i]=guess.charAt(i); //copies string to array
      }


      Scanner sc = new Scanner(System.in); //scanner object
      while (kill < 7)
      {
        char c = sc.next().toUpperCase().charAt(0); //user input in all caps
        for (int i=0; i<movie.length(); i++)
        {
          if (c == guessArrayUpp[i]) //checks to see if user input is in the movie name
          {
            hiddenGuessArray[i] = movie.charAt(i); //unveils letter if user input is correct
          }
        }
        // Displays the current hidden guess and tries
        System.out.println(hiddenGuessArray);
        System.out.println("Tries left: "+(7-kill));
      }
    }
  }
}





























