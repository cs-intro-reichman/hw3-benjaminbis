public class Algebra {
    public static void main(String[] args) {
        System.out.println(plus(2, 3));
        System.out.println(minus(7, 2));
        System.out.println(minus(2, 7));
        System.out.println(times(3, 4));
        System.out.println(plus(2, times(4, 2)));
        System.out.println(pow(5, 3));
        System.out.println(div(12, 3));
        System.out.println(mod(25, 7));
        System.out.println(sqrt(36));
    }

    public static int plus(int x1, int x2) {
        while (x2 != 0) {
            if (x2 > 0) {
                x1++;
                x2--;
            } else {
                x1--;
                x2++;
            }
        }
        return x1;
    }

    public static int minus(int x1, int x2) {
        return plus(x1, -x2);
    }

    public static int times(int x1, int x2) {
        int result = 0;
        while (x2 > 0) {
            result = plus(result, x1);
            x2--;
        }
        while (x2 < 0) {
            result = minus(result, x1);
            x2++;
        }
        return result;
    }

    public static int pow(int x, int n) {
        int result = 1;
        while (n > 0) {
            result = times(result, x);
            n--;
        }
        return result;
    }

    public static int div(int x1, int x2) {
        int result = 0;
        while (x1 >= x2) {
            x1 = minus(x1, x2);
            result++;
        }
        return result;
    }

    public static int mod(int x1, int x2) {
        return minus(x1, times(div(x1, x2), x2));
    }

    public static int sqrt(int x) {
        int result = 0;
        while (times(result, result) <= x) {
            result++;
        }
        return minus(result, 1);
    }
}
