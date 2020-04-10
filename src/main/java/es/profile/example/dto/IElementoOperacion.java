package es.profile.example.dto;


import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import es.profile.example.deserializer.ElementoOperacionDeserializer;

@JsonDeserialize(using = ElementoOperacionDeserializer.class)
public interface IElementoOperacion {
	
	public BigDecimal computar();
	
}
