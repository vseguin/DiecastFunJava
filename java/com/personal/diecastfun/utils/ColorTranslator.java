package com.personal.diecastfun.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ColorTranslator {

  private static Map<String, String> colors = new HashMap<String, String>();

  static {
    colors.put("Cream White", "#FFFFCC");
    colors.put("White", "#FFFFFF");
    colors.put("Black", "#000000");
    colors.put("Wine Red", "#800000");
    colors.put("Red", "#FF0000");
    colors.put("Orange", "#FF6600");
    colors.put("Burnt Orange", "#A2442F");
    colors.put("Cooper", "#993D00");
    colors.put("Beige", "#a89b7b");
    colors.put("Maroon", "#3E1415");
    colors.put("Brown", "#47221a");
    colors.put("Silver", "#BDBDBD");
    colors.put("Gold", "#9c6f34");
    colors.put("Titanium Silver", "#ACAC83");
    colors.put("Gold Yellow", "#B8B800");
    colors.put("Orange Yellow", "#FE9A2E");
    colors.put("Pale Yellow", "#FFFF66");
    colors.put("Yellow", "#FFFF00");
    colors.put("Green", "#297C29");
    colors.put("Olive Green", "#26361e");
    colors.put("Lime Green", "#4BBA25");
    colors.put("Forest Green", "#003300");
    colors.put("Neon Green", "#9dde2b");
    colors.put("Steel Green", "#80977d");
    colors.put("White Green", "#cee3dc");
    colors.put("Sky Blue", "#4E90D4");
    colors.put("Pale Blue", "#B4CFE2");
    colors.put("Indigo", "#272d37");
    colors.put("Steel Blue", "#6c87a3");
    colors.put("Dark Blue", "#0B2161");
    colors.put("Dark Aqua", "#406263");
    colors.put("Aqua", "#59d3d0");
    colors.put("Blue", "#0000FF");
    colors.put("Turquoise", "#0B7E9B");
    colors.put("Dark Brown", "#422100");
    colors.put("Purple", "#5C005C");
    colors.put("Light Purple", "#ab93ab");
    colors.put("Violet", "#4200A3");
    colors.put("Pink", "#f88da7");
    colors.put("Salmon", "#a55f4b");
    colors.put("Burgundy", "#1A1019");
    colors.put("Metallic Gray", "#424242");
    colors.put("Pale Gray", "#9ca3a5");
    colors.put("Dark Grey", "#353b3c");
  }

  public static String translateColor(String color) {
    return colors.get(color);
  }

  public static List<String> findAllColors() {
    return new ArrayList<String>(colors.keySet());
  }

}
