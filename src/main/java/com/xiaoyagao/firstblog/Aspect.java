package com.xiaoyagao.firstblog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private final Logger logger=LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.xiaoyagao.firstblog.web.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        String url=request.getRequestURI();
        String ip=request.getRemoteAddr();
        String method=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,method,args);
        logger.info(requestLog.toString());
    }

    @After("log()")
    public void doAfter(){
        logger.info("---------切面完成后-----------");
    }

    @AfterReturning(returning = "result" ,pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result: "+result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private Object[] args;
        private String method;

        public RequestLog(String url, String ip, String method,Object[] args) {
            this.url = url;
            this.ip = ip;
            this.method = method;
            this.args=args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", args=" + Arrays.toString(args) +
                    ", method='" + method + '\'' +
                    '}';
        }
    }

}
