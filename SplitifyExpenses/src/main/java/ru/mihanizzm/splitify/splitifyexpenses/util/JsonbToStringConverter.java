package ru.mihanizzm.splitify.splitifyexpenses.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.mihanizzm.splitify.splitifyexpenses.exception.JsonMappingException;

@Converter(autoApply = true)
public class JsonbToStringConverter implements AttributeConverter<JsonNode, String> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(JsonNode jsonNode) {
        return jsonNode.asText();
    }

    @Override
    public JsonNode convertToEntityAttribute(String s) {
        try {
            return mapper.readTree(s);
        } catch (JsonProcessingException e) {
            throw new JsonMappingException(e.getMessage());
        }
    }
}
