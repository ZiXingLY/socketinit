package com.qy;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class Application {
    @Bean
    public SocketIOServer socketIOServer() throws UnknownHostException {
//        InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
//        String hostAddress = address.getHostAddress();//192.168.0.121
        Configuration config = new Configuration();

//        config.setHostname("172.31.49.184");
        config.setHostname("localhost");
        config.setPort(8081);

        //该处可以用来进行身份验证
        config.setAuthorizationListener(new AuthorizationListener() {
            @Override
            public boolean isAuthorized(HandshakeData data) {
                System.out.println(data);
                //http://localhost:8081?username=test&password=test
                //例如果使用上面的链接进行connect，可以使用如下代码获取用户密码信息，本文不做身份验证
//              String username = data.getSingleUrlParam("username");
//              String password = data.getSingleUrlParam("password");
                return true;
            }
        });
        return new SocketIOServer(config);
    }
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }
}

