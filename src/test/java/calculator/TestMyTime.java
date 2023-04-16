package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyTime {
    private MyTime myTime1;
    private MyTime myTime2;
    private MyNumber myNumber;

    @BeforeEach
    public void setUp() {
        myTime1 = new MyTime("2017-12-28 03:00:05 pm +04:00");
        myTime2 = new MyTime("2017-12-01 00:00:00 +00:00");
        myNumber = new MyNumber(3600);
    }

    @Test
    public void testMyTime() {
        assertEquals("2017-12-28T15:00:05+04:00", myTime1.getDate().toString());
        assertEquals("2017-12-01T00:00Z", myTime2.getDate().toString());
    }

    @Test
    public void testAdd() {
        MyTime sum = myTime1.add(myNumber);
        assertEquals("2017-12-28T13:00:05Z", sum.getDate().toString());
    }

    @Test
    public void testToSeconds(){
        assertEquals(1514458805,myTime1.toSeconds());
    }

    @Test
    public void testGetDate(){
        assertEquals("2017-12-28T15:00:05+04:00",myTime1.getDate().toString());
    }

    @Test
    public void testResultToDate(){
        assertEquals("1970-01-01 01:00:00",MyTime.resultToDate(3600));
    }
    @Test
    public void testCountOps() {
        assertEquals(0, myTime1.countOps());
    }

    @Test
    public void testCountNbs() {
        assertEquals(1, myTime1.countNbs());
    }

    @Test
    public void testCountDepth() {
        assertEquals(1, myTime1.countDepth());
    }
}
