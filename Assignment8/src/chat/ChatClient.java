package chat;

import javax.swing.*;


public class ChatClient extends JFrame implements Runnable {

	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	
	public ChatClient() {
		super("Chat Client");
		this.setSize(ChatClient.WIDTH, ChatClient.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void run() {

	}
	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
	}
}
