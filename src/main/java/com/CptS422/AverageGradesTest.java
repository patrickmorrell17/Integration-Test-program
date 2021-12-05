package com.CptS422;

import org.junit.*;
//import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class AverageGradesTest {
    AverageGrades averageGrades;
    AverageGrades emptyGrades;
    AverageGrades oneGrade;
    TempAbstractLinkedList list;
    TempAbstractLinkedList emptyList;
    TempAbstractLinkedList oneItemList;

    @Before
    public void setUp() {
        this.list = new TempAbstractLinkedList();
        this.emptyList = new TempAbstractLinkedList();
        this.oneItemList = new TempAbstractLinkedList();
        this.populateList();
        this.averageGrades = Mockito.spy(new AverageGrades(this.list));
        this.emptyGrades = Mockito.spy(new AverageGrades(this.emptyList));
        this.oneGrade = Mockito.spy(new AverageGrades(this.oneItemList));
    }

    public void populateList(){
        Grade grade1 = new Grade(90.1, "CptS 322");

        Grade grade2 = new Grade(96.0, "CptS 321");

        Grade grade3 = new Grade(82.0, "CptS 317");

        Grade grade4 = new Grade(75.0, "CptS 315");

        Grade grade5 = new Grade(61.0, "CptS 360");

        this.list.init2();
        this.list.add(grade1);
        this.list.add(grade2);
        this.list.add(grade3);
        this.list.add(grade4);
        this.list.add(grade5);

        this.emptyList.init2();
        this.oneItemList.init2();
        this.oneItemList.add(grade1);

    }

    @Test
    public void testGetAverageGrade(){
        Double temp = (this.averageGrades.getAverageGrade());
        Double temp2 = 80.82000000000001;
        Assert.assertEquals(temp2, temp);
    }

    @Test
    public void testGetAverageGrades2(){
        double temp = this.emptyGrades.getAverageGrade();
        double temp2 = 0.0;
        Assert.assertEquals(temp2, temp, 0.0);
    }

    @Test
    public void testGetAverageGrades3(){
        double temp = this.oneGrade.getAverageGrade();
        double temp2 = 90.1;
        Assert.assertEquals(temp2, temp, 0.1);
    }

}