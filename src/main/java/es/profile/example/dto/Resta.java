package es.profile.example.dto;

import java.math.BigDecimal;

public class Resta extends Operacion {
	
	public Resta() {
		super(TipoOperacion.RESTA);
	}

	@Override
	public BigDecimal computar() {
		return getMiembroIzquierdo().subtract(getMiembroDerecho());
	}
	
	
	@Override
	public void setOperacion(TipoOperacion operacion) {
	}
	
}
