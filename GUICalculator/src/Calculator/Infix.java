package Calculator;

import java.util.EmptyStackException;
/**
   A class that evaluates an infix expression.
   Based on pseudocode in Segment 5.21.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @author Jesse Grabowski
   @author Joseph Erickson
   @version 5.0
 */
public class Infix 
{
	public static double evaluateInfix(String infix)
	{
		try		// Attempts to evaluate, rather than assuming syntax is correct
		{
			Double    operandOne, operandTwo, result;
			Character top;
			char      topOperator;
			StackInterface<Character> operatorStack = new OurStack<> ();
			StackInterface<Double>    valueStack    = new OurStack<>();

			int characterCount = infix.length();

			for (int index = 0; index < characterCount; index++)
			{
				char nextCharacter = infix.charAt(index);

				switch(nextCharacter)
				{
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					
					// Save the next character in the Value Stack
					//Add code here 
					break;

				case '(': case '^':
					// Save the next character in the OPerator Stack
					//Add code here 
					break;

				case ')': // Stack is not empty if infix expression is valid
					// Retrieve or get the character in the Value Stack to the top.
					top = operatorStack.pop();
					topOperator = top.charValue();

					while (topOperator != '(')
					{
						operandTwo = valueStack.pop();
						operandOne = valueStack.pop();
						// Compute the result from compute(operandOne, operandTwo, topOperator)
						//Add code here 
						//Add code here - Save result to the Value Stack 
						//Add code here - 
						//Retrieve or get the character in the Value Stack to the top.
					} // end while
					break;

				case '+': case '-': case '*': case '/':
					boolean done = false;
					while (!operatorStack.isEmpty() && !done)
					{
						top = operatorStack.peek();
						topOperator = top.charValue();

						if (precedence(nextCharacter) <= precedence(topOperator) )
						{
							operatorStack.pop();
							operandTwo = valueStack.pop();
							operandOne = valueStack.pop();
							// Compute the result from compute(operandOne, operandTwo, topOperator)
							//Add code here 
							//Add code here - Save result to the Value Stack
						} 
						else
							done = true;
					} // end while

					operatorStack.push(nextCharacter);
					break;

				default: break;  // Ignore unexpected characters
				} // end switch
			} // end for

			while (!operatorStack.isEmpty())
			{
				top = operatorStack.pop();
				topOperator = top.charValue();
				operandTwo = valueStack.pop();
				operandOne = valueStack.pop();
				// Compute the result from compute(operandOne, operandTwo, topOperator)
				//Add code here 
				//Add code here - Save result to the Value Stack
			} // end while

			result = valueStack.peek();
			return result.doubleValue();
		}
		catch (EmptyStackException e)	// If an exception occurs, states
		{								// that the result is not a number
			return Double.NaN;
		}
	} // end evaluateInfix

	private static int precedence(char operator)
	{
		switch (operator)
		{
		case '(': case ')': return 0;
		case '+': case '-': return 1;
		case '*': case '/': return 2;
		case '^': return 3;
		} // end switch

		return -1;
	} // end precedence

	private static double valueOf(char variable)
	{
		switch (variable)
		{
		case '1': return 1.0;
		case '2': return 2.0;
		case '3': return 3.0;
		case '4': return 4.0;
		case '5': return 5.0;
		case '6': return 6.0;
		case '7': return 7.0;
		case '8': return 8.0;
		case '9': return 9.0;
		case '0': return 0.0;
		} // end switch

		return 0;
	} // end valueOf

	private static Double compute(Double operandOne, Double operandTwo, char operator)
	{
		double result;

		switch (operator)
		{
		case '+': 
			result = operandOne.doubleValue() + operandTwo.doubleValue();
			break;

		case '-': 
			result = operandOne.doubleValue() - operandTwo.doubleValue();
			break;

		case '*':
			result = operandOne.doubleValue() * operandTwo.doubleValue();
			break;

		case '/': 
			result = operandOne.doubleValue() / operandTwo.doubleValue();
			break;

		case '^': 
			result = Math.pow(operandOne.doubleValue(), operandTwo.doubleValue());
			break;

		default:    // Unexpected character
			result = 0;
			break;
		} // end switch

		return result;
	} // end compute
} // end Infix

