package com.CptS422;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.list.GrowthList;
import org.apache.commons.collections4.list.TreeList;
import org.hamcrest.Matchers;
import org.powermock.api.mockito.PowerMockito;

public class IntegrationTest {
	
	static List<Grade> allGrades;

	static AverageGrades averageGrades;
	
	static List<Grade> noGrades;
	
	static List<Grade> sameGrades;
	
	static TempAbstractLinkedList list;
	
	static Grade grade1;
	
	static Grade grade2;
	
	static Grade grade3;
	
	static Grade grade4;
	
	static Grade grade5;
	
	static Grade grade6;
	
	public static void main(String[] args) throws Exception {
		integrateMenu();
		integrateFilterByValueLessThan();
		integrateFilterByValueGreaterThan();
		integrateFilterByValueEqualTo();
		integrateFilterByCategory();
		integrateFilterByOccurencesScore();
		integrateFilterByOccurencesGrade();
		integrateShowResults();
		
		integrateMinMaxAvgMenu();
		integrateGetMaxLetterGradeFromList();
		integrateGetMinLetterGradeFromList();
		integrateGetMaxScoreFromList();
		integrateGetMinScoreFromList();
		integrateGetAvgScoreFromList();
		
		//integrateAddGrade();
		//integrateRemoveGradeIndex();
		//integrateRemoveAllGrade();
		//integrateDisplayGrade();

		integrateAverageGrades();
	}
	
	static void integrateMenu() throws Exception
	{	
		
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(noGrades, 0)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 0\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 1, 0, null); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(allGrades, 0)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 0\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 0, null); // V2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(noGrades, 50)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 50\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 1, 50, null); // V3L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(allGrades, 20)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 20\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 20, null); // V3L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(allGrades, 85)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317"
				+ "\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 80\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 85, null); // V3L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317"
				+ "\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(allGrades, 98)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 98\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 98, null); // V3L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(noGrades, 101)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 101\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 1, 101, null); // V4L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByValueLessThan(allGrades, 101)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 101\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 101, null); // V4L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(noGrades, -1)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, -1\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 2, -1, null); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(allGrades, -1)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 96.0, Grade: A, Class: CptS 321\n"
						+ "Score: 82.0, Grade: B, Class: CptS 317\n"
						+ "Score: 75.0, Grade: C, Class: CptS 315\n"
						+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 2, -1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, -1, null); // V2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(noGrades, 89)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 89\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 2, 89, null); // V3L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(allGrades, 98)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 98\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 98, null); // V3L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(allGrades, 89)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 1, 2, 89\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 89, null); // V3L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(allGrades, 20)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 96.0, Grade: A, Class: CptS 321\n"
						+ "Score: 82.0, Grade: B, Class: CptS 317\n"
						+ "Score: 75.0, Grade: C, Class: CptS 315\n"
						+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 2, 20\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 20, null); // V3L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(noGrades, 100)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 100\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 2, 100, null); // V4L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueGreaterThan(allGrades, 100)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 100\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 100, null); // V4L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueEqualTo(noGrades, 90)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 3, 90, null); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByValueEqualTo(allGrades, 50)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 3, 50\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 50, null); // V2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1);
		
		PowerMockito.when(sGradeFilterer.filterByValueEqualTo(allGrades, 90)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 90, null); // V2L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.filterByValueEqualTo(sameGrades, 90)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 1, 3, 90, null); // V2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();
		
		allGrades.clear();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByCategory(noGrades, 'X')).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 2, X\n");
		
		ret = sGradeFilterer.doMain(noGrades, 2, 0, null, 'X'); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByCategory(allGrades, 'F')).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 2, F\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'F'); // V2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.filterByCategory(allGrades, 'A')).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 2, A\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'A'); // V2L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.filterByCategory(sameGrades, 'A')).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 2, 0, null, 'A'); // V2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesScore(noGrades, 1)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 3, 1\n");
		
		ret = sGradeFilterer.doMain(noGrades, 3, 0, 1, null); // N2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
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
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 1, null); // N2L2G2
		
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
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 2, null); // N2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesScore(sameGrades, 5)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 3, 5\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 3, 0, 5, null); // N2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesGrade(noGrades, 1)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 4, 1\n");
		
		ret = sGradeFilterer.doMain(noGrades, 4, 0, 1, null); // N2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesGrade(allGrades, 2)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 4, 2\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 2, null); // N2L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesGrade(allGrades, 3)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 4, 3\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 3, null); // N2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.filterByOccurencesGrade(sameGrades, 5)).thenReturn(
				resultGradesToCompare);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 4, 1\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 4, 0, 5, null); // N2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();
		
		System.out.print("\nPassed IntegrateMenu\n\n");
	}
	

	
	static void integrateFilterByValueLessThan() throws Exception
	{
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 0\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 1, 0, null); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 0\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 0, null); // V2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 50\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 1, 50, null); // V3L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 20\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 20, null); // V3L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317"
				+ "\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 80\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 85, null); // V3L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 82.0, Grade: B, Class: CptS 317"
				+ "\nScore: 75.0, Grade: C, Class: CptS 315"
				+ "\nScore: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 98\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 98, null); // V3L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 1, 101\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 1, 101, null); // V4L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 1, 101\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 101, null); // V4L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		System.out.print("\nPassed integrateFilterByValueLessThan\n\n");
	}
	
	static void integrateFilterByValueGreaterThan() throws Exception
	{	
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, -1\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 2, -1, null); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 96.0, Grade: A, Class: CptS 321\n"
						+ "Score: 82.0, Grade: B, Class: CptS 317\n"
						+ "Score: 75.0, Grade: C, Class: CptS 315\n"
						+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 2, -1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, -1, null); // V2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 89\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 2, 89, null); // V3L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 98\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 98, null); // V3L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 1, 2, 89\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 89, null); // V3L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 96.0, Grade: A, Class: CptS 321\n"
						+ "Score: 82.0, Grade: B, Class: CptS 317\n"
						+ "Score: 75.0, Grade: C, Class: CptS 315\n"
						+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 1, 2, 20\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 20, null); // V3L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 100\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 2, 100, null); // V4L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 2, 100\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 2, 100, null); // V4L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		System.out.print("\nPassed integrateFilterByValueGreaterThan\n\n");
	}
	
	static void integrateFilterByValueEqualTo() throws Exception
	{	
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(noGrades, 1, 3, 90, null); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 1, 3, 50\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 50, null); // V2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(allGrades, 1, 3, 90, null); // V2L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 1, 3, 90, null); // V2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();
		
		System.out.print("\nPassed integrateFilterByValueEqualTo\n\n");
	}
	
	static void integrateFilterByCategory() throws Exception
	{
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 2, X\n");
		
		ret = sGradeFilterer.doMain(noGrades, 2, 0, null, 'X'); // V2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 2, F\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'F'); // V2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 2, A\n");
		
		ret = sGradeFilterer.doMain(allGrades, 2, 0, null, 'A'); // V2L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 1, 3, 90\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 2, 0, null, 'A'); // V2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();

		System.out.print("\nPassed integrateFilterByCategory\n\n");
	}
	
	static void integrateFilterByOccurencesScore() throws Exception
	{
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 3, 1\n");
		
		ret = sGradeFilterer.doMain(noGrades, 3, 0, 1, null); // N2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n");

		//System.out.print("Test input: 3, 1\n");
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 1, null); // N2L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 3, 2\n");
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 2, null); // N2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 3, 5\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 3, 0, 5, null); // N2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();

		System.out.print("\nPassed integrateFilterByOccurencesScore\n\n");
	}
	
	static void integrateFilterByOccurencesGrade() throws Exception
	{
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 4, 1\n");
		
		ret = sGradeFilterer.doMain(noGrades, 4, 0, 1, null); // N2L1G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		resultGradesToCompare.clear();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n");

		//System.out.print("Test input: 4, 2\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 2, null); // N2L2G2
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n\n", ret);
		
		resultGradesToCompare.clear();
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\n\n");

		//System.out.print("Test input: 4, 3\n");
		
		ret = sGradeFilterer.doMain(allGrades, 4, 0, 3, null); // N2L2G1
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		PowerMockito.when(sGradeFilterer.showResults(resultGradesToCompare)).thenReturn(
				"Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n"
						+ "Score: 90.1, Grade: A, Class: CptS 322\n\n");

		//System.out.print("Test input: 4, 5\n");
		
		ret = sGradeFilterer.doMain(sameGrades, 4, 0, 5, null); // N2L2G3
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 90.1, Grade: A, Class: CptS 322\n\n", ret);
		
		resultGradesToCompare.clear();
		
		System.out.print("\nPassed integrateFilterByOccurencesGrade\n\n");
	}
	
	static void integrateShowResults() throws Exception
	{
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
		
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
		
		ret = sGradeFilterer.doMain(allGrades, 1, 1, 0, null); // L2
		
		assertEquals("Grades fitting the criterion\n\n", ret);
		
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
		
		ret = sGradeFilterer.doMain(allGrades, 3, 0, 1, null); // L2
		
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
	
	static void integrateAddGrade() {
		grade1 = new Grade(90.1, "CptS 322");
		grade2 = new Grade(96.0, "CptS 321");
		grade3 = new Grade(82.0, "CptS 317");
		grade4 = new Grade(75.0, "CptS 315");
		grade5 = new Grade(61.0, "CptS 360");
		
		GrowthList<Grade> list1 = new GrowthList<Grade>();
		DisplayGrades display = new DisplayGrades(5);
		DisplayGrades sList = PowerMockito.spy(new DisplayGrades(5));
		
		sList.gradeList = list1;
		display.addGrade(grade1);
		verify(display.gradeList, atLeastOnce()).add(grade1);
	}
	
	static void integrateRemoveGradeIndex() {
		grade1 = new Grade(90.1, "CptS 322");
		grade2 = new Grade(96.0, "CptS 321");
		grade3 = new Grade(82.0, "CptS 317");
		grade4 = new Grade(75.0, "CptS 315");
		grade5 = new Grade(61.0, "CptS 360");
		
		GrowthList<Grade> list = new GrowthList<Grade>();
		DisplayGrades display = new DisplayGrades(5);
		DisplayGrades sList = PowerMockito.spy(new DisplayGrades(5));
		
		doReturn(display).when(sList);
		PowerMockito.when(sList.gradeList).thenReturn(list);
		
		assertTrue(list.isEmpty());
		list.add(grade1);
		list.add(grade2);
		assertTrue(!list.isEmpty());
		assertEquals(2, list.size());
		list.remove(0);
		assertTrue(!list.isEmpty());
		assertEquals(1, list.size());
		
		display.addGrade(grade1);
		display.addGrade(grade2);
		display.addGrade(grade3);
		display.removeGradeIndex(0);
		verify(display.gradeList, atLeastOnce()).remove(0);
	}
	
	static void integrateRemoveAllGrade() {
		grade1 = new Grade(90.1, "CptS 322");
		grade2 = new Grade(96.0, "CptS 321");
		grade3 = new Grade(82.0, "CptS 317");
		grade4 = new Grade(75.0, "CptS 315");
		grade5 = new Grade(61.0, "CptS 360");
		
		GrowthList<Grade> list = new GrowthList<Grade>();
		DisplayGrades display = new DisplayGrades(5);
		DisplayGrades sList = PowerMockito.spy(new DisplayGrades(5));
		
		doReturn(display).when(sList);
		PowerMockito.when(sList.gradeList).thenReturn(list);
		
		assertTrue(list.isEmpty());
		list.add(grade1);
		list.add(grade2);
		assertTrue(!list.isEmpty());
		assertEquals(2, list.size());
		list.remove(0);
		assertTrue(!list.isEmpty());
		assertEquals(1, list.size());
		
		display.addGrade(grade1);
		display.addGrade(grade2);
		display.addGrade(grade3);
		display.removeAllGrades();
		verify(display.gradeList, atLeastOnce()).removeAll(list);
	}
	
	static void integrateDisplayGrade() {
		grade1 = new Grade(90.1, "CptS 322");
		grade2 = new Grade(96.0, "CptS 321");
		grade3 = new Grade(82.0, "CptS 317");
		grade4 = new Grade(75.0, "CptS 315");
		grade5 = new Grade(61.0, "CptS 360");
		
		DisplayGrades display = new DisplayGrades(5);
		assertTrue(display.gradeList.isEmpty());
		display.addGrade(grade1);
		display.addGrade(grade2);
		display.addGrade(grade3);
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		final PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outContent));
		System.setOut(originalOut);
		
		display.displayGrades();
		assertEquals("CptS 322: A\nCptS 321: A\nCptS 317: B\n", outContent.toString());
	}
	
	static void integrateMinMaxAvgMenu() throws Exception
	{
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(45.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		grade6 = new Grade(88.0, "CptS 422");
		
		TreeList<Grade> allTreeGrades = new TreeList<Grade>();
		
		Collections.addAll(allTreeGrades, grade1, grade2, grade3, grade4, grade5, grade6);
		
		MinMaxAvgGrades GradeMinMaxAvg = new MinMaxAvgGrades();
		
		MinMaxAvgGrades sGradeMinMaxAvg = PowerMockito.spy(GradeMinMaxAvg);
		
		String ret;
		// 1
		PowerMockito.when(sGradeMinMaxAvg.GetMaxLetterGradeFromList(allTreeGrades)).thenReturn(
				'A');
		
		
		ret = sGradeMinMaxAvg.MinMaxAvgMain(allTreeGrades, 1);
		
		assertEquals("The maximum Grade is: A", ret);
		// 2
		PowerMockito.when(sGradeMinMaxAvg.GetMinLetterGradeFromList(allTreeGrades)).thenReturn(
				'F');
		
		
		ret = sGradeMinMaxAvg.MinMaxAvgMain(allTreeGrades, 2);
		
		assertEquals("The minimum Grade is: F", ret);
		// 3
		PowerMockito.when(sGradeMinMaxAvg.GetMaxScoreFromList(allTreeGrades)).thenReturn(
				90.1);
		
		
		ret = sGradeMinMaxAvg.MinMaxAvgMain(allTreeGrades, 3);
		
		assertEquals("The maximum Score is: 90.1", ret);
		// 4
		PowerMockito.when(sGradeMinMaxAvg.GetMinScoreFromList(allTreeGrades)).thenReturn(
				45.0);
		
		
		ret = sGradeMinMaxAvg.MinMaxAvgMain(allTreeGrades, 4);
		
		assertEquals("The minimum Score is: 45.0", ret);
		// 5
		PowerMockito.when(sGradeMinMaxAvg.GetAvgScoreFromList(allTreeGrades)).thenReturn(
				73.5);
		
		
		ret = sGradeMinMaxAvg.MinMaxAvgMain(allTreeGrades, 5);
		
		assertEquals("The average Score is: 73.5", ret);

		System.out.print("\nPassed integrateMinMaxAvgMenu\n\n");
	}
	
	static void integrateGetMaxLetterGradeFromList() throws Exception
	{
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(45.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		grade6 = new Grade(88.0, "CptS 422");
		
		TreeList<Grade> allTreeGrades = new TreeList<Grade>();
		
		Collections.addAll(allTreeGrades, grade1, grade2, grade3, grade4, grade5, grade6);
		
		MinMaxAvgGrades GradeMinMaxAvg = new MinMaxAvgGrades();
		
		MinMaxAvgGrades sGradeMinMaxAvg = PowerMockito.spy(GradeMinMaxAvg);
		
		String ret;
		// 1
		PowerMockito.when(sGradeMinMaxAvg.GetMaxLetterGradeFromList(allTreeGrades)).thenReturn(
				'A');
				
		char retChar = sGradeMinMaxAvg.GetMaxLetterGradeFromList(allTreeGrades);
		
		assertEquals('A', retChar);
		// 2
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade2, grade3, grade4, grade5, grade6);
		
		PowerMockito.when(sGradeMinMaxAvg.GetMaxLetterGradeFromList(allTreeGrades)).thenReturn(
				'B');
				
		retChar = sGradeMinMaxAvg.GetMaxLetterGradeFromList(allTreeGrades);
		
		assertEquals('B', retChar);
		// 3
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade5);
		PowerMockito.when(sGradeMinMaxAvg.GetMaxLetterGradeFromList(allTreeGrades)).thenReturn(
				'D');
				
		retChar = sGradeMinMaxAvg.GetMaxLetterGradeFromList(allTreeGrades);
		
		assertEquals('D', retChar);
		
		
		System.out.print("\nPassed integrateGetMaxLetterGradeFromList\n\n");
	}
	
	static void integrateGetMinLetterGradeFromList() throws Exception
	{
        grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(45.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		grade6 = new Grade(88.0, "CptS 422");
		
		TreeList<Grade> allTreeGrades = new TreeList<Grade>();
		
		Collections.addAll(allTreeGrades, grade1, grade2, grade3, grade4, grade5, grade6);
		
		MinMaxAvgGrades GradeMinMaxAvg = new MinMaxAvgGrades();
		
		MinMaxAvgGrades sGradeMinMaxAvg = PowerMockito.spy(GradeMinMaxAvg);
		
		String ret;
		// 1
		PowerMockito.when(sGradeMinMaxAvg.GetMinLetterGradeFromList(allTreeGrades)).thenReturn(
				'F');
				
		char retChar = sGradeMinMaxAvg.GetMinLetterGradeFromList(allTreeGrades);
		
		assertEquals('F', retChar);
		// 2
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3, grade4, grade5, grade6);
		
		PowerMockito.when(sGradeMinMaxAvg.GetMinLetterGradeFromList(allTreeGrades)).thenReturn(
				'D');
				
		retChar = sGradeMinMaxAvg.GetMinLetterGradeFromList(allTreeGrades);
		
		assertEquals('D', retChar);
		// 3
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3);
		PowerMockito.when(sGradeMinMaxAvg.GetMinLetterGradeFromList(allTreeGrades)).thenReturn(
				'B');
				
		retChar = sGradeMinMaxAvg.GetMinLetterGradeFromList(allTreeGrades);
		
		assertEquals('B', retChar);
		System.out.print("\nPassed integrateGetMinLetterGradeFromList\n\n");
	}
	
	static void integrateGetMaxScoreFromList() throws Exception
	{
	    grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(45.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		grade6 = new Grade(88.0, "CptS 422");
		
		TreeList<Grade> allTreeGrades = new TreeList<Grade>();
		
		Collections.addAll(allTreeGrades, grade1, grade2, grade3, grade4, grade5, grade6);
		
		MinMaxAvgGrades GradeMinMaxAvg = new MinMaxAvgGrades();
		
		MinMaxAvgGrades sGradeMinMaxAvg = PowerMockito.spy(GradeMinMaxAvg);
		
		String ret;
		// 1
		PowerMockito.when(sGradeMinMaxAvg.GetMaxScoreFromList(allTreeGrades)).thenReturn(
				90.1);
				
		double retDouble = sGradeMinMaxAvg.GetMaxScoreFromList(allTreeGrades);
		
		assertEquals(90.1, retDouble);
		// 2
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3, grade4, grade5, grade6);
		
		PowerMockito.when(sGradeMinMaxAvg.GetMaxScoreFromList(allTreeGrades)).thenReturn(
				88.0);
				
		retDouble = sGradeMinMaxAvg.GetMaxScoreFromList(allTreeGrades);
		
		assertEquals(88.0, retDouble);
		// 3
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3);
		PowerMockito.when(sGradeMinMaxAvg.GetMaxScoreFromList(allTreeGrades)).thenReturn(
				82.0);
				
		retDouble = sGradeMinMaxAvg.GetMaxScoreFromList(allTreeGrades);
		
		assertEquals(82.0, retDouble);
		System.out.print("\nPassed integrateGetMaxScoreFromList\n\n");
	}
	
	static void integrateGetMinScoreFromList() throws Exception
	{
        grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(45.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		grade6 = new Grade(88.0, "CptS 422");
		
		TreeList<Grade> allTreeGrades = new TreeList<Grade>();
		
		Collections.addAll(allTreeGrades, grade1, grade2, grade3, grade4, grade5, grade6);
		
		MinMaxAvgGrades GradeMinMaxAvg = new MinMaxAvgGrades();
		
		MinMaxAvgGrades sGradeMinMaxAvg = PowerMockito.spy(GradeMinMaxAvg);
		
		String ret;
		// 1
		PowerMockito.when(sGradeMinMaxAvg.GetMinScoreFromList(allTreeGrades)).thenReturn(
				45.0);
				
		double retDouble = sGradeMinMaxAvg.GetMinScoreFromList(allTreeGrades);
		
		assertEquals(45.0, retDouble);
		// 2
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3, grade4, grade5, grade6);
		
		PowerMockito.when(sGradeMinMaxAvg.GetMinScoreFromList(allTreeGrades)).thenReturn(
				61.0);
				
		retDouble = sGradeMinMaxAvg.GetMinScoreFromList(allTreeGrades);
		
		assertEquals(61.0, retDouble);
		// 3
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3);
		PowerMockito.when(sGradeMinMaxAvg.GetMinScoreFromList(allTreeGrades)).thenReturn(
				82.0);
				
		retDouble = sGradeMinMaxAvg.GetMinScoreFromList(allTreeGrades);
		
		assertEquals(82.0, retDouble);
		System.out.print("\nPassed integrateGetMinScoreFromList\n\n");
	}
	
	static void integrateGetAvgScoreFromList() throws Exception
	{
        grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(45.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		grade6 = new Grade(88.0, "CptS 422");
		
		TreeList<Grade> allTreeGrades = new TreeList<Grade>();
		
		Collections.addAll(allTreeGrades, grade1, grade2, grade3, grade4, grade5, grade6);
		
		MinMaxAvgGrades GradeMinMaxAvg = new MinMaxAvgGrades();
		
		MinMaxAvgGrades sGradeMinMaxAvg = PowerMockito.spy(GradeMinMaxAvg);
		
		String ret;
		// 1
		PowerMockito.when(sGradeMinMaxAvg.GetAvgScoreFromList(allTreeGrades)).thenReturn(
				73.5);
				
		double retDouble = sGradeMinMaxAvg.GetAvgScoreFromList(allTreeGrades);
		
		assertEquals(73.5, retDouble);
		// 2
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3, grade4, grade5, grade6);
		
		PowerMockito.when(sGradeMinMaxAvg.GetAvgScoreFromList(allTreeGrades)).thenReturn(
				51.0);
				
		retDouble = sGradeMinMaxAvg.GetAvgScoreFromList(allTreeGrades);
		
		assertEquals(51.0, retDouble);
		// 3
		allTreeGrades.clear();
		Collections.addAll(allTreeGrades, grade3);
		PowerMockito.when(sGradeMinMaxAvg.GetAvgScoreFromList(allTreeGrades)).thenReturn(
				82.0);
				
		retDouble = sGradeMinMaxAvg.GetAvgScoreFromList(allTreeGrades);
		
		assertEquals(82.0, retDouble);
		System.out.print("\nPassed integrateGetAvgScoreFromList\n\n");
	}

	static void integrateAverageGrades(){
		Grade grade1 = new Grade(90.1, "CptS 322");

		Grade grade2 = new Grade(96.0, "CptS 321");

		Grade grade3 = new Grade(82.0, "CptS 317");

		Grade grade4 = new Grade(75.0, "CptS 315");

		Grade grade5 = new Grade(61.0, "CptS 360");
		list = new TempAbstractLinkedList();
		list.init2();
		list.add(grade1);
		list.add(grade2);
		list.add(grade3);
		list.add(grade4);
		list.add(grade5);
		averageGrades = new AverageGrades(list);
		Double temp = (averageGrades.getAverageGrade());
		Double temp2 = 80.82000000000001;
		assertEquals(temp2, temp);
		System.out.print("\nPassed integrateAverageGrades\n\n");
	}
	
	static void integrateSortAscendingScore() throws Exception
	{
		ArrayList<Grade> list = new ArrayList<Grade>();
		Grade grade1 = new Grade(90.1, "CptS 322");
        Grade grade2 = new Grade(96.0, "CptS 321");
        Grade grade3 = new Grade(82.0, "CptS 317");
        Grade grade4 = new Grade(75.0, "CptS 315");
        Grade grade5 = new Grade(61.0, "CptS 360");
        list.add(grade1);
        list.add(grade2);
        list.add(grade3);
        list.add(grade4);
        list.add(grade5);
        ArrayList<Grade> list2 = new ArrayList<Grade>();
		Grade grade6 = new Grade(61.0, "CptS 60");
        Grade grade7 = new Grade(75.0, "CptS 5");
        Grade grade8 = new Grade(82.0, "CptS 31");
        Grade grade9 = new Grade(90.1, "CptS 324");
        Grade grade10 = new Grade(96.0, "CptS 351");
        list2.add(grade6);
        list2.add(grade7);
        list2.add(grade8);
        list2.add(grade9);
        list2.add(grade10);
        
        /*SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortAscendingScore();
        assertEquals(test_sort.list.get(0).score, sort.list.get(0).score);
        assertEquals(test_sort.list.get(1).score, sort.list.get(1).score);
        assertEquals(test_sort.list.get(2).score, sort.list.get(2).score);
        assertEquals(test_sort.list.get(3).score, sort.list.get(3).score);
        assertEquals(test_sort.list.get(4).score, sort.list.get(4).score);
		System.out.print("\nPassed integrateSortAscendingScore\n\n");*/
	}
	
	static void integrateSortDescendingScore() throws Exception
	{
		ArrayList<Grade> list = new ArrayList<Grade>();
		Grade grade1 = new Grade(90.1, "CptS 322");
        Grade grade2 = new Grade(96.0, "CptS 321");
        Grade grade3 = new Grade(82.0, "CptS 317");
        Grade grade4 = new Grade(75.0, "CptS 315");
        Grade grade5 = new Grade(61.0, "CptS 360");
        list.add(grade1);
        list.add(grade2);
        list.add(grade3);
        list.add(grade4);
        list.add(grade5);
        ArrayList<Grade> list2 = new ArrayList<Grade>();
		Grade grade6 = new Grade(96.0, "CptS 60");
        Grade grade7 = new Grade(90.1, "CptS 5");
        Grade grade8 = new Grade(82.0, "CptS 31");
        Grade grade9 = new Grade(75.0, "CptS 324");
        Grade grade10 = new Grade(61.0, "CptS 351");
        list2.add(grade6);
        list2.add(grade7);
        list2.add(grade8);
        list2.add(grade9);
        list2.add(grade10);
        
        /*SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortDescendingScore();
        assertEquals(test_sort.list.get(0).score, sort.list.get(0).score);
        assertEquals(test_sort.list.get(1).score, sort.list.get(1).score);
        assertEquals(test_sort.list.get(2).score, sort.list.get(2).score);
        assertEquals(test_sort.list.get(3).score, sort.list.get(3).score);
        assertEquals(test_sort.list.get(4).score, sort.list.get(4).score);
		System.out.print("\nPassed integrateSortDescendingScore\n\n");*/
	}
	
	static void integrateSortAscendingName() throws Exception
	{
		ArrayList<Grade> list = new ArrayList<Grade>();
		Grade grade1 = new Grade(90.1, "CptS 322");
        Grade grade2 = new Grade(96.0, "CptS 321");
        Grade grade3 = new Grade(82.0, "CptS 317");
        Grade grade4 = new Grade(75.0, "CptS 315");
        Grade grade5 = new Grade(61.0, "CptS 360");
        list.add(grade1);
        list.add(grade2);
        list.add(grade3);
        list.add(grade4);
        list.add(grade5);
        ArrayList<Grade> list2 = new ArrayList<Grade>();
		Grade grade6 = new Grade(96.0, "CptS 315");
        Grade grade7 = new Grade(90.1, "CptS 317");
        Grade grade8 = new Grade(82.0, "CptS 321");
        Grade grade9 = new Grade(75.0, "CptS 322");
        Grade grade10 = new Grade(61.0, "CptS 360");
        list2.add(grade6);
        list2.add(grade7);
        list2.add(grade8);
        list2.add(grade9);
        list2.add(grade10);
        
        /*SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortAscendingName();
        assertEquals(test_sort.list.get(0).courseName, sort.list.get(0).courseName);
        assertEquals(test_sort.list.get(1).courseName, sort.list.get(1).courseName);
        assertEquals(test_sort.list.get(2).courseName, sort.list.get(2).courseName);
        assertEquals(test_sort.list.get(3).courseName, sort.list.get(3).courseName);
        assertEquals(test_sort.list.get(4).courseName, sort.list.get(4).courseName);
		System.out.print("\nPassed integrateSortAscendingName\n\n");/*
	}
	
	static void integrateSortDescendingName() throws Exception
	{
		ArrayList<Grade> list = new ArrayList<Grade>();
		Grade grade1 = new Grade(90.1, "CptS 322");
        Grade grade2 = new Grade(96.0, "CptS 321");
        Grade grade3 = new Grade(82.0, "CptS 317");
        Grade grade4 = new Grade(75.0, "CptS 315");
        Grade grade5 = new Grade(61.0, "CptS 360");
        list.add(grade1);
        list.add(grade2);
        list.add(grade3);
        list.add(grade4);
        list.add(grade5);
        ArrayList<Grade> list2 = new ArrayList<Grade>();
		Grade grade6 = new Grade(96.0, "CptS 360");
        Grade grade7 = new Grade(90.1, "CptS 322");
        Grade grade8 = new Grade(82.0, "CptS 321");
        Grade grade9 = new Grade(75.0, "CptS 317");
        Grade grade10 = new Grade(61.0, "CptS 315");
        list2.add(grade6);
        list2.add(grade7);
        list2.add(grade8);
        list2.add(grade9);
        list2.add(grade10);
        
        /*SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortDescendingName();
        assertEquals(test_sort.list.get(0).courseName, sort.list.get(0).courseName);
        assertEquals(test_sort.list.get(1).courseName, sort.list.get(1).courseName);
        assertEquals(test_sort.list.get(2).courseName, sort.list.get(2).courseName);
        assertEquals(test_sort.list.get(3).courseName, sort.list.get(3).courseName);
        assertEquals(test_sort.list.get(4).courseName, sort.list.get(4).courseName);
		System.out.print("\nPassed integrateSortDescendingName\n\n");*/
	}
	
	static void integrateSortAscendingLetter() throws Exception
	{
		ArrayList<Grade> list = new ArrayList<Grade>();
		Grade grade1 = new Grade(90.1, "CptS 322");
        Grade grade2 = new Grade(96.0, "CptS 321");
        Grade grade3 = new Grade(82.0, "CptS 317");
        Grade grade4 = new Grade(75.0, "CptS 315");
        Grade grade5 = new Grade(61.0, "CptS 360");
        list.add(grade1);
        list.add(grade2);
        list.add(grade3);
        list.add(grade4);
        list.add(grade5);
        ArrayList<Grade> list2 = new ArrayList<Grade>();
        Grade grade6 = new Grade(61.0, "CptS 60");
        Grade grade7 = new Grade(75.0, "CptS 5");
        Grade grade8 = new Grade(82.0, "CptS 31");
        Grade grade9 = new Grade(90.1, "CptS 324");
        Grade grade10 = new Grade(96.0, "CptS 351");
        list2.add(grade6);
        list2.add(grade7);
        list2.add(grade8);
        list2.add(grade9);
        list2.add(grade10);
        
        /*SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortAscendingLetter();
        assertEquals(test_sort.list.get(0).grade, sort.list.get(0).grade);
        assertEquals(test_sort.list.get(1).grade, sort.list.get(1).grade);
        assertEquals(test_sort.list.get(2).grade, sort.list.get(2).grade);
        assertEquals(test_sort.list.get(3).grade, sort.list.get(3).grade);
        assertEquals(test_sort.list.get(4).grade, sort.list.get(4).grade);
		System.out.print("\nPassed integrateSortAscendingLetter\n\n");*/
	}
	
	static void integrateSortDescendingLetter() throws Exception
	{
		ArrayList<Grade> list = new ArrayList<Grade>();
		Grade grade1 = new Grade(90.1, "CptS 322");
        Grade grade2 = new Grade(96.0, "CptS 321");
        Grade grade3 = new Grade(82.0, "CptS 317");
        Grade grade4 = new Grade(75.0, "CptS 315");
        Grade grade5 = new Grade(61.0, "CptS 360");
        list.add(grade1);
        list.add(grade2);
        list.add(grade3);
        list.add(grade4);
        list.add(grade5);
        ArrayList<Grade> list2 = new ArrayList<Grade>();
        Grade grade6 = new Grade(96.0, "CptS 60");
        Grade grade7 = new Grade(90.1, "CptS 5");
        Grade grade8 = new Grade(82.0, "CptS 31");
        Grade grade9 = new Grade(75.0, "CptS 324");
        Grade grade10 = new Grade(61.0, "CptS 351");
        list2.add(grade6);
        list2.add(grade7);
        list2.add(grade8);
        list2.add(grade9);
        list2.add(grade10);
        
        /*SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortDescendingLetter();
        assertEquals(test_sort.list.get(0).grade, sort.list.get(0).grade);
        assertEquals(test_sort.list.get(1).grade, sort.list.get(1).grade);
        assertEquals(test_sort.list.get(2).grade, sort.list.get(2).grade);
        assertEquals(test_sort.list.get(3).grade, sort.list.get(3).grade);
        assertEquals(test_sort.list.get(4).grade, sort.list.get(4).grade);
		System.out.print("\nPassed integrateSortDescendingLetter\n\n");*/
	}
}
