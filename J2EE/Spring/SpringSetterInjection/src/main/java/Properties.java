package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by yizhao on 4/22/15.
 */
public class Properties {
    private Boolean flag;

    public boolean isFlag() {
        return flag;
    }

    @Autowired(required = true)
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
