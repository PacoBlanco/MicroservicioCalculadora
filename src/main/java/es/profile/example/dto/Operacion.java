package es.profile.example.dto;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

import javax.validation.constraints.NotNull;


public class Operacion {

	public enum TipoOperacion {
		SUMA(BigDecimal::add), RESTA(BigDecimal::subtract);
		
		private final BinaryOperator<BigDecimal> operador;

		private TipoOperacion(BinaryOperator<BigDecimal> operador) {
			this.operador = operador;
		}
	}
	
	@NotNull
	private TipoOperacion operacion;
	
	@NotNull
	private IElementoOperacion miembroIzquierdo;
	
	@NotNull
	private IElementoOperacion miembroDerecho;
	
	
	
	public BigDecimal computar() {
		return operacion.operador.apply(getMiembroIzquierdo().computar(), getMiembroDerecho().computar());
	}
	
	
	public TipoOperacion getOperacion() {
		return operacion;
	}
	public void setOperacion(@NotNull TipoOperacion operacion) {
		this.operacion = operacion;
	}
	public IElementoOperacion getMiembroIzquierdo() {
		return miembroIzquierdo;
	}
	public void setMiembroIzquierdo(IElementoOperacion miembroIzquierdo) {
		this.miembroIzquierdo = miembroIzquierdo;
	}
	public IElementoOperacion getMiembroDerecho() {
		return miembroDerecho;
	}
	public void setMiembroDerecho(IElementoOperacion miembroDerecho) {
		this.miembroDerecho = miembroDerecho;
	}
	
}
