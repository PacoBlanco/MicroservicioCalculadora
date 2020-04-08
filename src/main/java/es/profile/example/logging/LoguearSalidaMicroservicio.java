package es.profile.example.logging;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.corp.calculator.TracerAPI;

@Component
@Aspect
public class LoguearSalidaMicroservicio {
	
	@Autowired
	private TracerAPI tracer;

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void controladorRest() {
	}
	
	
	@Pointcut(value = "execution(@org.springframework.web.bind.annotation.RequestMapping * *.*(..))")
	public void metodoRequestMapping() {
	}
	
	
	@AfterReturning(pointcut = "controladorRest() && metodoRequestMapping()", returning = "resultado")
	public void logAfter(Object resultado) {
		tracer.trace(resultado);
	}
	
	
}
