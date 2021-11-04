package com.CptS422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections4.list.TreeList;

public class Main {
	
	private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	List<Grade> allGrades = null;
    	
    	int selection;
		
		do
		{
			System.out.print("What would you like to do?\n");
			System.out.print("1. Sort Grades.\n");
			System.out.print("2. Filter Grades.\n");
			System.out.print("3. Display Grades.\n");
			System.out.print("4. Average Grades.\n");
			System.out.print("5. Find Specific Grades.\n");
			
			while (!in.hasNextInt())
			{
				in.nextLine();
			}
			
			selection = in.nextInt();
			
		} while (selection < 1 || selection > 5);
		
		switch (selection)
		{
			case 1:
				
				
				break;
			case 2:
				FilterGrades gradeFilterer = new FilterGrades();
				
				gradeFilterer.menu(allGrades);
				
				break;
			case 3:
				
				DisplayGrades gradeDisplayer = new DisplayGrades(allGrades.size());
				
				gradeDisplayer.displayGrades();
				
				break;
			case 4:
				AverageGrades gradeAverager = new AverageGrades((TempAbstractLinkedList) allGrades);
				
				System.out.print(gradeAverager.getAverageGrade());
				
				break;
			case 5:
				
				MinMaxAvgGrades gradeFinder = new MinMaxAvgGrades();
				
				gradeFinder.MinMaxAvgMenu((TreeList<Grade>) allGrades);
				
				break;
		}
    }
}
