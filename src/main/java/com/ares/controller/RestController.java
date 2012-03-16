package com.ares.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ares.model.Shop;
import com.ares.util.JSON;

@Controller
@RequestMapping("/api/rest")
public class RestController {
	
	@RequestMapping(value = "/json-user", method = RequestMethod.GET)
    protected void getJsonDataExampleSimpleDataBinding(HttpServletResponse response) 
    		                    throws JsonGenerationException, JsonMappingException, IOException {
        
		ObjectMapper mapper = new ObjectMapper();
        Map<String, String> nameStruct = new HashMap<String, String>();
        nameStruct.put("first", "Joe");
        nameStruct.put("last", "Sixpack");
        Map<String, Object> userData = new HashMap<String, Object>();
        userData.put("name", nameStruct);
        userData.put("gender", "MALE");
        userData.put("verified", Boolean.FALSE);
        userData.put("userImage", "Rm9vYmFyIQ==");
        String jsonString = mapper.writeValueAsString(userData);

        AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();
        MediaType jsonMimeType = MediaType.APPLICATION_JSON;
        if (stringHttpMessageConverter.canWrite(String.class, jsonMimeType)) {
            try {
                stringHttpMessageConverter.write(jsonString, jsonMimeType, new ServletServerHttpResponse(response));
            } catch (IOException m_Ioe) {
            } catch (HttpMessageNotWritableException p_Nwe) {
            }
        }
    }
	
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public ModelAndView getResultAsJson(@PathVariable String name) throws JsonGenerationException, JsonMappingException, IOException {
		/*Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"demo1", "demo2"});
		*/
		/*ObjectMapper mapper = new ObjectMapper();
        Map<String, String> nameStruct = new HashMap<String, String>();
        nameStruct.put("first", "Joe");
        nameStruct.put("last", "Sixpack");
        Map<String, Object> userData = new HashMap<String, Object>();
        userData.put("name", nameStruct);
        userData.put("gender", "MALE");
        userData.put("verified", Boolean.FALSE);
        userData.put("userImage", "Rm9vYmFyIQ==");
        String jsonString = mapper.writeValueAsString(userData);
        
	    return new ModelAndView("jsonView", "result", jsonString);*/
		
		/*Map<String, Object> map = new HashMap<String, Object>();
	    map.put("view", "pathToMyXHTMLFile/someTest");
	    map.put("name", "tomik");

	    ModelAndView returnModelAndView = new ModelAndView("jsonBody", map);*/

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"demo1", "demo2"});
		System.out.println(JSON.serialize(shop));
		ModelAndView returnModelAndView = new ModelAndView("jsonBody", JSON.serialize(shop), shop);
	    return returnModelAndView;

	}

}
