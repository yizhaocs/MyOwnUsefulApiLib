package main.java.LogicalPattern;

/**
 * Created by yizhao on 12/11/14.
 */
public class A_and_B_or_C {
    /*
    * Pattern: (A&&B)||C
    * */
    public static void main(String[] args){
        pattern_1();
        pattern_2();
    }

    public static void pattern_1() {
        boolean A = true;
        boolean B = true;
        boolean C = true;
        if(A && B){
            System.out.println("statement_1");
        }else {
            if (C) {
                System.out.println("statement_1");
            }
        }
    }

    public static void pattern_2() {
        boolean A = true;
        boolean B = true;
        boolean C = true;
        if(A && B){
            System.out.println("statement_1");
        }else if(C){
            System.out.println("statement_1");
        }
    }

}
