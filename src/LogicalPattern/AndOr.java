package LogicalPattern;

/**
 * Created by yizhao on 12/11/14.
 */
public class AndOr {
    /*
    * Pattern: (A&&B)||C
    * */
    public static void main(String[] args){
        and_or_pattern_1();

    }

    public static void and_or_pattern_1() {
        boolean A = true;
        boolean B = true;
        boolean C = true;
        if(A && B){
            System.out.println("statement");
        }else {
            if (C) {
                System.out.println("statement");
            }
        }
    }

}
