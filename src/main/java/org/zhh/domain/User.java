package org.zhh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 用户表
 * @Author junhi
 * @Date 2019/6/4 10:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements HttpSessionBindingListener {

    private int id;
    private String username;
    private String password;
    private int telephone;
    private String email;
    private int status;

    private int count = 0;

    /**
     * 当本类对象被存入session中，调用该方法
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        count++;
        System.out.println("执行valueBound方法。。。");
    }

    /**
     * 当本类对象从session中移除，调用该方法
     * @param event
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        count++;
        System.out.println("执行valueUnBound方法。。。");
    }
}
