import java.util.Random;

public class ComputerGuesser implements IGuesser
{
	private int min;
	private int max;
	private int currentGuess;
	private int guessType;

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
		guessType = rnd.nextInt(1,4);
		if(guessType == 1){
			currentGuess = ((max + min)/2);
		} else if(guessType == 2) {
			currentGuess = rnd.nextInt(min, max + 1);
		} else if(guessType == 3){
			int tempMin = ((max + min)/2) - ((max + min)/4);
			if(tempMin < min){
				tempMin = min;
			}
			int tempMax = ((max + min)/2) + ((max + min)/4);
			if(tempMax > max){
				tempMax = max;
			}
			currentGuess = rnd.nextInt(tempMin, tempMax + 1);
		}
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
