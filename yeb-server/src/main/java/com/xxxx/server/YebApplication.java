package com.xxxx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xxxx.server.mapper")
public class YebApplication {
}
