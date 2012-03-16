package com.ares.util;

import org.bson.types.ObjectId;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

public class CustomObjectMapper extends ObjectMapper {
	public CustomObjectMapper() {
		CustomSerializerFactory sf = new CustomSerializerFactory();
		sf.addSpecificMapping(ObjectId.class, new ObjectIdSerializer());
		this.setSerializerFactory(sf);

		// config
		this.configure(SerializationConfig.Feature.AUTO_DETECT_FIELDS, false);
		this.configure(SerializationConfig.Feature.AUTO_DETECT_GETTERS, false);
		this.configure(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS, false);
		this.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);
		this.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
	}
}