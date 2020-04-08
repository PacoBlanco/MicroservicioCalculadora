package es.profile.example.dto;

import java.math.BigDecimal;

public class Suma extends Operacion {
	
	public Suma() {
		super(TipoOperacion.SUMA);
	}

	@Override
	public BigDecimal computar() {
		return getMiembroIzquierdo().add(getMiembroDerecho());
	}
	
	
	@Override
	public void setOperacion(TipoOperacion operacion) {
	}
	
}
