package chatbot.view;

import java.awt.event.ActionListener;

import chatbot.model.ChatBot;
import javax.swing.JOptionPane;

public class ChatBotView
{
	private ChatBot myChatBot;

	public ChatBotView()
	{
		myChatBot = new ChatBot();
	}

	public void showApp()
	{
		String answer = "keep going";
		while (answer == null || !answer.equalsIgnoreCase("no"))
		{
			JOptionPane.showMessageDialog(null, myChatBot.getRandomTopic());
			answer = getInput();
			useInput(answer);
		}
		myChatBot.topicConversation();
	}

	private String getInput()
	{
		String userInput = "";

		userInput = JOptionPane.showInputDialog("Say something!");

		return userInput;
	}

	private void useInput(String currentInput)
	{
		JOptionPane.showMessageDialog(null, "Alrighty then!");
		if (myChatBot.memeChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "You like memes, don'tcha?");
		}
		if (myChatBot.dogsChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "So you like dogs?");
		}
		if (myChatBot.celebritiesChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "Ew, I hate them!");
		}
	}
	
}
