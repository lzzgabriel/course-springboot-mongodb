package dev.lzzgabriel.coursespringbootmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

  public static String decodeParam(String param) {
    try {
      return URLDecoder.decode(param, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      return null;
    }
  }

  public static Instant convertInstant(String textInstant, Instant defaultValue) {
    try {
      return LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(textInstant)).toInstant(ZoneOffset.UTC);
    } catch (DateTimeParseException | NullPointerException e) {
      return defaultValue;
    }
  }

}
