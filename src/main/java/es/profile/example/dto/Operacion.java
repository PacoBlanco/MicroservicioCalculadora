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
	private BigDecimal miembroIzquierdo;
	
	@NotNull
	private BigDecimal miembroDerecho;


	public BigDecimal computar() {
		return operacion.operador.apply(getMiembroIzquierdo(), getMiembroDerecho());
	}
	
	
	public TipoOperacion getOperacion() {
		return operacion;
	}
	public void setOperacion(TipoOperacion operacion) {
		this.operacion = operacion;
	}
	public BigDecimal getMiembroIzquierdo() {
		return miembroIzquierdo;
	}
	public void setMiembroIzquierdo(BigDecimal miembroIzquierdo) {
		this.miembroIzquierdo = miembroIzquierdo;
	}
	public BigDecimal getMiembroDerecho() {
		return miembroDerecho;
	}
	public void setMiembroDerecho(BigDecimal miembroDerecho) {
		this.miembroDerecho = miembroDerecho;
	}
	
}
