package me.shaojie.blog.resource;

import java.util.HashMap;
import java.util.Map;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;

import me.shaojie.blog.Blog;

public class BlogEleResource extends BaseBlogResource {
    @Override
    protected Representation put(Representation entity) throws ResourceException {
        int blogId = requiredIntPath("blog_id");
        BlogResource.BlogPayload payload = readPayload(entity, BlogResource.BlogPayload.class);
        if (payload == null) {
            return badRequest("Request body is required");
        }

        String title = BlogResource.clean(payload.getTitle());
        String content = BlogResource.clean(payload.getContent());
        Integer type = payload.getType();

        if (title == null && content == null && type == null) {
            return badRequest("At least one field (title/content/type) is required");
        }

        Blog updated = STORE.updateBlogFields(blogId, title, content, type);
        if (updated == null) {
            return notFound("Blog not found: " + blogId);
        }

        return new JacksonRepresentation<Blog>(updated);
    }

    @Override
    protected Representation delete() throws ResourceException {
        int blogId = requiredIntPath("blog_id");
        boolean deleted = STORE.deleteBlog(blogId);
        if (!deleted) {
            return notFound("Blog not found: " + blogId);
        }

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("deleted", Boolean.TRUE);
        payload.put("blogId", Integer.valueOf(blogId));
        return new JacksonRepresentation<Map<String, Object>>(payload);
    }

    @Override
    protected Representation get() throws ResourceException {
        int blogId = requiredIntPath("blog_id");
        Blog blog = STORE.getBlog(blogId);
        if (blog == null) {
            return notFound("Blog not found: " + blogId);
        }
        return new JacksonRepresentation<Blog>(blog);
    }
}
