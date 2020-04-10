package es.profile.example.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ElementoExpresion implements IElementoOperacion {
	
	@Valid
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

	public Operacion getElemento() {
		return elemento;
	}
	
}
