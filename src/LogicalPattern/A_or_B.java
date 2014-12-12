package LogicalPattern;

/**
 * Created by yizhao on 12/10/14.
 */
public class A_or_B {

    /*
   * Pattern: A||B
   * */
    public static void main(String[] args){
        or_pattern_A_1();
        or_pattern_A_2();
        or_pattern_B_1();
        or_pattern_B_2();
    }

    public static void or_pattern_A_1() {
        boolean A = true;
        boolean B = false;

        if(A || B){
            System.out.println("statement_1");
        }
    }

    public static void or_pattern_A_2() {
        boolean A = true;
        boolean B = false;

        if(A){
            System.out.println("statement_1");
        }else{
            if(B){
                System.out.println("statement_1");
            }
        }
    }

    public static void or_pattern_B_1() {
        boolean A = true;
        boolean B = false;

        if(A || B){
            System.out.println("statement_1");
            return;
        }
        System.out.println("statement_2");
    }

    public static void or_pattern_B_2() {
        boolean A = true;
        boolean B = false;

        if(A){
            System.out.println("statement_1");
        }else{
            if(B){
                System.out.println("statement_1");
                return;
            }
            System.out.println("statement_2");
        }
    }
}
