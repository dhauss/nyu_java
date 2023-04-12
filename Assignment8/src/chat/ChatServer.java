package chat;


import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class ChatServer extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private TextArea textArea;
	private ArrayList<ClientThread> clientThreads = new ArrayList<>();

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
				textArea.append(
						"\nStarting thread for client " + (clientThreads.size() + 1) + " at " + Instant.now()
				);
				ClientThread newClient = new ClientThread(socket, clientThreads.size() + 1);
				clientThreads.add(newClient);
				newClient.start();
				
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
	
	public class ClientThread extends Thread {
		private Socket socket;
		private int id;
		
		public ClientThread(Socket socket, int id) {
			this.socket = socket;
			this.id = id;
		}
		
		public void run() {
			DataInputStream inputFromClient;
				try {
					inputFromClient = new DataInputStream(socket.getInputStream());
					while(true) {
					    String in = inputFromClient.readUTF();
					    textArea.append("\n" + id + ": " + in);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}


