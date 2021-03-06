package com.equinooxe.domain.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Get a LocalDateTime from json "yyyy-MM-dd HH:mm:ss" format
 * @todo 1: move some code to a static method
         2: export the date format to config class/file
 * @author mboullouz
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	protected LocalDateTimeDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(jp.readValueAs(String.class), formatter);
	}
}
