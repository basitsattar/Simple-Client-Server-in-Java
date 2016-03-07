import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
	
	static ArrayList<Note> list = new ArrayList<Note>();
	
	public static void main(String[] args)
	{
		ServerSocket listener = null;
		try{
			listener = new ServerSocket(7500);
			System.out.println("Server listening at port 7500");
			while(true)
			{
				Socket socket = listener.accept();
				ObjectOutputStream  OutClient = new ObjectOutputStream (socket.getOutputStream());
				ObjectInputStream inClient = new ObjectInputStream(socket.getInputStream());
				Note newRec;
				newRec = (Note)inClient.readObject();

				switch(newRec.operation){
				case 1:
					list.add(newRec);
					System.out.println("Server Got: ");
					System.out.println("User: " + newRec.userName);
					System.out.println("Notes: " + newRec.note);
					break;
				default:
					boolean found = false;
					for(int i = 0; i < list.size();i++)
					{
						if(list.get(i).userName.equals(newRec.userName))
						{	
							found = true;
							OutClient.writeObject(list.get(i));
						}	
					}
					if(!found) {
						System.out.println("user not found!");
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
