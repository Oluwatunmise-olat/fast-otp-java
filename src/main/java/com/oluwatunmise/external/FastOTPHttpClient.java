package com.oluwatunmise.external;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FastOTPHttpClient {
  String baseUrl = "https://api.fastotp.co";
  HttpClient httpClient = HttpClient.newHttpClient();

  public HttpResponse<String> sendGetRequest (String uri, String apiKey) throws Exception {
      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI(baseUrl + uri))
          .headers(new String[]{"Content-type", "application/json", "x-api-key", apiKey})
          .GET()
          .build();

      return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
  }

  public HttpResponse<String> sendPostRequest (String uri, String payload, String apiKey) throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI(baseUrl + uri))
        .headers(new String[]{"Content-type", "application/json", "x-api-key", apiKey})
        .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
        .build();

    return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
  }
}
