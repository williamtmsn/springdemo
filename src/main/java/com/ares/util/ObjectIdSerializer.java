package com.ares.util;

import java.io.IOException;
import java.lang.reflect.Type;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;

public class ObjectIdSerializer extends SerializerBase<ObjectId> {

	protected ObjectIdSerializer() {
		super(ObjectId.class);
	}

	@Override
	public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
		return null;
	}

	@Override
	public void serialize(ObjectId value, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonGenerationException {
		gen.writeString(value.toString());
	}

}