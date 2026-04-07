package me.shaojie.blog.resource;

import java.util.HashMap;
import java.util.Map;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;

import me.shaojie.blog.posts.Comment;

public class BlogCommentEleResource extends BaseBlogResource {
    @Override
    protected Representation put(Representation entity) throws ResourceException {
        int blogId = requiredIntPath("blog_id");
        int commentId = requiredIntPath("cmt_id");
        BlogCommentResource.CommentPayload payload = readPayload(entity, BlogCommentResource.CommentPayload.class);
        String content = BlogResource.clean(payload == null ? null : payload.getContent());
        if (content == null) {
            return badRequest("Comment content is required");
        }

        Comment candidate = new Comment();
        candidate.setContent(content);
        Comment updated = STORE.updateComment(blogId, commentId, candidate);
        if (updated == null) {
            return notFound("Comment not found for blog: " + blogId + ", comment: " + commentId);
        }

        return new JacksonRepresentation<Comment>(updated);
    }

    @Override
    protected Representation delete() throws ResourceException {
        int blogId = requiredIntPath("blog_id");
        int commentId = requiredIntPath("cmt_id");
        boolean deleted = STORE.deleteComment(blogId, commentId);
        if (!deleted) {
            return notFound("Comment not found for blog: " + blogId + ", comment: " + commentId);
        }

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("deleted", Boolean.TRUE);
        payload.put("blogId", Integer.valueOf(blogId));
        payload.put("commentId", Integer.valueOf(commentId));
        return new JacksonRepresentation<Map<String, Object>>(payload);
    }
}
