package com.CptS422;

public class Grade {
	
	Double score;
	
	char grade;
	
	String courseName;
	
	public Grade(Double score, String courseName)
	{
		this.score = score;
		
		this.courseName = courseName;
		
		this.calculateLetterGrade();
	}
	
	private void calculateLetterGrade()
	{
		if (this.score < 60)
		{
			this.grade = 'F';
		}
		else if (this.score < 70)
		{
			this.grade = 'D';
		}
		else if (this.score < 80)
		{
			this.grade = 'C';
		}
		else if (this.score < 90)
		{
			this.grade = 'B';
		}
		else
		{
			this.grade = 'A';
		}
	}
}
