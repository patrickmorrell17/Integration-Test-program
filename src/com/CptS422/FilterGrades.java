package com.CptS422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.list.PredicatedList;


// Use unmodifiable list as argument
// Use tree list as argument

public class FilterGrades {
	
    private static Scanner in = new Scanner(System.in);
	
	private static Integer filterValue = 0;
	
	private static Character filterCharacter = 'F';
	
	private static Predicate<Grade> filter;
	
	private static Integer filterAmount = 0;
	
	List <Character> possibleGrades;
	
	public int userSelectionInt()
	{	
		while (!in.hasNextInt())
		{
			in.nextLine();
		}
		
		Integer input = in.nextInt();
		
		return input;
	}
	
	public Character userSelectionCharacter()
	{
		while (!in.hasNext())
		{
			in.nextLine();
		}
		
		return in.next().charAt(0);
	}
	
	public String doMain(List<Grade> listToManipulate, int selection1, int selection2, Integer filterInteger, Character filterGrade)
	{	
		switch (selection1)
		{
			case 1:
				switch (selection2)
				{
					case 1:

						filterValue = filterInteger;
						
						if (filterValue < 0 || filterValue > 100)
						{
							System.out.print("Enter a valid value (valid values are between 0 and 100).\n");
						}
						
						return this.showResults(filterByValueLessThan(listToManipulate, filterValue));
					case 2:
						filterValue = filterInteger;
						
						if (filterValue.doubleValue() < 0 || filterValue.doubleValue() > 100)
						{
							System.out.print("Enter a valid value (valid values are between 0 and 100).\n");
						}
						
						return this.showResults(filterByValueGreaterThan(listToManipulate, filterValue));
					case 3:
						filterValue = filterInteger;
							
						if (filterValue.doubleValue() < 0 || filterValue.doubleValue() > 100)
						{
							System.out.print("Enter a valid value (valid values are between 0 and 100).\n");
						}
							
						return this.showResults(filterByValueEqualTo(listToManipulate, filterValue));
				}
			case 2:
				
				possibleGrades = new ArrayList<Character>();
				
				Collections.addAll(possibleGrades, 'A', 'B', 'C', 'D', 'F');

				filterCharacter = filterGrade;
					
				if (!possibleGrades.contains(filterCharacter))
				{
					System.out.print("Enter a valid grade (valid grades are 'A', 'B', 'C', 'D', 'F').\n");
				}

				return this.showResults(this.filterByCategory(listToManipulate, filterCharacter));
			case 3:
				filterAmount = filterInteger;
					
				if (filterAmount < 0 || filterAmount > listToManipulate.size())
				{
					System.out.print("Enter a valid value (valid values are between 0 and " + listToManipulate.size() + ").\n");
				}
					
				return this.showResults(this.filterByOccurencesScore(listToManipulate, filterAmount));
			case 4:
				filterAmount = filterInteger;
				
				if (filterAmount < 0 || filterAmount > listToManipulate.size())
				{
					System.out.print("Enter a valid value (valid values are between 0 and " + listToManipulate.size() + ").\n");
				}
				
				return this.showResults(this.filterByOccurencesGrade(listToManipulate, filterAmount));
		}
		return null;
	}
	
	public String menu(List<Grade> listToManipulate)
	{
		int selection;
		
		do
		{
			System.out.print("What would you like to do?\n");
			System.out.print("1. Filter by value.\n");
			System.out.print("2. Filter by category.\n");
			System.out.print("3. Filter by number of occurences of score.\n");
			System.out.print("4. Filter by number of occurences of grade.\n");
			
			selection = userSelectionInt();
			
		} while (selection < 1 || selection > 4);
		
		switch (selection)
		{
			case 1:
				do
				{
					System.out.print("What value would you like to filter by?\n");
					System.out.print("1. Scores less than a particular value.\n");
					System.out.print("2. Scores greater than a particular value.\n");
					System.out.print("3. Scores equal to a particular value.\n");
					
					selection = userSelectionInt();
					
				} while (selection < 1 || selection > 3);
				
				switch (selection)
				{
					case 1:
						do
						{
							System.out.print("What value would you like to filter by?\n");
							
							filterValue = userSelectionInt();
							
							if (filterValue < 0 || filterValue > 100)
							{
								System.out.print("Enter a valid value (valid values are between 0 and 100).\n");
							}
							
						} while (filterValue.doubleValue() < 0 || filterValue.doubleValue() > 100);
						
						return this.showResults(filterByValueLessThan(listToManipulate, filterValue));
					case 2:
						do
						{
							System.out.print("What value would you like to filter by?\n");
							
							filterValue = userSelectionInt();
							
							if (filterValue.doubleValue() < 0 || filterValue.doubleValue() > 100)
							{
								System.out.print("Enter a valid value (valid values are between 0 and 100).\n");
							}
							
						} while (filterValue.doubleValue() < 0 || filterValue.doubleValue() > 100);
						
						return this.showResults(filterByValueGreaterThan(listToManipulate, filterValue));
					case 3:
						do
						{
							System.out.print("What value would you like to filter by?\n");
							
							filterValue = userSelectionInt();
							
							if (filterValue.doubleValue() < 0 || filterValue.doubleValue() > 100)
							{
								System.out.print("Enter a valid value (valid values are between 0 and 100).\n");
							}
							
						} while (filterValue.doubleValue() < 0 || filterValue.doubleValue() > 100);
						
						return this.showResults(filterByValueEqualTo(listToManipulate, filterValue));
				}
			case 2:
				
				possibleGrades = new ArrayList<Character>();
				
				Collections.addAll(possibleGrades, 'A', 'B', 'C', 'D', 'F');

				do
				{
					System.out.print("What letter grade would you like to filter by?\n");
					
					filterCharacter = userSelectionCharacter();
					
					if (!possibleGrades.contains(filterCharacter))
					{
						System.out.print("Enter a valid grade (valid grades are 'A', 'B', 'C', 'D', 'F').\n");
					}
				} while (!possibleGrades.contains(filterCharacter));

				return this.showResults(this.filterByCategory(listToManipulate, filterCharacter));
			case 3:
				do
				{
					System.out.print("What amount would you like to filter by?\n");
					
					filterAmount = userSelectionInt();
					
					if (filterAmount < 0 || filterAmount > listToManipulate.size())
					{
						System.out.print("Enter a valid value (valid values are between 0 and " + listToManipulate.size() + ").\n");
					}
					
				} while (filterAmount < 0 || filterAmount > listToManipulate.size());
				
				return this.showResults(this.filterByOccurencesScore(listToManipulate, filterAmount));
			case 4:
				do
				{
					System.out.print("What amount would you like to filter by?\n");
					
					filterAmount = userSelectionInt();
					
					if (filterAmount < 0 || filterAmount > listToManipulate.size())
					{
						System.out.print("Enter a valid value (valid values are between 0 and " + listToManipulate.size() + ").\n");
					}
					
				} while (filterAmount < 0 || filterAmount > listToManipulate.size());
				
				return this.showResults(this.filterByOccurencesGrade(listToManipulate, filterAmount));
		}
		return null;
	}
	
	public List<Grade> filterByValueLessThan(List<Grade> listToManipulate, Integer filterValue)
	{	
		filter = gradeToTest -> (gradeToTest.score < filterValue);
		
		List <Grade> emptyList = new ArrayList<Grade>();

		PredicatedList<Grade> resultList = PredicatedList.predicatedList(emptyList, filter);
		
		for (int i = 0; i < listToManipulate.size(); i ++)
		{
			try
			{
				resultList.add(listToManipulate.get(i));
			}
			catch (Exception e)
			{
				// Found grade that doesn't fit filter
			}
		}
		
		return resultList;
	}
	
	public List<Grade> filterByValueGreaterThan(List<Grade> listToManipulate, Integer filterValue)
	{
		filter = gradeToTest -> (gradeToTest.score.doubleValue() > filterValue.doubleValue());
		
		List <Grade> emptyList = new ArrayList<Grade>();

		PredicatedList<Grade> resultList = PredicatedList.predicatedList(emptyList, filter);
		
		for (int i = 0; i < listToManipulate.size(); i ++)
		{
			try
			{
				resultList.add(listToManipulate.get(i));
			}
			catch (Exception e)
			{
				// Found grade that doesn't fit filter
			}
		}
		
		return resultList;
	}
	
	public List<Grade> filterByValueEqualTo(List<Grade> listToManipulate, Integer filterValue)
	{
		filter = gradeToTest -> (gradeToTest.score.intValue() == filterValue);
		
		List <Grade> emptyList = new ArrayList<Grade>();

		PredicatedList<Grade> resultList = PredicatedList.predicatedList(emptyList, filter);
		
		for (int i = 0; i < listToManipulate.size(); i ++)
		{
			try
			{
				resultList.add(listToManipulate.get(i));
			}
			catch (Exception e)
			{
				// Found grade that doesn't fit filter
			}
		}
		
		return resultList;
	}
	
	public List<Grade> filterByCategory(List<Grade> listToManipulate, char filterCharacter)
	{		
		filter = gradeToTest -> (gradeToTest.grade == filterCharacter);
		
		List <Grade> emptyList = new ArrayList<Grade>();

		PredicatedList<Grade> resultList = PredicatedList.predicatedList(emptyList, filter);
		
		for (int i = 0; i < listToManipulate.size(); i ++)
		{
			try
			{
				resultList.add(listToManipulate.get(i));
			}
			catch (Exception e)
			{
				// Found grade that doesn't fit filter
			}
		}
		
		return resultList;
	}
	
	public List<Grade> filterByOccurencesScore(List<Grade> listToManipulate, Integer filterAmount)
	{
		filter = gradeToTest -> (numOccurences(gradeToTest.score, listToManipulate) == filterAmount);
		
		List <Grade> emptyList = new ArrayList<Grade>();

		PredicatedList<Grade> resultList = PredicatedList.predicatedList(emptyList, filter);
		
		for (int i = 0; i < listToManipulate.size(); i ++)
		{
			try
			{
				resultList.add(listToManipulate.get(i));
			}
			catch (Exception e)
			{
				// Found grade that doesn't fit filter
			}
		}
		
		return resultList;
	}
	
	public List<Grade> filterByOccurencesGrade(List<Grade> listToManipulate, Integer filterAmount)
	{
		filter = gradeToTest -> (numOccurences(gradeToTest.grade, listToManipulate) == filterAmount);
		
		List <Grade> emptyList = new ArrayList<Grade>();

		PredicatedList<Grade> resultList = PredicatedList.predicatedList(emptyList, filter);
		
		for (int i = 0; i < listToManipulate.size(); i ++)
		{
			try
			{
				resultList.add(listToManipulate.get(i));
			}
			catch (Exception e)
			{
				// Found grade that doesn't fit filter
			}
		}
		
		return resultList;
	}
	
	public String showResults(List<Grade> resultList)
	{
		String resultString = "";
		
		String gradeString = "";
		
		resultString = resultString.concat("Grades fitting the criterion\n");
		
		for (Integer i = 0; i < resultList.size(); i++)
		{
			gradeString = gradeString.concat("Score: " + resultList.get(i).score + ", Grade: " + resultList.get(i).grade + ", Class: " + resultList.get(i).courseName);
			
			resultString = resultString.concat(gradeString);
			
			resultString = resultString.concat("\n");
			
			gradeString = "";
		}
		
		resultString = resultString.concat("\n");
		
		return resultString;
	}
	
	public Integer numOccurences(Double scoreToCount, List<Grade> allGrades)
	{
		int scoreCount = 0;
		
		for(int i = 0; i < allGrades.size(); i++)
		{
			if ((allGrades.get(i).score.compareTo(scoreToCount)) == 0)
			{
				scoreCount++;
			}
		}
		
		return scoreCount;
	}
	
	public Integer numOccurences(Character gradeToCount, List<Grade> allGrades)
	{
		int gradeCount = 0;
		
		for(int i = 0; i < allGrades.size(); i++)
		{
			if (allGrades.get(i).grade == gradeToCount)
			{
				gradeCount++;
			}
		}
		
		return gradeCount;
	}
}
