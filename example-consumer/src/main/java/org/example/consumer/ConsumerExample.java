package org.example.consumer;

import org.example.common.model.User;
import org.example.common.service.UserService;
import org.example.rpc.xind.config.RpcConfig;
import org.example.rpc.xind.proxy.ServiceProxyFactory;
import org.example.rpc.xind.utils.ConfigUtils;

/**
 * 简易服务消费者示例
 *

 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("xind");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}
