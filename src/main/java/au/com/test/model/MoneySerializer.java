package au.com.test.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MoneySerializer extends JsonDeserializer<Double>{

	@Override
	public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String value = p.getValueAsString();
		if (value.startsWith("$")) {
			return Double.parseDouble(value.substring(1));
		}
		return Double.parseDouble(value);
	}

	

	

}
