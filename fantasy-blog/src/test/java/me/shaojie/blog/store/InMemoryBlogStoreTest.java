package me.shaojie.blog.store;

import java.util.List;

import junit.framework.TestCase;
import me.shaojie.blog.Blog;
import me.shaojie.blog.posts.Comment;
import me.shaojie.frame.PagingResult;

public class InMemoryBlogStoreTest extends TestCase {

    protected void setUp() {
        InMemoryBlogStore.getInstance().reset();
    }

    public void testBlogCrudFlow() {
        InMemoryBlogStore store = InMemoryBlogStore.getInstance();

        Blog created = store.createBlog(newBlog("First", "Hello"));
        assertEquals(1, created.getId());
        assertEquals("First", created.getTitle());

        Blog fetched = store.getBlog(created.getId());
        assertNotNull(fetched);
        assertEquals("Hello", fetched.getContent());

        Blog updated = store.updateBlogFields(created.getId(), "Updated", "World", Integer.valueOf(3));
        assertNotNull(updated);
        assertEquals("Updated", updated.getTitle());
        assertEquals("World", updated.getContent());
        assertEquals(3, updated.getType());

        PagingResult<Blog> page = store.listBlogs(0, 10);
        assertEquals(1, page.getTotal());
        assertEquals(1, page.getData().size());

        assertTrue(store.deleteBlog(created.getId()));
        assertNull(store.getBlog(created.getId()));
    }

    public void testCommentCrudFlow() {
        InMemoryBlogStore store = InMemoryBlogStore.getInstance();
        Blog created = store.createBlog(newBlog("ForComment", "Body"));

        Comment draft = new Comment();
        draft.setContent("Nice post");
        Comment saved = store.addComment(created.getId(), draft);

        assertNotNull(saved);
        assertEquals(1, saved.getId());

        List<Comment> comments = store.listComments(created.getId());
        assertEquals(1, comments.size());

        Comment patch = new Comment();
        patch.setContent("Updated comment");
        Comment updated = store.updateComment(created.getId(), saved.getId(), patch);
        assertNotNull(updated);
        assertEquals("Updated comment", updated.getContent());

        assertTrue(store.deleteComment(created.getId(), saved.getId()));
        assertEquals(0, store.listComments(created.getId()).size());

        store.deleteBlog(created.getId());
    }

    public void testUpdateBlogFieldsKeepsExistingValueWhenNull() {
        InMemoryBlogStore store = InMemoryBlogStore.getInstance();
        Blog created = store.createBlog(newBlog("Title", "Body"));

        Blog updated = store.updateBlogFields(created.getId(), null, "NewBody", null);

        assertEquals("Title", updated.getTitle());
        assertEquals("NewBody", updated.getContent());
        assertEquals(0, updated.getType());
    }

    private Blog newBlog(String title, String content) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        return blog;
    }
}
