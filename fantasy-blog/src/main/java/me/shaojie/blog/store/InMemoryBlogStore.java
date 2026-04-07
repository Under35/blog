package me.shaojie.blog.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import me.shaojie.blog.Blog;
import me.shaojie.blog.posts.Comment;
import me.shaojie.frame.PagingResult;

public class InMemoryBlogStore {
    private static final InMemoryBlogStore INSTANCE = new InMemoryBlogStore();

    private final Map<Integer, Blog> blogs = new HashMap<Integer, Blog>();
    private final Map<Integer, List<Comment>> commentsByBlog = new HashMap<Integer, List<Comment>>();

    private int nextBlogId = 1;
    private int nextCommentId = 1;

    private InMemoryBlogStore() {
    }

    public static InMemoryBlogStore getInstance() {
        return INSTANCE;
    }

    public synchronized void reset() {
        blogs.clear();
        commentsByBlog.clear();
        nextBlogId = 1;
        nextCommentId = 1;
    }

    public synchronized Blog createBlog(Blog input) {
        Blog blog = cloneBlog(input);
        blog.setId(nextBlogId++);
        long now = System.currentTimeMillis();
        blog.setCreatetime(now);
        blog.setUpdatetime(now);
        blogs.put(blog.getId(), blog);
        commentsByBlog.put(blog.getId(), new LinkedList<Comment>());
        return cloneBlog(blog);
    }

    public synchronized Blog getBlog(int id) {
        Blog blog = blogs.get(Integer.valueOf(id));
        if (blog == null) {
            return null;
        }
        return cloneBlog(blog);
    }

    public synchronized PagingResult<Blog> listBlogs(int begin, int step) {
        List<Blog> sorted = new ArrayList<Blog>(blogs.values());
        Collections.sort(sorted, new Comparator<Blog>() {
            public int compare(Blog left, Blog right) {
                if (left.getId() == right.getId()) {
                    return 0;
                }
                return left.getId() < right.getId() ? 1 : -1;
            }
        });

        PagingResult<Blog> result = new PagingResult<Blog>();
        if (begin < 0) {
            begin = 0;
        }
        result.setBegin(begin);
        result.setTotal(sorted.size());

        if (step <= 0) {
            step = 10;
        }

        int end = begin + step;
        if (end > sorted.size()) {
            end = sorted.size();
        }

        int i;
        for (i = begin; i < end; i++) {
            result.addData(cloneBlog(sorted.get(i)));
        }

        return result;
    }

    public synchronized Blog updateBlogFields(int id, String title, String content, Integer type) {
        Blog current = blogs.get(Integer.valueOf(id));
        if (current == null) {
            return null;
        }

        if (title != null) {
            current.setTitle(title);
        }
        if (content != null) {
            current.setContent(content);
        }
        if (type != null) {
            current.setType(type.intValue());
        }
        current.setUpdatetime(System.currentTimeMillis());
        return cloneBlog(current);
    }

    public synchronized boolean deleteBlog(int id) {
        Blog removed = blogs.remove(Integer.valueOf(id));
        commentsByBlog.remove(Integer.valueOf(id));
        return removed != null;
    }

    public synchronized List<Comment> listComments(int blogId) {
        if (!blogs.containsKey(Integer.valueOf(blogId))) {
            return null;
        }
        List<Comment> comments = commentsByBlog.get(Integer.valueOf(blogId));
        List<Comment> result = new LinkedList<Comment>();
        int i;
        for (i = 0; i < comments.size(); i++) {
            result.add(cloneComment(comments.get(i)));
        }
        return result;
    }

    public synchronized Comment addComment(int blogId, Comment input) {
        if (!blogs.containsKey(Integer.valueOf(blogId))) {
            return null;
        }
        List<Comment> comments = commentsByBlog.get(Integer.valueOf(blogId));
        Comment comment = cloneComment(input);
        comment.setId(nextCommentId++);
        comment.setCreatetime(System.currentTimeMillis());
        comments.add(comment);
        return cloneComment(comment);
    }

    public synchronized Comment updateComment(int blogId, int commentId, Comment input) {
        if (!blogs.containsKey(Integer.valueOf(blogId))) {
            return null;
        }
        List<Comment> comments = commentsByBlog.get(Integer.valueOf(blogId));
        int i;
        for (i = 0; i < comments.size(); i++) {
            Comment each = comments.get(i);
            if (each.getId() == commentId) {
                if (input.getContent() != null) {
                    each.setContent(input.getContent());
                }
                return cloneComment(each);
            }
        }
        return null;
    }

    public synchronized boolean deleteComment(int blogId, int commentId) {
        if (!blogs.containsKey(Integer.valueOf(blogId))) {
            return false;
        }
        List<Comment> comments = commentsByBlog.get(Integer.valueOf(blogId));
        int i;
        for (i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId() == commentId) {
                comments.remove(i);
                return true;
            }
        }
        return false;
    }

    private Blog cloneBlog(Blog source) {
        Blog blog = new Blog();
        blog.setId(source.getId());
        blog.setAuthor(source.getAuthor());
        blog.setTitle(source.getTitle());
        blog.setType(source.getType());
        blog.setCreatetime(source.getCreatetime());
        blog.setUpdatetime(source.getUpdatetime());
        blog.setContent(source.getContent());
        return blog;
    }

    private Comment cloneComment(Comment source) {
        Comment comment = new Comment();
        comment.setId(source.getId());
        comment.setCreator(source.getCreator());
        comment.setCreatetime(source.getCreatetime());
        comment.setContent(source.getContent());
        return comment;
    }
}
