package com.rvbrasil.ramengo.ramengo.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiKeyFilter extends OncePerRequestFilter {
  private static final String API_KEY_HEADER = "x-api-key";
  private static final String API_KEY_VALUE = "Gp3Ai6XZ9Q1wYO5stN8r703Dp2BkZYmR4ojLhTdG";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String apiKey = request.getHeader(API_KEY_HEADER);

    if (API_KEY_VALUE.equals(apiKey)) {
      filterChain.doFilter(request, response);
    } else {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");

      Map<String, String> errorResponse = new HashMap<>();
      errorResponse.put("error", "x-api-key header missing or invalid");

      ObjectMapper objectMapper = new ObjectMapper();
      String jsonResponse = objectMapper.writeValueAsString(errorResponse);
      response.getWriter().write(jsonResponse);
    }
  }
}

