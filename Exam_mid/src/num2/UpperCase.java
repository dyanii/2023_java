package num2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpperCase {
	public static void main(String[] args) throws IOException{
		File file1 = new File("obama.txt");
		File file2 = new File("output.txt");
		//char CharCounter = 0;
		BufferedReader in = (new BufferedReader(new FileReader(file1)));
		PrintWriter out = (new PrintWriter(new FileWriter(file2)));
		int ch;
		
		while((ch = in.read()) != -1) {
			ch = Character.toUpperCase(ch);
			System.out.print((char)ch);
			out.write((char)ch);
		}
		
		in.close();
		out.close();
	}
}
