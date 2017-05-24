package main.java.travix.flightsearch.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = Logger.getLogger("LoggingAspect");

	@Pointcut("within(@org.springframework.stereotype.RestController *)")
	public void controller() {
	}

	@Before("controller()")
	public void printRequestLog(JoinPoint joinPoint) {
		try {
			Object[] argsList = joinPoint.getArgs();
			String str = "[";
			for (Object arg : argsList) {
				if (arg instanceof Object[]) {
					str += Arrays.toString((Object[]) arg) + ", ";
				} else {
					str += String.valueOf(arg) + ", ";
				}
			}
			str += "]";
			logger.info("Request args for " + joinPoint.getSignature().getName() + " are : " + str);
		} catch (Exception ex) {
			logger.info("Unable to log request args", ex);
		}
	}

	// This will be called for all controller methods after returning
	@AfterReturning(pointcut = "controller()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		long start = System.nanoTime();
		try {
			logger.info("Response sent by " + joinPoint.getSignature().getName() + " are : " + result);
		} catch (Exception ex) {
			logger.error("Returned result cant be converted in JSON ", ex);
		}
		long end = System.nanoTime();
		logger.info("elapsed time : " + (end - start));
	}
}