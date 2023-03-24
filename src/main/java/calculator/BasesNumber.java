package calculator;

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
public class BasesNumber
{
    /**
     * The base of the number
     */
    private int base;

    /**
     * The value of the number
     */
    private int value;

    /**
     * The constructor of the class
     * @param base : the base of the number
     * @param value : the value of the number
     */
    public BasesNumber(int base, int value)
    {
        this.base = base;
        this.value = value;
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
    public int getValue()
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
    }

    /**
     * The setter of the value
     * @param value : the value of the number
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * The method to convert a number from a base to another
     * @param base : the base of the number
     * @param value : the value of the number
     * @return the number converted
     */
    public BasesNumber convert(int base, int value)
    {
        return new BasesNumber(base, value);
    }

    /**
     * The method to convert a number from a base to another
     * @param base : the base of the number
     * @return the number converted
     */
    public BasesNumber convert(int base)
    {
        return new BasesNumber(base, value);
    }

    /**
     * The method to convert a number from a base to another
     * @return the number converted
     */
    public BasesNumber convert()
    {
        return new BasesNumber(base, value);
    }

    /**
     * The method to convert a number from a base to another
     * @param base : the base of the number
     * @param value : the value of the number
     * @return the number converted
     */
    public BasesNumber convert(BasesNumber base, BasesNumber value)
    {
        return new BasesNumber(base.getBase(), value.getValue());
    }
}
