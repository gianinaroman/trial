/**
 * @(#)Bufferreader.java
 *
 *
 * @author 
 * @version 1.00 2010/10/2
 */

import java.io.*;

public class Bufferreader {

    public Bufferreader() {
    }
    
    private static BufferedReader A ()
    { 
    	return new BufferedReader(new InputStreamReader(System.in));
    }
    
    public static String TypedInput(String str)
    {
    	System.out.print(str);
    	try
    	{
    		return Bufferreader.A().readLine();
    	}
    	catch (IOException IOE)
    	{
    		System.err.println("IOException");
    		return null;
    	}
    }
    
}