import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Alexander Chamerlaion
 * @Version 1.0
 * @Date 10/12/11
 * This program creates and and evaluates records and put it out to a text file
 */

public class Lab162 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "/Users/dlaxman92/Desktop/Java /Lab16/src/albums.txt";
		int year =0;
		double price = 0;
		Scanner inputStream=null;
		PrintWriter outputStream=null;
		System.out.println("The file: "+fileName+"\ncontains the following");
		String albums = "newalbums.txt";
		try{
			outputStream = new PrintWriter(albums);
		}
		catch(FileNotFoundException e){
			System.out.println("Error opening the file ");
			System.exit(0);
		}
		try{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("Error Opening File: "+fileName);
		}
		while(inputStream.hasNextLine()){
			
			//title
			String line = inputStream.nextLine();
			outputStream.println(line);
			//artist
			line = inputStream.nextLine();
			outputStream.println(line);
			//year
			line = inputStream.nextLine();
			year = Integer.parseInt(line);
			outputStream.println(line);
			//price
			line = inputStream.nextLine();
			price = Double.parseDouble(line.substring(1));
			outputStream.println(price);
			
			
			if(year <=2011-1 && year > 2011 -5){
				System.out.println("No discount this is new");
			}
			else if(year <=2011-5 && year >2011-10){
				System.out.println("5% Discount");	
				price = price-(price*0.05);
			}
			else if (year <= 2011-10){
				System.out.println("10% Discount");
				price = price-(price*0.1);
			}
			
			
		
		}
		inputStream.close();
		outputStream.close();
	}	
}


