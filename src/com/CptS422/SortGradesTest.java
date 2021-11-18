package com.CptS422;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SortGradesTest {
		
    @Test
    public void testSortAscendingScore(){
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
        
        SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortAscendingScore();
        assertEquals(test_sort.list.get(0).score, sort.list.get(0).score);
        assertEquals(test_sort.list.get(1).score, sort.list.get(1).score);
        assertEquals(test_sort.list.get(2).score, sort.list.get(2).score);
        assertEquals(test_sort.list.get(3).score, sort.list.get(3).score);
        assertEquals(test_sort.list.get(4).score, sort.list.get(4).score);
    }
    
    @Test
    public void testSortDescendingScore(){
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
        
        SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortDescendingScore();
        assertEquals(test_sort.list.get(0).score, sort.list.get(0).score);
        assertEquals(test_sort.list.get(1).score, sort.list.get(1).score);
        assertEquals(test_sort.list.get(2).score, sort.list.get(2).score);
        assertEquals(test_sort.list.get(3).score, sort.list.get(3).score);
        assertEquals(test_sort.list.get(4).score, sort.list.get(4).score);
    }
    
    @Test
    public void testSortAscendingName(){
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
        
        SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortAscendingName();
        assertEquals(test_sort.list.get(0).courseName, sort.list.get(0).courseName);
        assertEquals(test_sort.list.get(1).courseName, sort.list.get(1).courseName);
        assertEquals(test_sort.list.get(2).courseName, sort.list.get(2).courseName);
        assertEquals(test_sort.list.get(3).courseName, sort.list.get(3).courseName);
        assertEquals(test_sort.list.get(4).courseName, sort.list.get(4).courseName);
    }
    
    @Test
    public void testSortDescendingName(){
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
        
        SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortDescendingName();
        assertEquals(test_sort.list.get(0).courseName, sort.list.get(0).courseName);
        assertEquals(test_sort.list.get(1).courseName, sort.list.get(1).courseName);
        assertEquals(test_sort.list.get(2).courseName, sort.list.get(2).courseName);
        assertEquals(test_sort.list.get(3).courseName, sort.list.get(3).courseName);
        assertEquals(test_sort.list.get(4).courseName, sort.list.get(4).courseName);
    }
    
    @Test
    public void testSortAscendingLetter(){
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
        
        SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortAscendingLetter();
        assertEquals(test_sort.list.get(0).grade, sort.list.get(0).grade);
        assertEquals(test_sort.list.get(1).grade, sort.list.get(1).grade);
        assertEquals(test_sort.list.get(2).grade, sort.list.get(2).grade);
        assertEquals(test_sort.list.get(3).grade, sort.list.get(3).grade);
        assertEquals(test_sort.list.get(4).grade, sort.list.get(4).grade);
    }
    
    @Test
    public void testSortDescendingLetter(){
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
        
        SortGrades sort = new SortGrades(list);
        SortGrades test_sort = new SortGrades(list2);
        sort.sortDescendingLetter();
        assertEquals(test_sort.list.get(0).grade, sort.list.get(0).grade);
        assertEquals(test_sort.list.get(1).grade, sort.list.get(1).grade);
        assertEquals(test_sort.list.get(2).grade, sort.list.get(2).grade);
        assertEquals(test_sort.list.get(3).grade, sort.list.get(3).grade);
        assertEquals(test_sort.list.get(4).grade, sort.list.get(4).grade);
    }
}
