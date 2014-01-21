package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatBotController;

public class ChatBotFrame extends JFrame
{
	private ChatBotController baseController;
	private ChatBotPanel basePanel;
	
	/**
	 * This sets up the frame.
	 * @param baseController
	 */
	public ChatBotFrame(ChatBotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatBotPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * This sets the size and visibility of the frame. 
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
}
