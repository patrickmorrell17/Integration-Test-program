package com.CptS422;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hamcrest.Matchers;
import org.powermock.api.mockito.PowerMockito;

public class FilterGradesIntegrationTest {
	
	static List<Grade> allGrades;
	
	static Grade grade1;
	
	static Grade grade2;
	
	static Grade grade3;
	
	static Grade grade4;
	
	static Grade grade5;
	
	public static void main(String[] args) throws Exception {
		integrateMenu();
		integrateFilterByValueLessThan();
		integrateFilterByValueGreaterThan();
		integrateFilterByValueEqualTo();
		integrateFilterByCategory();
		integrateFilterByOccurencesScore();
		integrateFilterByOccurencesGrade();
		integrateShowResults();
	}
	
	static void integrateMenu() throws Exception
	{	
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade4, grade5);
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(allGrades, 80)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 80\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 80, null);
		
		assertEquals("Grades fitting the criterion\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(allGrades, 90)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 1, 2, 90\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 90, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade3);
		
		PowerMockito.when(sGradeFilterer.filterByValueEqualTo(allGrades, 82)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317");

		//System.out.print("Test input: 1, 3, 82\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 82, null);
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByCategory(allGrades, 'A')).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 2, A\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'A');
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade3);
		
		PowerMockito.when(sGradeFilterer.filterByCategory(allGrades, 'B')).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n\n");

		//System.out.print("Test input: 2, B\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'B');
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesScore(allGrades, 1)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 3, 1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 1, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesScore(allGrades, 2)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 3, 2\n");
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 2, null);
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesGrade(allGrades, 1)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n"
				+ "Grades fitting the criterion\nScore: 75.0, Grade: C, Class: CptS 315\n"
				+ "Grades fitting the criterion\nScore: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 4, 1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 1, null);
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n"
				+ "Grades fitting the criterion\nScore: 75.0, Grade: C, Class: CptS 315\n"
				+ "Grades fitting the criterion\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesGrade(allGrades, 2)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 4, 2\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 2, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesGrade(allGrades, 3)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 4, 3\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 3, null);
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		System.out.print("\nPassed IntegrateMenu\n\n");
	}
	

	
	static void integrateFilterByValueLessThan() throws Exception
	{	
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;
		
		Collections.addAll(resultGradesToCompare, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 80\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 80, null);
		
		assertEquals("Grades fitting the criterion\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 50\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 50, null);
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 99\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 99, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		System.out.print("\nPassed integrateFilterByValueLessThan\n\n");
	}
	
	static void integrateFilterByValueGreaterThan() throws Exception
	{	
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Grades fitting the criterion\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 1, 2, 90\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 90, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Grades fitting the criterion\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 99\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 99, null);
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 2, 50\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 50, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		System.out.print("\nPassed integrateFilterByValueGreaterThan\n\n");
	}
	
	static void integrateFilterByValueEqualTo() throws Exception
	{	
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 90, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 3, 50\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 50, null);
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 3, 61\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 61, null);
		
		assertEquals("Grades fitting the criterion\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		System.out.print("\nPassed integrateFilterByValueEqualTo\n\n");
	}
	
	static void integrateFilterByCategory() throws Exception
	{
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;

		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 2, A\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'A');
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade3);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n\n");

		//System.out.print("Test input: 2, B\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'B');
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n\n", ret);

		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 2, F\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'F');
		
		assertEquals("Grades fitting the criterion\n\n", ret);

		System.out.print("\nPassed integrateFilterByCategory\n\n");
	}
	
	static void integrateFilterByOccurencesScore() throws Exception
	{
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;

		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 3, 1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 1, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 3, 2\n");
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 2, null);
		
		assertEquals("Grades fitting the criterion\n\n", ret);

		System.out.print("\nPassed integrateFilterByOccurencesScore\n\n");
	}
	
	static void integrateFilterByOccurencesGrade() throws Exception
	{
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;

		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade3, grade4, grade5);

		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 4, 1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 1, null);
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 4, 2\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 2, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 4, 3\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 3, null);
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		System.out.print("\nPassed integrateFilterByOccurencesGrade\n\n");
	}
	
	static void integrateShowResults() throws Exception
	{
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		allGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		FilterGrades GradeFilterer = new FilterGrades();
		
		FilterGrades sGradeFilterer = PowerMockito.spy(GradeFilterer);
		
		String ret;
		
		//System.out.print("Test input: 1, 1, 80\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 80, null);
		
		assertEquals("Grades fitting the criterion\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		//System.out.print("Test input: 1, 2, 90\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 90, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		//System.out.print("Test input: 1, 3, 61\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 61, null);
		
		assertEquals("Grades fitting the criterion\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		//System.out.print("Test input: 2, A\n");

		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'A');
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);

		//System.out.print("Test input: 3, 1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 1, null);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);

		//System.out.print("Test input: 4, 1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 1, null);
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);

		System.out.print("\nPassed integrateShowResults\n\n");
	}
}
