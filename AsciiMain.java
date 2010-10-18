import java.io.*;
public class AsciiMain 
{
	static String strExist = new String();
    public static void main(String[] args) 
    {
       String str = Bufferreader.TypedInput("File Location: ");
      int[] iArray= new int[256];
      int iIndexCount = 0; 
      
	    try 
	    {
	    	FileInputStream FIS = new FileInputStream(str);
	    	int iValue1 = 0;
	    	while ((iValue1 = FIS.read()) != -1) 
	    	{
	    		if (iValue1 < 0)
	    			iValue1 = iValue1*-1; 
	    		strExist = strExist+iValue1+";";
	    		for (int iChecker =0; iChecker <= iIndexCount; iChecker++)
	    		{
	    			if (iIndexCount == 0)
	    			{
	    				iArray[0] = iValue1;
	    				iIndexCount++;
	    				break;
	    			}
	    			else if (iArray[iChecker] == iValue1)
	    			{
	    				break;
	    			}
	    			else if (iArray[iChecker] != iValue1 && iChecker == iIndexCount)
	    			{
	    				iArray[iIndexCount] = iValue1;
	    				iIndexCount++;
	    				break;
	    			}	
			
	    		}
	    	}
	    	

	    }
	    catch (FileNotFoundException FNFE)
	    {
	    	System.out.println("File Not Found!");
	    }
	    catch (Exception Ex)
	    {
	    	System.out.println("Error exception.");
	    }
	    String strFormat = "Dec Char Freq\n";
	    for(int iCounter = 0; iCounter<iIndexCount; iCounter++)
	    {
	    	strFormat = strFormat+iArray[iCounter]+"  "+strShowValue(iArray[iCounter])+"  " +iSortValue(iArray[iCounter])+"\n";
	    	
	    }
	    System.out.println(strFormat);
	    File x = new File("AsciiMain.java");
	    str = x.getAbsolutePath();
	    str = str.replace("AsciiMain.java", "");
	    try
	    {
	    	FileOutputStream FOS = new FileOutputStream(str+"Haha.txt");
	    	for (char cString: strFormat.toCharArray())
	    	{
	    		if (cString == 10)
	    		{
	    			FOS.write(13);
	    			FOS.write(cString);
	    		}
	    		else 
	    		{
	    			FOS.write(cString);
	    		}
	    	}
	    }
	   	catch (Exception Ex)
	   	{
	   		System.out.println("Error execption.");
	   	}
    }
    static String strShowValue(int iValue1)
    {
    	if (iValue1 == 0)
    		return "NULL";
    	else if (iValue1 == 1)
    		return "SOH";
    	else if (iValue1 == 2)
    		return "STX";
    	else if (iValue1 == 3)
    		return "ETX";
    	else if (iValue1 == 4)
    		return "EOT";
    	else if (iValue1 == 5)
    		return "ENQ";
    	else if (iValue1 == 6)
    		return "ACK";
    	else if (iValue1 == 7)
    		return "BEL";
    	else if (iValue1 == 8)
    		return "BS";
    	else if (iValue1 == 9)
    		return "TAB";
    	else if (iValue1 == 10)
    		return "LF";
    	else if (iValue1 == 11)
    		return "VT";
    	else if (iValue1 == 12)
    		return "FF";
    	else if (iValue1 == 13)
    		return "CR";
    	else if (iValue1 == 14)
    		return "SO";
    	else if (iValue1 == 15)
    		return "SI";
    	else if (iValue1 == 16)
    		return "DLE";
    	else if (iValue1 == 17)
    		return "DC1";
    	else if (iValue1 == 18)
    		return "DC2";
    	else if (iValue1 == 19)
    		return "DC3";
    	else if (iValue1 == 20)
    		return "DC4";
    	else if (iValue1 == 21)
    		return "NAK";
    	else if (iValue1 == 22)
    		return "SYN";
    	else if (iValue1 == 23)
    		return "ETB";
    	else if (iValue1 == 24)
    		return "CAN";
    	else if (iValue1 == 25)
    		return "EM";
    	else if (iValue1 == 26)
    		return "SUB";
    	else if (iValue1 == 27)
    		return "ESC";
    	else if (iValue1 == 28)
    		return "SO";
    	else if (iValue1 == 29)
    		return "GS";
    	else if (iValue1 == 30)
    		return "RS";
    	else if (iValue1 == 31)
    		return "US";
    	else if (iValue1 == 32)
    		return "Space";
    	else 
    	{
    		Character char1 = (char)iValue1;
    		return char1.toString();
    	}
    	
    }
    static int iSortValue(int iValue1)
    {
    	if (iValue1 <= 0)
    		iValue1 = iValue1*-1;
    	
    	int iCount = 0;
    	String strHoldValue = new String();
    	for (int iValue2 = 0; iValue2 < strExist.length(); iValue2++)
    	{
    		if(strExist.charAt(iValue2) != ';')
    		{
    			strHoldValue = strHoldValue+strExist.charAt(iValue2);
    		
    		}
    		else 
    		{
    			if(Integer.parseInt(strHoldValue) == iValue1)
    			{
    				iCount++;
    			}
    			strHoldValue = "";
    		}
    		
    	}
    	return iCount;
    	
    }
}
