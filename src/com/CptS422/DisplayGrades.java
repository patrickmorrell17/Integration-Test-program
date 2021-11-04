package com.CptS422;
import org.apache.commons.collections4.list.*;

public class DisplayGrades {
	public GrowthList<Grade> gradeList;
	
	public DisplayGrades(int size) {
		this.gradeList = new GrowthList<Grade>(size);
	}
	
	public int size() {
		return gradeList.size();
	}
	
	public void addGrade(Grade grade) {
		gradeList.add(grade);
	}
	
	public Grade removeGradeIndex(int index) {
		return gradeList.remove(index);
	}
	
	public void removeAllGrades() {
		gradeList.removeAll(gradeList);
	}
	
	public void displayGrades() {
		int index = 0;
		while (index < gradeList.size()) {
			System.out.println(gradeList.get(index).courseName + ": " + gradeList.get(index).grade);
			index++;
		}
	}
}