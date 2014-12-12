package InstanceOf;



/**
 * Created by yizhao on 12/11/14.
 */
public class InstanceOfMain {
    /*
    * usuage: The instanceof keyword can be used to test if an object is of a specified type.
    * reference: http://www.java2s.com/Tutorial/Java/0060__Operators/TheinstanceofKeyword.htm
    * */
    public static void main(String[] a) {
        System.out.println(example1()); // true
        System.out.println(example2()); // false
        System.out.println(example3()); // true
    }


    private static boolean example1(){
        String s = "Hello";
        if (s instanceof java.lang.String) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean example2(){
        String s = null;
        if (s instanceof java.lang.String) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean example3(){
        Child child = new Child();
        if (child instanceof Parent) {
            return true;
        }else{
            return false;
        }

    }
}

