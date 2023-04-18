package calculator;

import java.math.BigInteger;

/**
 * Problem :
 * ---------
 * It should be possible to represent and manipulate numbers in different
 * bases n (eg. , 2=binary, 8= octal, 16=hexadecimal, and so on...), and to
 * convert numbers between these different bases. Note that, in order to
 * support hexadecimal numbers (especially in combination with a GUI, one
 * also needs to be able to use the A to F characters in the number
 * representation. To be discussed whether and how we want to support other
 * bases above 10, and how to represent these numbers. We could easily go up
 * to 36 (since we have 26 letters in the alphabet on top of the 10 digits
 * from 0 to 9. I would not go higher than base 36, since in practice nobody
 * be using that
 */
public class BasesNumber extends Numbi
{
    /**The base of the number*/
    private int base;
    /**The value of the number*/
    private String value;
    /**The value of the number*/
    private BigInteger integer;


    /**
     * The constructor of the class
     * @param base : the base of the number
     * @param value : the value of the number
     */
    public BasesNumber(int base, String value)
    {
        this.base = base;
        this.value = value;
        integer = new BigInteger(value, base);
    }


    /**
     * The getter of the base
     * @return the base of the number
     */
    public int getBase()
    {
        return base;
    }


    /**
     * The getter of the value
     * @return the value of the number
     */
    public String getValuetoString()
    {
        return value;
    }


    /**
     * The setter of the base
     * @param base : the base of the number
     */
    public void setBase(int base)
    {
        this.base = base;
        integer = new BigInteger(value, base);
    }


    /**
     * The setter of the value
     * @param value : the value of the number
     */
    public void setValue(String value)
    {
        this.value = value;
        integer = new BigInteger(value, base);
    }


    /**
     * Counts the depth of nested expressions in an arithmetic expression
     * @return The depth of an arithmetic expression
     */
    @Override
    public Integer countDepth()
    {
        return 0;
    }


    /**
     * Counts the number of operations recursively contained in an arithmetic expression
     * @return The number of operations contained in an arithmetic expression
     */
    @Override
    public Integer countOps()
    {
        return 0;
    }


    /**
     * Counts the number of values recursively contained in an arithmetic expression
     * @return The number of values contained in an arithmetic expression
     */
    @Override
    public Integer countNbs()
    {
        return 1;
    }


    /**
     * The getValue method is used to obtain the value contained in the object
     * @return The value contained in the object
     */
    @Override
    public Integer getValue()
    {
        return integer.intValue();
    }
}
