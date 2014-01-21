package chatbot;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * A ChatBot model to test String manipulation and use. 
 * @author kell7444
 *
 */
public class ChatBot 
{
	/**
	 * An ArrayList of Strings that holds the memes for the program.
	 */
	private ArrayList<String> myMemes;
	/**
	 * An ArrayList of Strings that holds the different dog statements. 
	 */
	private ArrayList<String> myDogs;
	/**
	 * An ArrayList of Strings that hold the different celebrities for the program. 
	 */
	private ArrayList<String> myCelebrities;
	/**
	 * An ArrayList of Strings that hold random topics.
	 */
	private ArrayList<String> randomList;
		
	public ChatBot()
	{
		myMemes = new ArrayList<String>();
		fillTheList();
		
		myDogs = new ArrayList<String>();
		fillTheDogsList();
		
		myCelebrities = new ArrayList<String>();
		fillTheCelebritiesList();
		
		randomList = new ArrayList<String>();
		fillTheRandomList();
		
	}
	
	/**
	 * Uses a method that tests to see which order your name goes to be in alphabetical order then places them in that order. `
	 * @param first
	 * @param middle
	 * @param last
	 * @return
	 */
	public String alphabetizeYourName(String first, String middle, String last)
	{
		String nameInOrder = "";
		if(first.compareTo(middle) < 0 )
		{
			if(first.compareTo(last) < 0)	
			{
				if(middle.compareTo(last) < 0)
				{
					nameInOrder = first + "," + middle + "," + last;
				}
				else
				{
					nameInOrder = first + "," + last + "," + middle;
				}	
			} 
			else
			{
				nameInOrder = last + "," + first + "," + middle; 
			}
		}
		else
		{
			
			if(middle.compareTo(last) < 0)
			{
				if(first.compareTo(last) < 0)
				{
					nameInOrder = middle + "," + first + "," + last;
				}
				else
				{
					nameInOrder = middle + "," + last + "," + first;
				}
			}
			else
			{
				nameInOrder = last + "," + middle + "," + first;
			}
		}
		return nameInOrder; 
	}

	/**
	 * Fills the randomList with various Strings for the chatbot
	 */
	private void fillTheRandomList()
	{
		randomList.add("I like cheese... ");
		randomList.add("I hate essays... ");
		randomList.add("This is random... ");
		randomList.add("I like to type... ");
	}
	
	/**
	 * This method chooses a random item from the randomList. 
	 * @return A random element from the randomList.
	 */
	public String getRandomTopic()
	{
		String randomTopic = "";
		double myRandom = Math.random();
		int myRandomListPosition = (int)(myRandom * randomList.size());
		randomTopic = randomList.get(myRandomListPosition);
		
		return randomTopic;
	}
	/**
	 * This is a list of memes that can be used. 
	 */
	private void fillTheList()
	{
		myMemes.add("Nicolas Cage");
		myMemes.add("Arrow to the knee");
		myMemes.add("one does not simply");
		myMemes.add("y u no");
	}
	
	/**
	 * This method checks to see if a meme is typed from a meme listed, if it is, then the answer, "You like memes don'tcha?" appears.  
	 * @param currentInput The current phrase typed by the user.
	 * @return The method returns whether or not the input is a meme from the memeList. 
	 */
	public boolean memeChecker(String currentInput)

	{
		boolean hasMeme = false;
		//loop over all the items in the list, if input matches a meme, change hasMeme to true
		
		if(currentInput != null)
		{	
			for(String currentPhrase : myMemes)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
				hasMeme = true;
				}
			}
		}	
		return hasMeme;
	}

	/**
	 * This is the list of possible dog statements. 
	 */
	private void fillTheDogsList()
	{
		myDogs.add("Dogs");
		myDogs.add("I like dogs");
		myDogs.add("Where is my dog?");
		myDogs.add("Dog");
		myDogs.add("Do you like dogs?");
		myDogs.add("Doggies");
		myDogs.add("Puppy");
		myDogs.add("Puppies");
		myDogs.add("I love dogs");
		myDogs.add("I like puppies");
		myDogs.add("I love puppies");
		myDogs.add("Do you have a dog?");
		myDogs.add("Woof");
		myDogs.add("Bow wow");
		myDogs.add("Ruff");
	}
	/**
	 * This method checks if a statement about a dog is present from a list of possible statements, if there is one, then the comment "So you like dogs?" is returned. 
	 * @param currentInput The current phrase typed by the user.
	 * @return The method returns whether or not the input is a dog statement from the dogList
	 */
	public boolean dogsChecker(String currentInput)

	{
		boolean hasDogs = false;
		//loop over all the items in the list, if input matches a meme, change hasMeme to true
		
		if(currentInput != null)
		{	
			for(String currentPhrase : myDogs)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
				hasDogs = true;
				}
			}
		}	
		return hasDogs;
	}
	
	/**
	 * This method asks questions to and provides and answer.
	 */
	public void topicConversation()
	{
		String answer;
		answer = JOptionPane.showInputDialog("Wait, wait, do you like anime?");
		answer = JOptionPane.showInputDialog(answer + ", oh okay, do you like K-Pop?");
		answer = JOptionPane.showInputDialog(answer + ", oh okay, do you like sushi?");
		answer = JOptionPane.showInputDialog(answer + ", oh okay, do you like cute asian things?");
	}
	
	public void fillTheCelebritiesList()
	{
		myCelebrities.add("Brittany Spears");
		myCelebrities.add("Justin Bieber");
		myCelebrities.add("Lady Gaga");
		myCelebrities.add("Kim Kardashian");
		myCelebrities.add("Lana Del Rey");
		myCelebrities.add("Miley Cyrus");
		myCelebrities.add("Jennifer Lawrence");
		myCelebrities.add("Jay-Z");
		myCelebrities.add("Taylor Swift");
		myCelebrities.add("Justin Timberlake");
		myCelebrities.add("Katy Perry");
		myCelebrities.add("Tom Cruise");
		myCelebrities.add("Brad Pitt");
		myCelebrities.add("Rhianna");
		myCelebrities.add("Nicki Minaj");
	}
	/**
	 * This method checks if a celebrity listed is present, if there is, then the statement, "Ew, (answer) is lame!"
	 * @param currentInput The current phrase typed by the user.
	 * @return The method returns whether or not the input is a dog statement from the dogList
	 */
	public boolean celebritiesChecker(String currentInput)

	{
		boolean hasCelebrities = false;
		//loop over all the items in the list, if input matches a meme, change hasMeme to true
		
		if(currentInput != null)
		{	
			for(String currentPhrase : myCelebrities)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
				hasCelebrities = true;
				}
			}
		}	
		return hasCelebrities;
	}
	
}
