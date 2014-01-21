package chatbot.controller;

import java.util.ArrayList;

import chatbot.model.ChatBot;
import chatbot.view.ChatBotFrame;
import chatbot.view.ChatBotView;


public class ChatBotController 
{
	//Declaration Section
	private ChatBot myChatBot;
	private ChatBotFrame appFrame;
	
	/**
	 * This creates myChatBot.
	 */
	public ChatBotController()
	{
		myChatBot= new ChatBot();
	}
	
	/**
	 * This returns myChatBot. 
	 * @return
	 */
	public ChatBot getMyChatBot()
	{
		return myChatBot;
	}
	
	/**
	 * This starts the program. 
	 */
	public void start()
	{
		appFrame = new ChatBotFrame(this);
	}
	
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentConversationPiece = "";
		
		if(currentList.size() > 0)
		{
			currentConversationPiece = currentList.remove(0);		
		}	
		
		return currentConversationPiece;
	
	}
	
	public String processConversation()
	{
		String currentConversation = "";
		currentConversation = conversationHelper(myChatBot.topicConversation());
		return currentConversation;
	}
		
	public String processMeme(String currentInput)
	{
		String memeResponse = "You don't like memes?";
			if(myChatBot.memeChecker(currentInput))
			{
				memeResponse = currentInput + " is a cool meme";
			}
		return memeResponse;		
	}
}
