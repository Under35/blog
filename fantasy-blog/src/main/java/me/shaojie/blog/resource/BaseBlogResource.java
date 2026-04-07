package me.shaojie.blog.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import me.shaojie.blog.store.InMemoryBlogStore;

public abstract class BaseBlogResource extends ServerResource {
    protected static final InMemoryBlogStore STORE = InMemoryBlogStore.getInstance();

    protected int requiredIntPath(String key) {
        Object raw = getRequestAttributes().get(key);
        if (raw == null) {
            throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Missing path variable: " + key);
        }
        try {
            return Integer.parseInt(raw.toString());
        } catch (NumberFormatException ex) {
            throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Invalid integer path variable: " + key);
        }
    }

    protected int queryInt(String key, int defaultValue) {
        String raw = getQueryValue(key);
        if (raw == null || raw.trim().length() == 0) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(raw);
        } catch (NumberFormatException ex) {
            throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Invalid query parameter: " + key);
        }
    }

    protected <T> T readPayload(Representation entity, Class<T> type) {
        if (entity == null) {
            throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Missing request body");
        }
        try {
            return new JacksonRepresentation<T>(entity, type).getObject();
        } catch (IOException ex) {
            throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Invalid JSON payload", ex);
        }
    }

    protected Representation badRequest(String message) {
        setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
        return message(message);
    }

    protected Representation notFound(String message) {
        setStatus(Status.CLIENT_ERROR_NOT_FOUND);
        return message(message);
    }

    protected Representation message(String message) {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("message", message);
        return new JacksonRepresentation<Map<String, Object>>(payload);
    }
}
