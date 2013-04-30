import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Lab16
{
public static void main(String[] args)
{
String strNewData = "";
try
{
FileInputStream fstream = new FileInputStream("c:\\Album.txt");
// Get the object of DataInputStream
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
String strLine;
int recorditem = 0;

int currentyear=-9999;
while ((strLine = br.readLine()) != null)
{
recorditem++;
if(recorditem == 3)
{
currentyear = Integer.parseInt(strLine);
strNewData = strNewData + strLine + "\r\n";
}
else if(recorditem == 4)
{
if( currentyear == -9999)
{
break;
}
int yearDiff = Calendar.getInstance().get(Calendar.YEAR) - currentyear;
strLine = strLine.replace("$", "");
if( yearDiff > 1 && Calendar.YEAR - currentyear <= 5)
{
strNewData = strNewData+"$" + (Double.parseDouble(strLine) + (Double.parseDouble(strLine)*0.05)) + "\r\n";
}
else if(Calendar.YEAR - currentyear > 5 && Calendar.YEAR - currentyear <= 10)
{
strNewData = strNewData +"$" + (Double.parseDouble(strLine) + (Double.parseDouble(strLine)*0.1)) + "\r\n";
}
else if(Calendar.YEAR - currentyear > 10)
{
strNewData = strNewData + "$" + (Double.parseDouble(strLine) + (Double.parseDouble(strLine)*0.1)) + "\r\n";
}
currentyear = -9999;
recorditem = 0;
}
else
{
strNewData = strNewData + strLine + "\r\n";
}
}
in.close();
//System.out.println (strNewData);
}
catch (Exception e)
{
System.err.println("Error: " + e.getMessage());
}

try
{
BufferedWriter out = new BufferedWriter(new FileWriter("c:\\NewAlbum.txt"));
out.write(""+strNewData);
out.close();
}
catch (Exception e)
{
System.err.println("Error: " + e.getMessage());
}
}
}