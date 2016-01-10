package com.personal.diecastfun.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.personal.diecastfun.utils.ResourcesLoader;

public class XMLSerializer<T> {

  private Class<T> type;

  private ResourcesLoader resourcesLoader;
  private Marshaller marshaller;
  private Unmarshaller unmarshaller;

  public XMLSerializer(Class<T> type) throws JAXBException {
    this(type, new ResourcesLoader());
  }

  public XMLSerializer(Class<T> type, ResourcesLoader resourcesLoader) throws JAXBException {
    this.type = type;
    JAXBContext context = JAXBContext.newInstance(type);
    marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    unmarshaller = context.createUnmarshaller();
    this.resourcesLoader = resourcesLoader;
  }

  @SuppressWarnings("unchecked")
  public T deserialize(String resourceName) throws Exception {
    InputStream stream = resourcesLoader.loadResource(type, resourceName);

    return (T) unmarshaller.unmarshal(stream);
  }

  public void serialize(T element, String resourceName) throws Exception {
    OutputStream stream = resourcesLoader.loadResourceForWriting(resourceName);

    try {
      stream.write("".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }

    marshaller.marshal(element, stream);
  }
}
