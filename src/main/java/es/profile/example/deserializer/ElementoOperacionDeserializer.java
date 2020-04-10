package es.profile.example.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import es.profile.example.dto.ElementoExpresion;
import es.profile.example.dto.ElementoValor;
import es.profile.example.dto.IElementoOperacion;
import es.profile.example.dto.Operacion;

public class ElementoOperacionDeserializer extends StdDeserializer<IElementoOperacion>{
	private static final long serialVersionUID = -7164503717928202531L;

	protected ElementoOperacionDeserializer() {
		this(null);
	}
	
	protected ElementoOperacionDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public IElementoOperacion deserialize(JsonParser parte, DeserializationContext contexto) throws IOException, JsonProcessingException {
		ObjectCodec codificador = parte.getCodec();
		JsonNode nodo = codificador.readTree(parte);
		
		if(nodo.isNumber()) {
			return new ElementoValor(nodo.decimalValue());
		}
		return new ElementoExpresion(codificador.treeToValue(nodo, Operacion.class));
	}

}
