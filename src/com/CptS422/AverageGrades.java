package com.CptS422;
import org.apache.commons.collections4.list.*;


public class AverageGrades {

    public TempAbstractLinkedList list;

    public AverageGrades(TempAbstractLinkedList nList){
        this.list = nList;
        //this.populateList();
    }

    public void populateList(){
        Grade grade1 = new Grade(90.1, "CptS 322");

        Grade grade2 = new Grade(96.0, "CptS 321");

        Grade grade3 = new Grade(82.0, "CptS 317");

        Grade grade4 = new Grade(75.0, "CptS 315");

        Grade grade5 = new Grade(61.0, "CptS 360");

        this.list.add(grade1);
        this.list.add(grade2);
        this.list.add(grade3);
        this.list.add(grade4);
        this.list.add(grade5);

    }

    public Double getAverageGrade(){
        Double sum = 0.0;
        Double average = 0.0;
        for(Integer i = 0; i < this.list.size(); ++i){
            Grade grade = (Grade) this.list.get(i);
            sum += grade.score;
        }
        average = sum / this.list.size();
        return average;
    }

}