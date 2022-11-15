package example.lab2.Aspect;


import example.lab2.Model.AppLogger;
import example.lab2.Service.Interface.AppLoggerInterfice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.ZoneId;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private AppLoggerInterfice loggerInterfice;
    private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());



    @Around("execution(* example.lab2.Controller.*.*(..))")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            //Execution method
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //Save log
        try {
            saveLog(point, beginTime);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }


    private void saveLog(ProceedingJoinPoint joinPoint, long time) throws Throwable {
        AppLogger applicationLog = new AppLogger();
        long start = System.nanoTime();
        joinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(joinPoint.getSignature().getName() + " takes ns: " + (finish - start));
        applicationLog.setTime(finish-start);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        applicationLog.setDate(Instant.ofEpochMilli(time)
                .atZone(ZoneId.of("America/New_York")).toLocalDate());
        applicationLog.setOperation(request.getMethod());
        applicationLog.setPrinciple("Test Principle");
        applicationLog.setOperation("Test Operation");
        loggerInterfice.saveApplicationLog(applicationLog);
    }



}
