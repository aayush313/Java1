import java.io.*;
class Temp
{
	public static void main(String args[]) throws Exception
	{
		String str = "AAYUSH"; byte b[]= str.getBytes();
		PipedOutputStream pout = new PipedOutputStream();
		PipedInputStream pin = new PipedInputStream(pout);
		 Thread th = new Thread()
		 {
			 public void run()
			 {
				 for(int i=0; i<b.length;i++)
				 {	
				 	try  
				 	 {
				 		pout.write(b[i]); 
				 		Thread.sleep(1000); } 
				 	catch(Exception ex) {}
				 }
				 
			 }
		 };th.start();
			 Thread th1 = new Thread()
			 {
				 public void run()
				 {		 for (int i=0; i<b.length;i++)
				 		 { 	try 
				 		    {
				 			   int d =pin.read();
					 		   System.out.println((char)d);
				 		       Thread.sleep(1000);}
				 			   catch(Exception ex) {}
				 		 }
				 }
			     
		     };th1.start();
		 
	}
}
