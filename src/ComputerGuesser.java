import java.util.Random;

public class ComputerGuesser implements IGuesser
{
	private int min;
	private int max;
	private int currentGuess;

	public void yourTurn() {}

	public String getName()
	{
		return "Computer guesser";
	}

	public void newGame(int min, int max, String opponent, String type)
	{
		this.min = min;
		this.max = max;
	}

	public int makeGuess()
	{
		Random rnd = new Random();
		currentGuess = rnd.nextInt(min, max);
		return currentGuess;
	}

	public void guessFeedback(Answer answer)
	{
		switch(answer)
		{
			case TOO_LOW:
				min = currentGuess + 1;
				break;
			case TOO_HIGH:
				max = currentGuess - 1;
				break;
			case CORRECT:
				break;
			default:
				throw new RuntimeException("This should never happen!");
		}
	}

	public boolean endOfGame(int numberOfGuesses, String opponent)
	{
		return true;
	}

}
