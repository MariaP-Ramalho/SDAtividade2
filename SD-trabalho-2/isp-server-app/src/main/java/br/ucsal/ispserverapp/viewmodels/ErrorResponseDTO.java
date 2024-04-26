package br.ucsal.ispserverapp.viewmodels;

import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ErrorResponseDTO {

    private JsonNode error;

    public ErrorResponseDTO(HttpStatusCode httpStatus, String message) {
        var mapper = new ObjectMapper();
        try {
            JsonNode errorMessageNode = mapper.readTree(message);
            if (errorMessageNode.isObject()) {
                ((ObjectNode) errorMessageNode).put("statusCode", httpStatus.value());
                this.error = errorMessageNode;
            } else {
                ObjectNode errorNode = mapper.createObjectNode();
                errorNode.set("message", errorMessageNode);
                errorNode.put("statusCode", httpStatus.value());
                this.error = errorNode;
            }
        } catch (Exception e) {
            ObjectNode errorNode = mapper.createObjectNode();
            errorNode.put("message", message);
            errorNode.put("statusCode", httpStatus.value());
            this.error = errorNode;
        }
    }
    
    public JsonNode getError() {
        return error;
    }

    public void setError(JsonNode error) {
        this.error = error;
    }
}
