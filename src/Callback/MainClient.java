package Callback;

/**
 * Created by yizhao on 12/7/14.
 */
public class MainClient {
    public static void main(String[] args) {
        MyButton button = new MyButton();
        //注册监听器
        button.setOnClickListener(new MyOnClickListener() {

            @Override
            public void onClick() {
                System.out.println("按钮被点击了");

            }

        });
        //模拟用户点击
        button.doClick();
    }
}