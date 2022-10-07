package com.calculator;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
  public static void main(String[] args) {

  boolean exit = false;

  while(exit == false)
  {
    System.out.print("Enter 'Exit' to exit the program. \nEnter your maths problem here : ");
    Scanner input = new Scanner( System.in);
    String problem = input.next();
    if(problem.equals("Exit") || problem.equals("exit") ) exit = true;
    else if (errorChecking(problem) == true )
      System.out.println("Calculate\n");
    else System.out.println("Do not Calculate\n");
  }

}

public static Boolean errorChecking(String input) {

  boolean checked = false;
  String currentInput = input;
  boolean stringIsValid = true;
  boolean notNumberOrOperator = false;
  boolean doubleOperator = false;
  boolean notFullProblem = false;
  boolean lastItemInStringIsOperator = false;
  boolean fisrtItemInStringIsOperator = false;
  String errorMessage = "";

  // Putting input string into char array
  char[] ch = new char[currentInput.length()];
  for (int i = 0; i < currentInput.length(); i++) {
    ch[i] = currentInput.charAt(i);
  }

  while(checked == false) {
    for(int j = 0; j < currentInput.length() && stringIsValid == true; j++)
    {
      // Check if char is a number from 0-9
      if(ch[j] == '0' || ch[j] == '1' || ch[j] == '2' || ch[j] == '3' || ch[j] == '4'
          || ch[j] == '5' || ch[j] == '6' || ch[j] == '7' || ch[j] == '8' || ch[j] == '9')
      {
        stringIsValid = true;
      }
      // Check if char is '+', '*' or '/'.
      //Then checking if the char before it in array is either '+', '-', '*', or '/'.
      //if it is string isn't valid because duplicate operator
      else if(ch[j] == '+' || ch[j] == '*' || ch[j] == '/')
      {
        if(ch.length == 1)
        {
          stringIsValid = false;
          notFullProblem = true;
        }
        else
        {
          if(j>0)
          {
            if(ch[j-1] == '+' || ch[j-1] == '-' || ch[j-1] == '*' || ch[j-1] == '/' )
            {
              stringIsValid = false;
              doubleOperator = true;
            }
            else stringIsValid = true;
          }
        }


      }
      // Check if char is '-'
      else if(ch[j] == '-')
      {
        if(ch.length == 1) // check if '-' is only char in string
        {
          stringIsValid = false;
          notFullProblem = true;
          fisrtItemInStringIsOperator = true;
        }
        else
        {
          if(j>0)
          {
            if(ch[j-1] == '0' || ch[j-1] == '1' || ch[j-1] == '2' || ch[j-1] == '3' || ch[j-1] == '4'
                || ch[j-1] == '5' || ch[j-1] == '6' || ch[j-1] == '7' || ch[j-1] == '8' || ch[j-1] == '9')// check for number behind '-'
            {
              stringIsValid = true;
            }
            else if(ch[j-1] == '-' && (j-1) == 0) // check for double minus at start
            {
              stringIsValid = false;
              doubleOperator = true;
            }
            else if(ch[j-1] == '+' || ch[j-1] == '-' || ch[j-1] == '*' || ch[j-1] == '/') // check for "ok" operator behind it
            {
              stringIsValid = true;
            }
            else
            {
              stringIsValid = false;
              notNumberOrOperator = true;
            }
          }
          else stringIsValid = true;
        }
      }
      else
      {
        stringIsValid = false;
        notNumberOrOperator = true;
      }
    }
    if(ch[ch.length-1] == '+' || ch[ch.length-1] == '-' || ch[ch.length-1] == '*' || ch[ch.length-1] == '/') // check if last char in string isnt operator
    {
      stringIsValid = false;
      lastItemInStringIsOperator = true;
    }
    if(ch[0] == '+' || ch[0] == '*' || ch[0] == '/') // check if first char in string is operator that isnt minus
    {
      stringIsValid = false;
      fisrtItemInStringIsOperator = true;
    }

    if(stringIsValid == false)
    {
      if(notNumberOrOperator == true) errorMessage = errorMessage + "ERROR: Please only enter numbers and operators. ('+', '-', '*', '/')\n";
      else errorMessage = errorMessage;
      if(doubleOperator == true) errorMessage = errorMessage + "ERROR: Do not duplicate operation character.\n";
      else errorMessage = errorMessage;
      if(fisrtItemInStringIsOperator == true) errorMessage = errorMessage + "ERROR: First item can't be operator unless starting with minus number.\n";
      else errorMessage = errorMessage;
      if(lastItemInStringIsOperator == true) errorMessage = errorMessage + "ERROR: Last item can't be operator.\n";
      else errorMessage = errorMessage;
      if(notFullProblem == true) errorMessage = errorMessage + "ERROR: Please enter a full problem.\n";
      else errorMessage = errorMessage;
      System.out.println(errorMessage);
      return false;
    }
    else System.out.println("Problem is valid\n");
    checked = true;
  }

  return true;
}
}
