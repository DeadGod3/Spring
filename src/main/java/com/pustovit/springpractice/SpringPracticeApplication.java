package com.pustovit.springpractice;

import com.pustovit.springpractice.controller.UserController;
import com.pustovit.springpractice.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringPracticeApplication {

    public static void main(String[] args) {
//        Ex of DI(Dependencies Injection) with Spring CONTEXT:
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringPracticeApplication.class, args);
        UserController userController = configurableApplicationContext.getBean(UserController.class);
        List<User> all = userController.getAll();
        all.forEach(System.out::println);


//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
////        Singleton Bean
//        String stringBean = context.getBean("stringBean", String.class);
////        Singleton Bean
//        User customUser = context.getBean("getCustomUser", User.class);
////        Bean with prototype SCOPE ex:
//        User customUser2 = context.getBean("getCustomUser", User.class);
//        customUser2.setName("IO");
//        customUser2.setAge(1001);
//
//        System.out.println(customUser);
//        System.out.println(customUser2);
//        System.out.println(stringBean);
//
////        Example of getting configurations with Value from application.properties:
//        String getFirstApplicationPropertiesEx = context.getBean("getFirstApplicationPropertiesEx", String.class);
//        String getSecondApplicationPropertiesEx = context.getBean("getSecondApplicationPropertiesEx", String.class);
//
//        System.out.println(getFirstApplicationPropertiesEx);
//        System.out.println(getSecondApplicationPropertiesEx);


    }

}
