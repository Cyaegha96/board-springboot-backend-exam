package com.kedu.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //서버의 어떤 url 로 요청을 하든
                .allowedOrigins("http://10.5.5.1:3000") // 내가 허용한 출처에서
                .allowedMethods("*") //모든 요청 방식
                .allowedHeaders("*") //모든 요청 헤더에 대해 모든 허가 하겠음
                .allowCredentials(true); //크로스 오리진에서 들어오는 세션 키값(자격증명)도 허용하겠음.
    }

}
