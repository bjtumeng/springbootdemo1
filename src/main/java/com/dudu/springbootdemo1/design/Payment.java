package com.dudu.springbootdemo1.design;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/7 6:59 下午
 */
public class Payment {
    private boolean success;

    // 其他参数略....

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}