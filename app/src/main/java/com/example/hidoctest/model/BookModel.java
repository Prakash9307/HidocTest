package com.example.hidoctest.model;

public class BookModel
{

    private String id;
    private String kind;
    private String etag;
    private String title;
    private String subtitle;
    private String author;
    private String publisher;
    private String publishdate;
    private String desc;
    private String image;

    public BookModel(String id, String kind, String etag, String title,
                     String subtitle, String author,String publisher,
                     String publishdate, String desc,String image)
    {
        this.id = id;
        this.kind = kind;
        this.etag = etag;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.publisher = publisher;
        this.publishdate = publishdate;
        this.desc = desc;
        this.image = image;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }
}
