package LogicalPattern;

/**
 * Created by yizhao on 12/12/14.
 */
public class A_or_B_and_C {
    /*
* Pattern: (A||B)&&C
* */
    public static void main(String[] args) {
        pattern_1();
        pattern_2();

    }

    public static void pattern_1() {
        boolean A = true;
        boolean B = true;
        boolean C = true;
        if (A) {
            if (C) {
                System.out.println("statement_1");
            }
        } else {
            if (B) {
                if (C) {
                    System.out.println("statement_1");
                }
            }
        }
    }

    public static void pattern_2() {
        boolean A = true;
        boolean B = true;
        boolean C = true;
        if (A) {
            if (C) {
                System.out.println("statement_1");
            }
        } else if (B) {
            if (C) {
                System.out.println("statement_1");
            }
        }
    }
}
