package com.dom.config;

/*
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

*/
/**
 * Created by henry on 2017/1/12.
 *//*

@EnableWebMvc
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
//    @Bean
//    public MyJsonViewSupportFactoryBean views() {
//        return new MyJsonViewSupportFactoryBean();
//    }

*/
/*    @Bean
    public MyJsonViewSupportFactoryBean views2() {
        MyJsonViewSupportFactoryBean bean = new MyJsonViewSupportFactoryBean();
        //bean.registerCustomSerializer(String.class, new ByteSerialzer());
        return bean;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ContextInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/favicon.ico");
    }*//*



    @Bean
    @ConditionalOnExpression("${com.dom.cors:true}")
    public org.springframework.web.servlet.config.annotation.WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
*/
