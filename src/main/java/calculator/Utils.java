package calculator;

public class Utils {

    static int computeGCD(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return computeGCD(n2, n1 % n2);
    }
}
