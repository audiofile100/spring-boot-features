package com.springbootfeatures.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* com.springbootfeatures.*.*.*(..))")
    public void ALL() { }

    @Pointcut("execution(* com.springbootfeatures.controller.*.*(..))")
    public void CONTROLLERS() { }

    @Pointcut("execution(* com.springbootfeatures.service.*.*(..))")
    public void SERVICES() { }
}
