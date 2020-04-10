package es.profile.example.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ElementoValor implements IElementoOperacion {
	
	@NotNull
	private final BigDecimal elemento;
	
	
	public ElementoValor(@NotNull BigDecimal elemento) {
		super();
		this.elemento = elemento;
	}

	@Override
	public BigDecimal computar() {
		return elemento;
	}

	public BigDecimal getElemento() {
		return elemento;
	}
	
}
