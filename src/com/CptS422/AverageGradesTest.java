package com.CptS422;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class AverageGradesTest {
    AverageGrades averageGrades;
    TempAbstractLinkedList list;
    @BeforeEach
    public void setUp() {
        this.list = new TempAbstractLinkedList();
        this.populateList();
        this.averageGrades = Mockito.spy(new AverageGrades(this.list));
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

    }

    @Test
    public void testGetAverageGrade(){
        Double temp = (this.averageGrades.getAverageGrade());
        Double temp2 = 80.82000000000001;
        Assert.assertEquals(temp2, temp);
    }

}