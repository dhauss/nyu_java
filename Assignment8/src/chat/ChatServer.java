package chat;


import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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

public class ChatServer extends JFrame {

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
						"\nStarting thread for client " + (clientThreads.size() + 1)
						+ " at " + Instant.now() + "\n"
				);
				ClientThread newClient = new ClientThread(socket, this, clientThreads.size() + 1);
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
	
	public void broadcast(String message, int excludeIndex) {
		for(ClientThread client: clientThreads) {
			if(client != null && client != clientThreads.get(excludeIndex)) {
				client.sendMessage(message);
			}
		}
	}

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
	}
	
	public class ClientThread extends Thread {
		private Socket socket;
		private ChatServer server;
		DataInputStream inputFromClient;
		DataOutputStream toServer;
		private int id;
		
		public ClientThread(Socket socket, ChatServer server, int id) {
			this.socket = socket;
			this.server = server;
			this.id = id;
			try {
				inputFromClient = new DataInputStream(socket.getInputStream());
				toServer = new DataOutputStream(socket.getOutputStream());
			    String in = inputFromClient.readUTF();
			    in = id + ": " + in;
			    synchronized(textArea){
			    	textArea.append(in);
			    }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
				try {
					while(true) {
					    String in = inputFromClient.readUTF();
					    in = id + ": " + in;
					    server.broadcast(in, id - 1);
					}
				} catch (IOException e) {
					try {
						clientThreads.set(id - 1, null);
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
		}
		
		public void sendMessage(String message) {
			try {
				toServer.writeUTF(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


