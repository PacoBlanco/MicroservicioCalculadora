package es.profile.example;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.profile.example.dto.Operacion;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {
	
	@RequestMapping(value = "operaciones", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public BigDecimal operar(@Valid @RequestBody Operacion operacion) {
		return operacion.computar();
	}
	
//	/**
//	 * Gestión de errores en el caso de querer retornar una excepción/un objeto de un tipo según la especificación a definir de salida del Microservicio que se quiera
//	 * 
//	 * @param e
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@ExceptionHandler
//	public @ResponseBody
//	Object handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
//		return e;
//	}

}
