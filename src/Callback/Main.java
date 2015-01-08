package Callback;

/**
 * Created by yizhao on 12/7/14.
 */
public class Main {
    public static void main(String[] args) {
        Exam exam = new Exam();
        //注册监听器
        exam.setStudentNameListener(new StudentNameListener() {
            @Override
            public void myName() {
                System.out.println("Yi Zhao");
            }
        });
        //模拟用户点击
        exam.getStudentName();
    }
}
