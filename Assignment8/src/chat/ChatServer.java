package chat;


import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class ChatServer extends JFrame implements Runnable {

	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private TextArea textArea;
	private ObjectOutputStream outputToBroadcast;
	private DataInputStream inputFromClient;

	
	public ChatServer() {
		super("Chat Server");
		this.setSize(ChatServer.WIDTH, ChatServer.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		textArea = new TextArea(5, 20);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		this.add(scroll);
		this.setVisible(true);
		Instant instant = null;
		ServerSocket serverSocket = null;

	     try {
			serverSocket = new ServerSocket(9898);
			instant = Instant.now();
		    textArea.append("Server started: " + instant);
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
	     while (true) {
	    	 Socket socket;
	         try {
				socket = serverSocket.accept();			    
				inputFromClient = new DataInputStream(socket.getInputStream());

			    String in = inputFromClient.readUTF();
			    System.out.println(in);
			    textArea.append("\n" + in); 
			 } catch (IOException e1) {
				e1.printStackTrace();
			}
	       }
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
	}

	@Override
	public void run() {
		
	}
}


