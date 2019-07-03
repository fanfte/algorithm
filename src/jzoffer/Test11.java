package jzoffer;

/**
 * Created by tianen on 2019/3/22
 *
 * @author fanfte
 * @date 2019/3/22
 **/
public class Test11 {

    public double pow(double base, int exponent) throws Exception {
        if (base == 0 && exponent == 0) {
            throw new Exception("invalid input num");
        }

        if (base == 0) {
            return 0;
        }
        int absolute = exponent;
        if (exponent < 0) {
            absolute = - exponent;
        }
        double res = getPowerWithExponent(base, absolute);
        if (exponent < 0) {
            res = 1 / res;
        }
        return res;
    }

    private double getPowerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = getPowerWithExponent(base, exponent >> 1);
        result *= result;
        if (exponent % 2 != 0) {
            result *= base;
        }
        return result;
    }
}
