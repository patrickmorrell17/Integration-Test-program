package com.CptS422;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortGrades {
	public ArrayList<Grade> list;
	private static Scanner in = new Scanner(System.in);

    public SortGrades(ArrayList<Grade> nList){
        this.list = nList;
    }
      
    
    public void Menu() {
    	int selection;
		
		do
		{
			System.out.print("What would you like to do?\n");
			System.out.print("1. Sort Ascending Grade Scores.\n");
			System.out.print("2. Sort Descending Grade Scores.\n");
			System.out.print("3. Sort Ascending Course Names.\n");
			System.out.print("4. Sort Descending Course Names.\n");
			System.out.print("5. Sort Ascending Letter Grades.\n");
			System.out.print("6. Sort Descending Letter Grades.\n");
			System.out.print("7. Quit.\n");
			
			while (!in.hasNextInt())
			{
				in.nextLine();
			}
			
			selection = in.nextInt();
			
		} while (selection < 1 || selection > 6);
		
		switch (selection)
		{
			case 1:
				//Ascending Grade Scores
				this.sortAscendingScore();
				break;
			case 2:
				//Descending Grade Scores
				this.sortDescendingScore();
				break;
			case 3:
				//Ascending Course Names
				this.sortAscendingName();
				break;
			case 4:
				//Descending Course Names
				this.sortDescendingName();
				break;
			case 5:
				//Ascending Letter Grade
				this.sortAscendingLetter();
				break;
			case 6:
				//Descending Letter Grade
				this.sortDescendingLetter();
				break;
			case 7:
				break;
		}
    }
    
    public ArrayList<Grade> sortAscendingScore() {
    	
    	ArrayList<Double> tempList = new ArrayList<Double>();
		for(int i = 0; i < this.list.size(); i++) {
			tempList.add(this.list.get(i).score);
		}
		Collections.sort(tempList);
		
		ArrayList<Grade> orderedList = new ArrayList<Grade>();
		for(int i = 0; i < tempList.size(); i++) {
			for(int j = 0; j < this.list.size(); j++) {
				if(tempList.get(i) == this.list.get(j).score) {
					Grade tempGrade = new Grade(list.get(j).score, list.get(j).courseName);
					orderedList.add(tempGrade);
					this.list.get(j).score = -1.0;
				}
			}
		}
		this.list = orderedList;
		for(int i = 0; i < orderedList.size(); i++) {
			System.out.println(orderedList.get(i).score);
		}
		return list;
    }
    
    public ArrayList<Grade> sortDescendingScore() {
    	
    	ArrayList<Double> tempList = new ArrayList<Double>();
		for(int i = 0; i < this.list.size(); i++) {
			tempList.add(this.list.get(i).score);
		}
		Collections.sort(tempList);
		
		ArrayList<Grade> orderedList = new ArrayList<Grade>();
		for(int i = 0; i < tempList.size(); i++) {
			for(int j = 0; j < this.list.size(); j++) {
				if(tempList.get(i) == this.list.get(j).score) {
					Grade tempGrade = new Grade(list.get(j).score, list.get(j).courseName);
					orderedList.add(tempGrade);
					this.list.get(j).score = -1.0;
				}
			}
		}
		ArrayList<Grade> revList = new ArrayList<Grade>();
		for(int i = orderedList.size() - 1; i >= 0; i--) {
			revList.add(orderedList.get(i));
		}
		this.list = revList;
		for(int i = 0; i < revList.size(); i++) {
			System.out.println(revList.get(i).score);
		}
		return list;
    }
    
    public ArrayList<Grade> sortAscendingName() {
    	ArrayList<String> tempList = new ArrayList<String>();
		for(int i = 0; i < this.list.size(); i++) {
			tempList.add(this.list.get(i).courseName);
		}
		Collections.sort(tempList);
		
		ArrayList<Grade> orderedList = new ArrayList<Grade>();
		for(int i = 0; i < tempList.size(); i++) {
			for(int j = 0; j < this.list.size(); j++) {
				if(tempList.get(i) == this.list.get(j).courseName) {
					Grade tempGrade = new Grade(list.get(j).score, list.get(j).courseName);
					orderedList.add(tempGrade);
					this.list.get(j).courseName = "";
				}
			}
		}
		this.list = orderedList;
		for(int i = 0; i < orderedList.size(); i++) {
			System.out.println(orderedList.get(i).courseName);
		}
		return list;
    }
    
    public ArrayList<Grade> sortDescendingName() {
    	ArrayList<String> tempList = new ArrayList<String>();
		for(int i = 0; i < this.list.size(); i++) {
			tempList.add(this.list.get(i).courseName);
		}
		Collections.sort(tempList);
		
		ArrayList<Grade> orderedList = new ArrayList<Grade>();
		for(int i = 0; i < tempList.size(); i++) {
			for(int j = 0; j < this.list.size(); j++) {
				if(tempList.get(i) == this.list.get(j).courseName) {
					Grade tempGrade = new Grade(list.get(j).score, list.get(j).courseName);
					orderedList.add(tempGrade);
					this.list.get(j).courseName = "";
				}
			}
		}
		ArrayList<Grade> revList = new ArrayList<Grade>();
		for(int i = orderedList.size() - 1; i >= 0; i--) {
			revList.add(orderedList.get(i));
		}
		this.list = revList;
		for(int i = 0; i < revList.size(); i++) {
			System.out.println(revList.get(i).courseName);
		}
		return list;
    }
    
    public ArrayList<Grade> sortAscendingLetter() {
    	ArrayList<Character> tempList = new ArrayList<Character>();
		for(int i = 0; i < this.list.size(); i++) {
			tempList.add(this.list.get(i).grade);
		}
		Collections.sort(tempList);
		
		ArrayList<Grade> orderedList = new ArrayList<Grade>();
		for(int i = 0; i < tempList.size(); i++) {
			for(int j = 0; j < this.list.size(); j++) {
				if(tempList.get(i) == this.list.get(j).grade) {
					Grade tempGrade = new Grade(list.get(j).score, list.get(j).courseName);
					orderedList.add(tempGrade);
					this.list.get(j).grade = 'Z';
				}
			}
		}
		ArrayList<Grade> revList = new ArrayList<Grade>();
		for(int i = orderedList.size() - 1; i >= 0; i--) {
			revList.add(orderedList.get(i));
		}
		this.list = revList;
		for(int i = 0; i < revList.size(); i++) {
			System.out.println(revList.get(i).grade);
		}
		return list;
    }
    
    public ArrayList<Grade> sortDescendingLetter() {
    	ArrayList<Character> tempList = new ArrayList<Character>();
		for(int i = 0; i < this.list.size(); i++) {
			tempList.add(this.list.get(i).grade);
		}
		Collections.sort(tempList);
		
		ArrayList<Grade> orderedList = new ArrayList<Grade>();
		for(int i = 0; i < tempList.size(); i++) {
			for(int j = 0; j < this.list.size(); j++) {
				if(tempList.get(i) == this.list.get(j).grade) {
					Grade tempGrade = new Grade(list.get(j).score, list.get(j).courseName);
					orderedList.add(tempGrade);
					this.list.get(j).grade = 'Z';
				}
			}
		}
		this.list = orderedList;
		for(int i = 0; i < orderedList.size(); i++) {
			System.out.println(orderedList.get(i).grade);
		}
		return list;
    }
}
