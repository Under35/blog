package me.shaojie.blog.resource;

import java.util.List;

import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;

import me.shaojie.blog.posts.Comment;

public class BlogCommentResource extends BaseBlogResource {
    @Override
    protected Representation get() throws ResourceException {
        int blogId = requiredIntPath("blog_id");
        List<Comment> comments = STORE.listComments(blogId);
        if (comments == null) {
            return notFound("Blog not found: " + blogId);
        }
        return new JacksonRepresentation<List<Comment>>(comments);
    }

    @Override
    protected Representation post(Representation entity) throws ResourceException {
        int blogId = requiredIntPath("blog_id");
        CommentPayload payload = readPayload(entity, CommentPayload.class);
        String content = BlogResource.clean(payload == null ? null : payload.getContent());
        if (content == null) {
            return badRequest("Comment content is required");
        }

        Comment comment = new Comment();
        comment.setContent(content);

        Comment created = STORE.addComment(blogId, comment);
        if (created == null) {
            return notFound("Blog not found: " + blogId);
        }

        setStatus(Status.SUCCESS_CREATED);
        return new JacksonRepresentation<Comment>(created);
    }

    public static class CommentPayload {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
