package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatBotController;
import chatbot.model.ChatBot;
/**
 * These are all the methods or things the panel can do. 
 * @author kell7444
 *
 */
public class ChatBotPanel extends JPanel
{
	private ChatBotController baseController;
	private JButton submitButton;
	private JTextField userInputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	private JScrollPane textPane;
	private ChatBot appBot;
	
	/**
	 * This is the dimension to the frame. 
	 * @param baseController
	 */
	public ChatBotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getMyChatBot();
		
		submitButton = new JButton("Submit this to the ChatBot!");
		userInputField = new JTextField(30);
		
		chatArea = new JTextArea(10,30);
		textPane = new JScrollPane(chatArea);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, textPane, -42, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, userInputField, -42, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 17, SpringLayout.SOUTH, userInputField);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 124, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -97, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userInputField, 17, SpringLayout.SOUTH, textPane);
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		startChat();
	}
	
	/**
	 * Starts chat and gets a random topic
	 */
	private void startChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	} 
	
	/**
	 * This sets up the design of the panel.  
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		
		this.setBackground(Color.YELLOW);

		this.add(submitButton);
		this.add(userInputField);
		this.add(textPane);
		
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	private void setupLayout()
	{
	}
	
	/**
	 * This makes the chatbot interactive when the submit button is clicked.
	 */
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			/**
			 * This is what happens when I click the button
			 */
			public void actionPerformed(ActionEvent click)
			{
				int clickCount = 0;
				clickCount ++;
				String currentInput = userInputField.getText();
				if(clickCount % 7 == 0)
				{
					String currentConversation = baseController.processConversation();
					if(currentConversation.length() != 0)
					{
						chatArea.append(baseController.processConversation());
						clickCount--;
					}
				}
				else if(clickCount % 11 ==0)
				{
					chatArea.append(baseController.processMeme(currentInput));
				}
				else
				{
					chatArea.append("\n" + currentInput);
					chatArea.append("\n" + appBot.getRandomTopic());
				}
					
			}
		});
	}
	
}
