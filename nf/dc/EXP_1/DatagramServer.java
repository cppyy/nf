//Source code java programming Datagram Chat Server
import java.io.*;
import java.net.*;
class DatagramServer
{
	public static DatagramSocket serversocket;
	public static DatagramPacket dp;
	public static BufferedReader dis;
	public static InetAddress ia;
	public static byte buf[] = new byte[1024];
	public static int cport = 1025,sport=5000;
	public static void main(String[] a) throws IOException
	{
		serversocket = new DatagramSocket(sport);
		dp = new DatagramPacket(buf,buf.length);
		dis = new BufferedReader
		(new InputStreamReader(System.in));
		ia = InetAddress.getLocalHost();
		System.out.println("Name:Vishal Yadav, UIN:211P042");
		System.out.println("Server is Running...");
		while(true)
		{
			serversocket.receive(dp);
			String str = new String(dp.getData(), 0,dp.getLength()); // convert to string
			if(str.equals("STOP"))
			{
				System.out.println("Terminated...");
				break;
			}
			System.out.println("Client: " + str);
			String str1 = new String(dis.readLine());
			buf = str1.getBytes();
			serversocket.send(new DatagramPacket(buf,str1.length(), ia, cport));
		}
	}
} 