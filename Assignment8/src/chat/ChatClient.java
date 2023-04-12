package chat;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;


public class ChatClient extends JFrame implements Runnable {
	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private TextArea textArea;
	private Socket socket;
	private DataOutputStream toServer;
	private boolean connected = false;
	private String host = "localhost";


	public ChatClient() {
		super("Chat Client");
		this.setSize(ChatClient.WIDTH, ChatClient.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		textArea = new TextArea(5, 20);
		textArea.addKeyListener(new EnterListener());
		JScrollPane scroll = new JScrollPane(textArea);
		this.add(scroll);
		this.setVisible(true);
	}
	
	public void run() {
		
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem connectItem = new JMenuItem("Connect");
		menu.add(connectItem);
		connectItem.addActionListener(new ConnectListener());
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	private class ConnectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!connected) {
				String IPAddress = null;
				try {
					IPAddress = InetAddress.getLocalHost().toString();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
				String message = String.format(
						"Client's host name is %s\nClient's IP Address is %s",
						host, IPAddress
						);
				try {
					socket = new Socket(host, 9898);
					toServer = new DataOutputStream(socket.getOutputStream());
					toServer.writeUTF(message);
					connected = true;
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private class EnterListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER && connected) {
				textArea.append(" ");	//fixes bug where sending a carriage return alone resends last line of text
				String[] lines = textArea.getText().split("\n");
				String message = lines[lines.length - 1];

				try {
					//socket = new Socket(host, 9898);
					//toServer = new DataOutputStream(socket.getOutputStream());
					toServer.writeUTF(message);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}
	}

	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
	}
}
