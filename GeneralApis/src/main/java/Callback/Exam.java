package main.java.Callback;

/**
 * Created by yizhao on 12/7/14.
 */
public class Exam {
    private Student student;

    /**
     * 设置具体点击监听器
     *
     * @param student 点击监听器实现类
     */
    public void setStudentNameListener(Student student) {
        this.student = student;
    }

    /**
     * 按钮被点击
     */
    public void getStudentName() {
        student.name();
    }
}
