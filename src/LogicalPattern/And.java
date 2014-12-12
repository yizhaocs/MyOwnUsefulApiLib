package LogicalPattern;

/**
 * Created by yizhao on 12/10/14.
 */
public class And {

    /*
   * Pattern: A&&B
   * */
    public static void main(String[] args){
        and_pattern_1();
        and_pattern_2();
    }

    public static void and_pattern_1() {
        boolean A = true;
        boolean B = true;

        if(A && B){
            System.out.println("statement");
        }
    }

    public static void and_pattern_2() {
        boolean A = true;
        boolean B = true;

        if(A){
            if(B){
                System.out.println("statement");
            }
        }
    }

}
