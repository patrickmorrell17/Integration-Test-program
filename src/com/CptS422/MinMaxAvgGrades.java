package com.CptS422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections4.list.TreeList;


/*
 * TreeList Integration test class
 * --------------------
 * Name     : TreeListTest
 * Data     : 10/31/21
 * Developer: Liam McDonnell (11527766)
 * Purpose  : Build class structure for integration testing on a TreeList.
 */
public class MinMaxAvgGrades {
	
	private static Scanner in = new Scanner(System.in);
	
	public int userSelectionInt()
	{	
		while (!in.hasNextInt())
		{
			in.nextLine();
		}
		
		Integer input = in.nextInt();
		
		return input;
	}
	
	public String MinMaxAvgMain(TreeList<Grade> listToManipulate, int selection)
	{
		switch (selection)
		{
			case 1: 
				return "The maximum Grade is: " + GetMaxLetterGradeFromList(listToManipulate);
			case 2: 
				return "The minimum Grade is: " + GetMinLetterGradeFromList(listToManipulate);
			case 3: 
				return "The maximum Score is: " + String.valueOf(GetMaxScoreFromList(listToManipulate));
			case 4: 
				return "The minimum Score is: " + String.valueOf(GetMinScoreFromList(listToManipulate));
			case 5: 
				return "The average Score is: " + String.valueOf(GetAvgScoreFromList(listToManipulate));
		}
		return null;
	}
	
	public String MinMaxAvgMenu(TreeList<Grade> listToManipulate)
	{
		int selection;
		double returnedDouble;
		do
		{
			System.out.print("What would you like to do?\n");
			System.out.print("1. Get Maximum Grade.\n");
			System.out.print("2. Get Minimum Grade.\n");
			System.out.print("3. Get Maximum Score.\n");
			System.out.print("4. Get Minimum Score.\n");
			System.out.print("5. Get Average Score.\n");
			
			selection = userSelectionInt();
			
		} while (selection < 1 || selection > 5);
		
		switch (selection)
		{
			case 1: 
				return "The maximum Grade is: " + GetMaxLetterGradeFromList(listToManipulate);
			case 2: 
				return "The minimum Grade is: " + GetMinLetterGradeFromList(listToManipulate);
			case 3: 
				return "The maximum Score is: " + String.valueOf(GetMaxScoreFromList(listToManipulate));
			case 4: 
				return "The minimum Score is: " + String.valueOf(GetMinScoreFromList(listToManipulate));
			case 5: 
				return "The average Score is: " + String.valueOf(GetAvgScoreFromList(listToManipulate));
		}
		return null;
	}
		
	// For ascii values, grades coming first in the alphabet are lower integers, so we are looking for the lower integers to get highest grade.
	public char GetMaxLetterGradeFromList(TreeList<Grade> inputGrades)
	{
		char maxGrade = inputGrades.get(0).grade;
		for(int i = 1; i < inputGrades.size(); i++)
		{
			if(maxGrade > inputGrades.get(i).grade)
			{
				maxGrade = inputGrades.get(i).grade;
			}
		}
		return maxGrade;
	}
	// For ascii values, grades coming first in the alphabet are lower integers, so we are looking for the highest integers to get lowest grade.
	public char GetMinLetterGradeFromList(TreeList<Grade> inputGrades)
	{
		char minGrade = inputGrades.get(0).grade;
		for(int i = 1; i < inputGrades.size(); i++)
		{
			if(minGrade < inputGrades.get(i).grade)
			{
				minGrade = inputGrades.get(i).grade;
			}
		}
		return minGrade;
	}
	
	// Find the highest score from all of the grades and return it as a double.
	public double GetMaxScoreFromList(TreeList<Grade> inputGrades)
	{
		double maxScore = inputGrades.get(0).score;
		for(int i = 1; i < inputGrades.size(); i++)
		{
			if(maxScore < inputGrades.get(i).score)
			{
				maxScore = inputGrades.get(i).score;
			}
		}
		return maxScore;
	}
	// Find the lowest score from all of the grades and return it as a double.
	public double GetMinScoreFromList(TreeList<Grade> inputGrades)
	{
		double minScore = inputGrades.get(0).score;
		for(int i = 1; i < inputGrades.size(); i++)
		{
			if(minScore > inputGrades.get(i).score)
			{
				minScore = inputGrades.get(i).score;
			}
		}
		return minScore;
	}
	// Find the average score from all of the grades and return it as a double.
	public double GetAvgScoreFromList(TreeList<Grade> inputGrades)
	{
		double avgRunningSum = 0;
		for(int i = 0; i < inputGrades.size(); i++)
		{
			avgRunningSum += inputGrades.get(i).score;
		}
		return avgRunningSum / inputGrades.size();
	}		
}
