import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class ScreenCast {
	ServerSocket  server;
	Socket socket;

	public static void main(String[] args) {
		System.out.println("Welcome to Screen Sharer");
		System.out.println("To set up server, type server [port]");
		System.out.println("To Set up client, type client [server-addr] [port]");

		new ScreenShare().interactive();
	}

	/*
	 * Decide if user is host or client
	 */
	private void interactive() {
		Scanner s = new Scanner(System.in);
		
		while (true) {
			InetAddress addr = InetAddress.getByName("localhost");
			System.out.print(addr.getCanonicalHostName() + ">>> ");
			
			String temp = s.nextLine();
		}
	}
	
	/*
	 * Handles client side interactions
	 */
	private void client(String serverAddr, int port) {
		JFrame frame = new JFrame();
		ImagePanel panel = new ImagePanel();
		frame.setResizable(true);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		while (true) {
			socket = new Socket(serverAddr, port);
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			image = ImageIO.read(inputStream);
		}
		
		//TODO fix recieving host screen and re-construct
		
		//TODO client being able to perform actions on hosts screen
	}
	
	/*
	 * Handles Server side interactions
	 */
	private void server(int port) {
		server = new ServerSocket(port);
		
		while(true){
			socket = server.accept();
			InetAddress addr = socket.getInetAddress();
			System.out.println("Received Connection From " + addr.getCanonicalHostName() + " at " + addr.getHostAddress());
			
			
			ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
			BufferedImage img;
			
			
			//TODO fix outputing host screen
			
			//TODO recieve client mouse/keyboard input and execute on hosts screen
			
		}
	}
	
	/*
	 * Helper method for screen capturing
	 */
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
	/*
	 * Closes current conection
	 */
	private void close(){
		socket.close();
		server.close();
	}
	
}
