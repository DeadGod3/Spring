package com.pustovit.springpractice.config;

import com.pustovit.springpractice.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.pustovit.springpractice.config")
@PropertySource("classpath:application.properties")
public class BeanConfiguration {

    @Value("${firstPropEx}")
    public String firstApplicationPropertiesEx;

    @Value("${secondPropEx}")
    public String secondApplicationPropertiesEx;

    //All Beans are singleton by default
    @Bean
    public String stringBean() {
        return "writing String from stringBean method";
    }

    @Bean
    @Scope("prototype")
//    Prototype have the same parameters but diff hash and new one
    public User getCustomUser() {
        return new User(1,"Ihor", "Pustovit", 20, "+390666753", "3s3@mail.u");
    }

    @Bean
    public String getFirstApplicationPropertiesEx() {
        return firstApplicationPropertiesEx;
    }

    @Bean
    public String getSecondApplicationPropertiesEx() {
        return secondApplicationPropertiesEx;
    }


}
