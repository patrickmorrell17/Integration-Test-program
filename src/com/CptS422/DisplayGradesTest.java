package com.CptS422;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.collections4.list.GrowthList;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class DisplayGradesTest {
	static Grade grade1;
	static Grade grade2;
	static Grade grade3;
	static Grade grade4;
	static Grade grade5;
	
	static GrowthList<Grade> list;
	static DisplayGrades display;
	public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	public final PrintStream originalOut = System.out;

	@Before
	public void setUp() throws Exception {
		list = new GrowthList<Grade>(5);
		display = new DisplayGrades(5);
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		grade1 = new Grade(90.1, "CptS 322");
		
		grade2 = new Grade(96.0, "CptS 321");
		
		grade3 = new Grade(82.0, "CptS 317");
		
		grade4 = new Grade(75.0, "CptS 315");
		
		grade5 = new Grade(61.0, "CptS 360");

	}
	
	@Test
	public void testAddGrade() {
		assertTrue(display.gradeList.isEmpty());
		display.addGrade(grade1);
		assertTrue(!display.gradeList.isEmpty());
	}
	
	@Test
	public void testRemoveGradeIndex() {
		assertTrue(display.gradeList.isEmpty());
		display.addGrade(grade1);
		display.addGrade(grade2);
		assertEquals(2, display.size());
		display.removeGradeIndex(0);
		assertEquals(1, display.size());
	}
	
	@Test
	public void testRemoveAllGrade() {
		assertTrue(display.gradeList.isEmpty());
		display.addGrade(grade1);
		display.addGrade(grade2);
		assertEquals(2, display.size());
		display.removeAllGrades();
		assertEquals(0, display.size());
		assertTrue(display.gradeList.isEmpty());
	}
	
	@Test
	public void testDisplayGrade() {
		assertTrue(display.gradeList.isEmpty());
		display.addGrade(grade1);
		display.addGrade(grade2);
		display.addGrade(grade3);
		display.displayGrades();
		assertEquals("CptS 322: A\nCptS 321: A\nCptS 317: B\n", outContent.toString());
	}
}
