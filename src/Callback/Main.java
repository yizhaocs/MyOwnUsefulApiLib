package Callback;

/**
 * Created by yizhao on 12/7/14.
 */
public class Main {
    public static void main(String[] args) {
        Exam exam1 = new Exam();
        Exam exam2 = new Exam();

        Student zhaoyi =  new Student() {
            @Override
            public void name() {
                System.out.println("Yi Zhao");
            }
        };

        Student zhangsan =  new Student() {
            @Override
            public void name() {
                System.out.println("San Zhang");
            }
        };
                

        //注册监听器
        exam1.setStudentNameListener(zhaoyi);
        exam2.setStudentNameListener(zhangsan);

        //模拟用户点击
        exam1.getStudentName();
        exam2.getStudentName();
    }
}
