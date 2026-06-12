package com.pawamamama.hoemwork_;

/**
 * HomeWork02
 *
 * <p>
 * 模拟用户注册信息校验。
 * 对用户名、邮箱和密码进行合法性验证：
 * </p>
 *
 * <ul>
 *     <li>用户名长度要求2~4位且不能为空</li>
 *     <li>邮箱必须包含@和.</li>
 *     <li>密码长度必须为6位且全部由数字组成</li>
 * </ul>
 *
 * <p>
 * 采用构造器调用Setter方法完成参数校验，
 * 当参数不合法时抛出RuntimeException异常。
 * </p>
 *
 * @author pawamamama
 * @since 2026/6/12
 */
public class HomeWork02 {
    public static void main(String[] args) {
        try {
            LoginSystem wang = new LoginSystem("wang", "pawamamama@gmail.com", "123344");
            System.out.println(wang.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

}
/**
 * 用户登录信息实体类
 *
 * <p>
 * 封装用户姓名、邮箱和密码信息，
 * 创建对象时自动完成数据合法性校验。
 * </p>
 *
 * @author pawamamama
 * @since 2026/6/12
 */
class LoginSystem {
    private String name;
    private String email;
    private String password;

    public LoginSystem(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    private void setName(String name) {

        if (!(name != null && name.length() >= 2 && name.length() <= 4) ) {
            throw  new RuntimeException("姓名设置错误要求 2~4 个,不能为空");
        }
        this.name = name;
    }

    private void setEmail(String email) {
        if (!(email != null && email.indexOf("@") > 0  && email.lastIndexOf(".") > 0) ) {
            throw new RuntimeException("邮箱格式不对");
        }
        this.email = email;
    }

    private void setPassword(String password) {
       if ( !(password != null && password.length() == 6) ) {
           throw new RuntimeException("密码要求6个而且不能为空");
       }

        try {
            //不能转成int 的String 肯定是带别的字符的
           int pasd = Integer.parseInt(password);
        } catch (Exception e) {
            throw new RuntimeException("密码必须全是数字");//抛出一个运行异常
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginSystem{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
