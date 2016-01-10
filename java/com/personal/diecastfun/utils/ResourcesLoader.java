package com.personal.diecastfun.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ResourcesLoader {

  @SuppressWarnings("rawtypes")
  public InputStream loadResource(Class aClass, String resourceName) throws Exception {
    return aClass.getResourceAsStream(resourceName);
  }

  public OutputStream loadResourceForWriting(String resourceName) throws Exception {
    URL resourceUrl = getClass().getResource(resourceName);
    if (resourceUrl == null) {
      throw new FileNotFoundException("Can't find the resource with the name : " + resourceName);
    }

    File file = new File(resourceUrl.toURI());
    return new FileOutputStream(file, false);
  }
}
