package entity;

public class Blog {
    public String BlogID;
    public String title;
    public String description;
    public String content;
    public String thumbnail;
    public String views;
    public String created_by;
    public String created_at;
    public String admin_name;
    public String is_verified;

    public Blog(String id, String title, String description, String content, String thumbnail, String views, String created_by, String created_at) {
        this.BlogID = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.thumbnail = thumbnail;
        this.views = views;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    public Blog(String blogID, String title, String description, String content, String thumbnail, String views, String created_by, String created_at, String admin_name) {
        BlogID = blogID;
        this.title = title;
        this.description = description;
        this.content = content;
        this.thumbnail = thumbnail;
        this.views = views;
        this.created_by = created_by;
        this.created_at = created_at;
        this.admin_name = admin_name;
    }

    public Blog(String blogID, String title, String description, String content, String thumbnail, String views, String created_by, String created_at, String admin_name, String is_verified) {
        BlogID = blogID;
        this.title = title;
        this.description = description;
        this.content = content;
        this.thumbnail = thumbnail;
        this.views = views;
        this.created_by = created_by;
        this.created_at = created_at;
        this.admin_name = admin_name;
        this.is_verified = is_verified;
    }
}
