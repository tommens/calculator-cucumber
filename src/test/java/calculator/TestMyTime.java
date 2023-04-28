package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visitor.Counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyTime {
    private MyTime myTime1;
    private MyTime myTime2;
    private MyRealNumber myNumber;

    private Counter counter;

    @BeforeEach
    public void setUp() {
        myTime1 = new MyTime("2017-12-28 03:00:05 pm +04:00");
        myTime2 = new MyTime("2017-12-01 00:00:00 +00:00");
        myNumber = new MyRealNumber(String.valueOf(3600));

        counter = new Counter();
        myTime1.accept(counter);
    }

    @Test
    public void testMyTime() {
        assertEquals("2017-12-28T15:00:05+04:00", myTime1.getDate().toString());
        assertEquals("2017-12-01T00:00Z", myTime2.getDate().toString());
    }

    @Test
    public void testAdd() {
        MyTime sum = myTime1.add(myNumber);
        assertEquals("2017-12-28T12:00:05Z", sum.getDate().toString());
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
        assertEquals(0, counter.getCountOps());
    }

    @Test
    public void testCountNbs() {
        assertEquals(1, counter.getCountNbs());
    }

    @Test
    public void testCountDepth() {
        assertEquals(0, counter.getCountDepth());
    }

    @Test
    public void testGetCurrentTime(){
        assertEquals("03:00:05",myTime1.getCurrentTime());
    }

    @Test
    public void testGetTimeFormat(){
        assertEquals("PM",myTime1.getTimeFormat());
    }

    @Test
    public void testSubtractGUI(){
        assertEquals(27,myTime1.subtractGUI(myTime2)[0]);
        assertEquals(11,myTime1.subtractGUI(myTime2)[1]);
        assertEquals(0,myTime1.subtractGUI(myTime2)[2]);
        assertEquals(5,myTime1.subtractGUI(myTime2)[3]);
        assertEquals(659,myTime1.subtractGUI(myTime2)[4]);
        assertEquals(39540,myTime1.subtractGUI(myTime2)[5]);
        assertEquals(2372405,myTime1.subtractGUI(myTime2)[6]);
    }
}
