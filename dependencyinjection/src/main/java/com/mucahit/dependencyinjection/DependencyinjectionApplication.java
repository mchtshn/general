package com.mucahit.dependencyinjection;

import com.mucahit.dependencyinjection.config.Configurationn;
import com.mucahit.dependencyinjection.config.ConstructorConfiguration;
import com.mucahit.dependencyinjection.controllers.*;
import com.mucahit.dependencyinjection.datasource.FakeDataSource;
import com.mucahit.dependencyinjection.services.PrototypeBean;
import com.mucahit.dependencyinjection.services.SingletonBean;
import org.mucahit.pets.DogPetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.mucahit.dependencyinjection", "org.mucahit.pets"})
@SpringBootApplication
public class DependencyinjectionApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(DependencyinjectionApplication.class, args);

        I18nController i18nController = (I18nController) applicationContext.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        System.out.println("------------------");

        MyController myController = (MyController) applicationContext.getBean("myController");

        System.out.println(myController.sayHello());


        System.out.println("------------------");
        System.out.println("property");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) applicationContext.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreetings());
        System.out.println("------------------");
        System.out.println("Setter");

        SetterInjecttedController setterInjecttedController = (SetterInjecttedController) applicationContext.getBean("setterInjecttedController");
        System.out.println(setterInjecttedController.getGreetings());

        System.out.println("------------------");
        System.out.println("Constructor");
        ConstructorController constructorController = (ConstructorController) applicationContext.getBean("constructorController");
        System.out.println(constructorController.getGreetings());

        System.out.println("------------------");
        DogPetService dog = (DogPetService) applicationContext.getBean("dogPetService");
        System.out.println(dog.getPetType());

        System.out.println("------------------");
        System.out.println("Bean scopes");
        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 =  applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 =  applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());

        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());
        System.out.println("------------------");
        FakeDataSource fakeDataSource = applicationContext.getBean("fakeDataSource",FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcurl());

        System.out.println("------------------");
        System.out.println("Config Props Bean");
        Configurationn configurationn = applicationContext.getBean(Configurationn.class);
        System.out.println(configurationn.getUsername());
        System.out.println(configurationn.getPassword());
        System.out.println(configurationn.getJdbcurl());
        System.out.println("------------------");
        System.out.println("Constructor binding");
        ConstructorConfiguration constructorConfiguration = applicationContext.getBean(ConstructorConfiguration.class);
        System.out.println(constructorConfiguration.getUsername());
        System.out.println(constructorConfiguration.getPassword());
        System.out.println(constructorConfiguration.getJdbcurl());
        System.out.println("------------------");
    }

}
