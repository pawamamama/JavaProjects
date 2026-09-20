package com.pawamamama.qqcommon;

import java.io.Serializable;

/**
 * Class: User
 *
 * <pre>表示一个用户信息/客户信息
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/20
 */
@SuppressWarnings({"all"})
//网络传输需要序列化
public class User implements Serializable {

    /**
     * 序列化版本号
     *
     * 作用：增强序列化的兼容性。
     * 当类结构发生变化（增删字段、修改方法等）时，
     * 只要 serialVersionUID 保持不变，反序列化仍能兼容旧版本数据，
     * 避免抛出 InvalidClassException。
     *
     * 注意：
     * 1. 必须为 static final long 类型
     * 2. 建议使用 private 修饰
     * 3. 修改类结构时，如需保持兼容请不要随意修改该值
     */
    private static final long serialVersionUID = 1L;

    private String userId;//用户id/用户名
    private String prasswd;

    public User(String userId, String prasswd) {
        this.userId = userId;
        this.prasswd = prasswd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrasswd() {
        return prasswd;
    }

    public void setPrasswd(String prasswd) {
        this.prasswd = prasswd;
    }
}