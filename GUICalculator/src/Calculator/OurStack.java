package Calculator;
import java.util.Stack;
/**
   A class of stacks.

   @author Frank M. Carrano
   @version 5.0
 */
public class OurStack<T> implements StackInterface<T>
{
	Stack<T> theStack;

	public OurStack()
	{
		theStack = new Stack<>();
	} // end default constructor

	public void push(T newEntry)
	{
		theStack.push(newEntry);
	} // end push

	public T peek()
	{
		return theStack.peek();
	} // end peek

	public T pop()
	{
		return theStack.pop();
	} // end pop

	public boolean isEmpty()
	{
		return theStack.empty();
	} // end isEmpty

	public void clear()
	{
		theStack.clear();	
	} // end clear
} // end OurStack
