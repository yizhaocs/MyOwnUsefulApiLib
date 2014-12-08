package Callback;

/**
 * Created by yizhao on 12/7/14.
 */
public class Exam {
    private StudentListener student;

    /**
     * 设置具体点击监听器
     *
     * @param student 点击监听器实现类
     */
    public void registerStudentName(StudentListener student) {
        this.student = student;
    }

    /**
     * 按钮被点击
     */
    public void getStudentName() {
        student.myName();
    }
}
