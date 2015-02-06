package com.monitorjbl.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

public class ViewAwareJsonMessageConverter extends MappingJackson2HttpMessageConverter {

  public ViewAwareJsonMessageConverter() {
    super();
    ObjectMapper defaultMapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(JsonResultWrapper.class, new JsonViewSerializer());
    defaultMapper.registerModule(module);
    setObjectMapper(defaultMapper);
  }

  @Override
  protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
    super.writeInternal(object, outputMessage);
  }

}