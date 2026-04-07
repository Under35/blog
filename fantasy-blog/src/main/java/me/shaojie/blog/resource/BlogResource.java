package me.shaojie.blog.resource;

import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;

import me.shaojie.blog.Blog;
import me.shaojie.frame.PagingResult;

public class BlogResource extends BaseBlogResource {
    @Override
    protected Representation post(Representation entity) throws ResourceException {
        BlogPayload payload = readPayload(entity, BlogPayload.class);
        if (payload == null || empty(payload.getTitle()) || empty(payload.getContent())) {
            return badRequest("title and content are required");
        }

        Blog blog = new Blog();
        blog.setTitle(payload.getTitle().trim());
        blog.setContent(payload.getContent().trim());
        if (payload.getType() != null) {
            blog.setType(payload.getType().intValue());
        }

        Blog created = STORE.createBlog(blog);
        setStatus(Status.SUCCESS_CREATED);
        return new JacksonRepresentation<Blog>(created);
    }

    @Override
    protected Representation get() throws ResourceException {
        int begin = queryInt("begin", 0);
        int step = queryInt("step", 10);
        PagingResult<Blog> blogs = STORE.listBlogs(begin, step);
        return new JacksonRepresentation<PagingResult<Blog>>(blogs);
    }

    protected static String clean(String raw) {
        if (raw == null) {
            return null;
        }
        String value = raw.trim();
        return value.length() == 0 ? null : value;
    }

    private boolean empty(String raw) {
        return clean(raw) == null;
    }

    public static class BlogPayload {
        private String title;
        private String content;
        private Integer type;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
}
