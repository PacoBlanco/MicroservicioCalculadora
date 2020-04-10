package es.profile.example.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ElementoExpresion implements IElementoOperacion {
	
	@NotNull
	private final Operacion elemento;

	public ElementoExpresion(@NotNull Operacion elemento) {
		super();
		this.elemento = elemento;
	}

	@Override
	public BigDecimal computar() {
		return elemento.computar();
	}
}
