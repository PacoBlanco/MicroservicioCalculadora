package es.profile.example.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="operacion",visible = true)
@JsonSubTypes({
	@Type(value = Suma.class, name = "SUMA"),
	@Type(value = Resta.class, name = "RESTA")
})
public abstract class Operacion {

	public enum TipoOperacion {
		SUMA, RESTA;
	}
	
	@NotNull
	private TipoOperacion operacion;
	
	@NotNull
	private BigDecimal miembroIzquierdo;
	
	@NotNull
	private BigDecimal miembroDerecho;
	
	
	public Operacion() {
		super();
	}

	public Operacion(@NotNull TipoOperacion operacion) {
		super();
		this.operacion = operacion;
	}


	public abstract BigDecimal computar();
	
	
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
