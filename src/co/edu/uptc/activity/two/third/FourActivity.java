package co.edu.uptc.activity.two.third;

import java.io.FileInputStream;
import java.io.IOException;

public class FourActivity {
	

	
	    public static void main(String[] args){
	    	
	    	int counter=0;
	    	
	    	try{
	    		FileInputStream read_file= new FileInputStream("src/resources/input/image.jpg");
	    		
	    		boolean finally_file=false;
	    		while(!finally_file) {
	    			int byte_entrance= read_file.read();
	    			
	    			if (byte_entrance==-1)
	    				
	    				finally_file=true;
	    			System.out.println(byte_entrance);
	    			
	    			counter++;
	    			
	    		}
	    		read_file.close();
	    		
	    	}catch(IOException e) {
	    		
	    		
	    	}
	       
	    	System.out.println(counter);
	    	System.out.println("la imagen tiene " + counter+ " numero de bytes");
	    }
}



