package LogicalPattern;

/**
 * Created by yizhao on 12/10/14.
 */
public class Or {

    /*
   * Pattern: A||B
   * */
    public static void main(String[] args){
        or_pattern_1();
        or_pattern_2();
    }

    public static void or_pattern_1() {
        boolean A = true;
        boolean B = false;

        if(A || B){
            System.out.println("statement");
        }
    }

    public static void or_pattern_2() {
        boolean A = true;
        boolean B = false;

        if(A){
            System.out.println("statement");
        }else{
            if(B){
                System.out.println("statement");
            }
        }
    }
}
