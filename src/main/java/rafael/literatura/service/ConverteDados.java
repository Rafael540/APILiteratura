package rafael.literatura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rafael.literatura.service.IConverteDados;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        // Add check for empty or null string before attempting to read
        if (json == null || json.trim().isEmpty()) {
            System.err.println("Error: Input JSON string is null or empty. Cannot map data.");
            return null; // Return null, or throw a more specific application exception if needed
        }

        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            // It's usually better to log the actual input that failed to parse
            System.err.println("Error processing JSON for class " + classe.getSimpleName() + ": " + e.getMessage());
            // Optionally, log the problematic JSON string: System.err.println("Failing JSON: " + json);
            throw new RuntimeException("Failed to convert JSON to " + classe.getSimpleName(), e);
        }
    }
}
