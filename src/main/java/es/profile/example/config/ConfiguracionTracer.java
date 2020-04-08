package es.profile.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

@Configuration
public class ConfiguracionTracer {
	
	@Bean
	public TracerAPI obtenerTracer() {
		TracerImpl tracer = new TracerImpl();
		return tracer::trace;
	}

}
