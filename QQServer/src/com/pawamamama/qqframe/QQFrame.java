package com.pawamamama.qqframe;

import com.pawamamama.qqserver.service.QQServer;

/**
 * Class: QQFrame
 *
 * <pre>qq服务器启动，相当于启动后台服务
 * </pre>
 *
 * @author pawamamama
 * @date 2026/9/21
 */
@SuppressWarnings({"all"})
public class QQFrame {
    public static void main(String[] args) {
        new QQServer();
    }
}