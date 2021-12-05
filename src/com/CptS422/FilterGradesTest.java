package com.CptS422;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;

class FilterGradesTest {
	
	List<Grade> allGrades;
	
	List<Grade> noGrades;
	
	List<Grade> sameGrades;
	
	static Grade grade1;
	
	static Grade grade2;
	
	static Grade grade3;
	
	static Grade grade4;
	
	static Grade grade5;
	
	static FilterGrades gradeFilterer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");
		
		gradeFilterer = new FilterGrades();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		allGrades = new ArrayList<Grade>();
		
		sameGrades = new ArrayList<Grade>();
		
		Collections.addAll(allGrades, grade1, grade2, grade3, grade4, grade5);
		
		Collections.addAll(sameGrades, grade1, grade1, grade1, grade1, grade1);
		
		noGrades = new ArrayList<Grade>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFilterByValueLessThan() {
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		List<Grade> resultList = gradeFilterer.filterByValueLessThan(noGrades, 0);
		
		assertEquals(resultGradesToCompare, resultList); // V2L1G1
		
		resultList = gradeFilterer.filterByValueLessThan(noGrades, 50);
		
		assertEquals(resultGradesToCompare, resultList); // V3L1G1
		
		resultList = gradeFilterer.filterByValueLessThan(noGrades, 101);
		
		assertEquals(resultGradesToCompare, resultList); // V4L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByValueLessThan(allGrades, 0);
		
		assertEquals(resultGradesToCompare, resultList); // V2L2G1
		
		Collections.addAll(resultGradesToCompare, grade3, grade4, grade5);
		
		resultList = gradeFilterer.filterByValueLessThan(allGrades, 85);
		
		assertEquals(resultGradesToCompare, resultList); // V3L2G2
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade3, grade4, grade5);
		
		resultList = gradeFilterer.filterByValueLessThan(allGrades, 91);
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		resultList = gradeFilterer.filterByValueLessThan(allGrades, 98);
		
		assertEquals(resultGradesToCompare, resultList); // V3L2G3
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		resultList = gradeFilterer.filterByValueLessThan(allGrades, 101);
		
		assertEquals(resultGradesToCompare, resultList); // V4L2G3
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByValueLessThan(allGrades, 20);
		
		assertEquals(resultGradesToCompare, resultList); // V3L2G1
	}

	@Test
	void testFilterByValueGreaterThan() {
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		List<Grade> resultList = gradeFilterer.filterByValueGreaterThan(noGrades, -1);
		
		assertEquals(resultGradesToCompare, resultList); // V2L1G1
		
		resultList = gradeFilterer.filterByValueGreaterThan(noGrades, 100);
		
		assertEquals(resultGradesToCompare, resultList); // V4L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		resultList = gradeFilterer.filterByValueGreaterThan(allGrades, 89);
		
		assertEquals(resultGradesToCompare, resultList); // V3L2G2
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade2);
		
		resultList = gradeFilterer.filterByValueGreaterThan(allGrades, 95);
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		resultList = gradeFilterer.filterByValueGreaterThan(allGrades, -1);
		
		assertEquals(resultGradesToCompare, resultList); // V2L2G3
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByValueGreaterThan(noGrades, 89);
		
		assertEquals(resultGradesToCompare, resultList); // V3L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		resultList = gradeFilterer.filterByValueGreaterThan(allGrades, 20);
		
		assertEquals(resultGradesToCompare, resultList); // V3L2G3
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByValueGreaterThan(allGrades, 98);
		
		assertEquals(resultGradesToCompare, resultList); // V3L2G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByValueGreaterThan(noGrades, 100);
		
		assertEquals(resultGradesToCompare, resultList); // V4L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByValueGreaterThan(allGrades, 100);
		
		assertEquals(resultGradesToCompare, resultList); // V4L2G1
	}

	@Test
	void testFilterByValueEqualTo() {
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		List<Grade> resultList = gradeFilterer.filterByValueEqualTo(noGrades, 90);
		
		assertEquals(resultGradesToCompare, resultList); // V2L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByValueEqualTo(allGrades, 50);
		
		assertEquals(resultGradesToCompare, resultList); // V2L2G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1);
		
		resultList = gradeFilterer.filterByValueEqualTo(allGrades, 90);
		
		assertEquals(resultGradesToCompare, resultList); // V2L2G2
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade2);
		
		resultList = gradeFilterer.filterByValueEqualTo(allGrades, 96);
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade3);
		
		resultList = gradeFilterer.filterByValueEqualTo(allGrades, 82);
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade4);
		
		resultList = gradeFilterer.filterByValueEqualTo(allGrades, 75);
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade5);
		
		resultList = gradeFilterer.filterByValueEqualTo(allGrades, 61);
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		resultList = gradeFilterer.filterByValueEqualTo(sameGrades, 90);
		
		assertEquals(resultGradesToCompare, resultList); // V2L2G3
	}

	@Test
	void testFilterByCategory() {
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		List<Grade> resultList = gradeFilterer.filterByCategory(noGrades, 'A');
		
		assertEquals(resultGradesToCompare, resultList); // V2L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList = gradeFilterer.filterByCategory(allGrades, 'F');
		
		assertEquals(resultGradesToCompare, resultList); // V2L2G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		resultList = gradeFilterer.filterByCategory(allGrades, 'A');
		
		assertEquals(resultGradesToCompare, resultList); //V2L2G2
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade3);
		
		resultList = gradeFilterer.filterByCategory(allGrades, 'B');
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade4);
		
		resultList = gradeFilterer.filterByCategory(allGrades, 'C');
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade5);
		
		resultList = gradeFilterer.filterByCategory(allGrades, 'D');
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		resultList = gradeFilterer.filterByCategory(sameGrades, 'A');
		
		assertEquals(resultGradesToCompare, resultList); // V2L2G3
	}

	@Test
	void testFilterByOccurencesScore() {
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		List<Grade> resultList = gradeFilterer.filterByOccurencesScore(noGrades, 1);
		
		assertEquals(resultGradesToCompare, resultList); // N2L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		resultList = gradeFilterer.filterByOccurencesScore(allGrades, 1);
		
		assertEquals(resultGradesToCompare, resultList); // N2L2G2
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList.clear();
		
		resultList = gradeFilterer.filterByOccurencesScore(allGrades, 2);
		
		assertEquals(resultGradesToCompare, resultList); // N2L2G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		resultList = gradeFilterer.filterByOccurencesScore(sameGrades, 5);
		
		assertEquals(resultGradesToCompare, resultList); // N2L2G3
	}

	@Test
	void testFilterByOccurencesGrade() {
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		List<Grade> resultList = gradeFilterer.filterByOccurencesGrade(noGrades, 1);
		
		assertEquals(resultGradesToCompare, resultList); // N2L1G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		resultList = gradeFilterer.filterByOccurencesGrade(allGrades, 2);
		
		assertEquals(resultGradesToCompare, resultList); // N2L2G2
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		resultList.clear();
		
		resultList = gradeFilterer.filterByOccurencesGrade(allGrades, 3);
		
		assertEquals(resultGradesToCompare, resultList); // N2L2G1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade3, grade4, grade5);
		
		resultList.clear();
		
		resultList = gradeFilterer.filterByOccurencesGrade(allGrades, 1);
		
		assertEquals(resultGradesToCompare, resultList);
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade1, grade1, grade1, grade1);
		
		resultList = gradeFilterer.filterByOccurencesGrade(sameGrades, 5);
		
		assertEquals(resultGradesToCompare, resultList); // N2L2G3
	}

	@Test
	void testShowResults() {
		
		List<Grade> resultGradesToCompare = new ArrayList<Grade>();
		
		assertEquals("Grades fitting the criterion\n\n", gradeFilterer.showResults(resultGradesToCompare)); // L1
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322"
				+ "\nScore: 96.0, Grade: A, Class: CptS 321\n\n", gradeFilterer.showResults(resultGradesToCompare)); // L2
		
		resultGradesToCompare = new ArrayList<Grade>();
		
		Collections.addAll(resultGradesToCompare, grade1, grade2, grade3, grade4, grade5);
		
		assertEquals("Grades fitting the criterion\nScore: 90.1, Grade: A, Class: CptS 322\n"
				+ "Score: 96.0, Grade: A, Class: CptS 321\n"
				+ "Score: 82.0, Grade: B, Class: CptS 317\n"
				+ "Score: 75.0, Grade: C, Class: CptS 315\n"
				+ "Score: 61.0, Grade: D, Class: CptS 360\n\n", gradeFilterer.showResults(resultGradesToCompare)); // L3
	}

	@Test
	void testNumOccurencesDoubleListOfGrade() {
		assertEquals(0, gradeFilterer.numOccurences(90.1, noGrades)); // V2L2G1
		
		assertEquals(0, gradeFilterer.numOccurences(85.0, allGrades)); // V2L2G1
		
		assertEquals(1, gradeFilterer.numOccurences(61.0, allGrades)); // V2L2G2

		assertEquals(1, gradeFilterer.numOccurences(82.0, allGrades)); // V2L2G2

		assertEquals(1, gradeFilterer.numOccurences(75.0, allGrades)); // V2L2G2
		
		assertEquals(1, gradeFilterer.numOccurences(96.0, allGrades)); // V2L2G2

		assertEquals(0, gradeFilterer.numOccurences(96.5, allGrades)); // V2L2G1

		assertEquals(1, gradeFilterer.numOccurences(90.1, allGrades)); // V2L2G2

		assertEquals(5, gradeFilterer.numOccurences(90.1, sameGrades)); // V2L2G3
	}

	@Test
	void testNumOccurencesCharacterListOfGrade() {
		assertEquals(0, gradeFilterer.numOccurences('A', noGrades)); // V2L1G1
		
		assertEquals(2, gradeFilterer.numOccurences('A', allGrades)); // V2L2G2

		assertEquals(1, gradeFilterer.numOccurences('B', allGrades)); // V2L2G2
		
		assertEquals(1, gradeFilterer.numOccurences('C', allGrades)); // V2L2G2

		assertEquals(1, gradeFilterer.numOccurences('D', allGrades)); // V2L2G2

		assertEquals(0, gradeFilterer.numOccurences('F', allGrades)); // V2L2G1
		
		assertEquals(0, gradeFilterer.numOccurences('P', allGrades)); // V2L2G1

		assertEquals(0, gradeFilterer.numOccurences('E', allGrades)); // V2L2G1

		assertEquals(5, gradeFilterer.numOccurences('A', sameGrades)); // V2L2G3
	}

}
