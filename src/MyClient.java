import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1 to add new record, 2 to search record");

		int operation = Integer.parseInt(input.nextLine());
		System.out.println("Type username: ");
		String username = input.nextLine();
		Note newRec;
		
		switch(operation){
		case 1:
			
			System.out.println("Type the notes: ");
			String notes = input.nextLine();
			newRec = new Note(username,notes,1);
			break;
		default:
			newRec = new Note(username,"",2);
			
		}
		input.close();
		try
		{	
			Socket sender = new Socket("localhost",7500);
			
			ObjectOutputStream outServer = new ObjectOutputStream(sender.getOutputStream());
			ObjectInputStream inServer = new ObjectInputStream(sender.getInputStream());
			
			outServer.writeObject(newRec);

			if(newRec.operation == 2)
			{
				while(true)
				{
					Note newRec1 = (Note)inServer.readObject();
					System.out.println("User Found: ");
					System.out.println("User Name: "+newRec1.userName);
					System.out.println("Notes : "+ newRec1.note);
				}
			}

			sender.close();   
		}
		catch(Exception e)
		{
			System.out.println("Exception");
			System.out.println(e.getMessage());
		}
	}




}
