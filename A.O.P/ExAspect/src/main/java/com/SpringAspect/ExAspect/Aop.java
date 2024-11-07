package com.SpringAspect.ExAspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class Aop {

    public static final Logger logger= LoggerFactory.getLogger(Aop.class);
    // Pointcut expression to target the HomeController's home method
    @Before("execution(public * com.SpringAspect.ExAspect.HomeController.home())")
    public void logBefore() {
        logger.info("It is executed before Home()");
    }

}
