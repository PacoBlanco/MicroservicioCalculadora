package es.profile.example;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.profile.example.dto.Operacion;
import es.profile.example.dto.Operacion.TipoOperacion;


@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void contextLoads() throws JsonProcessingException, Exception {
		Operacion operacion = obtenerOperacionPrueba();
		this.mockMvc.perform(MockMvcRequestBuilders.post("/calculadora/operaciones").content(objectMapper.writeValueAsString(operacion)).contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON)).andDo(print()).
				andExpect(status().isCreated()).andExpect(content().json("-1.01"));
	}
	
	private Operacion obtenerOperacionPrueba() {
		Operacion operacion = new Operacion();
		operacion.setMiembroIzquierdo(new BigDecimal("1.01"));
		operacion.setMiembroDerecho(new BigDecimal("2.02"));
		operacion.setOperacion(TipoOperacion.RESTA);
		return operacion;
	}
}
