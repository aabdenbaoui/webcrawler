package com.udacity.webcrawler.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * Utility class to write a {@link CrawlResult} to file.
 */
public final class CrawlResultWriter {
  private final CrawlResult result;

  /**
   * Creates a new {@link CrawlResultWriter} that will write the given {@link CrawlResult}.
   */
  public CrawlResultWriter(CrawlResult result) {
    this.result = Objects.requireNonNull(result);
  }

  /**
   * Formats the {@link CrawlResult} as JSON and writes it to the given {@link Path}.
   *
   * <p>If a file already exists at the path, the existing file should not be deleted; new data
   * should be appended to it.
   *
   * @param path the file path where the crawl result data should be written.
   */
  public void write(Path path) throws IOException {
    // This is here to get rid of the unused variable warning.
//    Objects.requireNonNull(path);
//    // TODO: Fill in this method.
//    try (BufferedWriter writer = Files.newBufferedWriter(path)){
//      write(writer);
//    }
    Objects.requireNonNull(path);
    // Try to write the path to the writer
    try (Writer writer = Files.newBufferedWriter(path)){
      // write to the writer
      write(writer);
      // catch any errors that pop up
    } catch (IOException e) {
      // print the call stack if there is an error
      e.printStackTrace();
    }

  }

  /**
   * Formats the {@link CrawlResult} as JSON and writes it to the given {@link Writer}.
   *
   * @param writer the destination where the crawl result data should be written.
   */
  @JsonDeserialize(builder = CrawlResult.Builder.class)

  public void write(Writer writer) throws IOException {
    // This is here to get rid of the unused variable warning.
    Objects.requireNonNull(writer);
    // TODO: Fill in this method.
     ObjectMapper mapper = new ObjectMapper();
    mapper.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
    try {
      mapper.writeValue(writer, result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
