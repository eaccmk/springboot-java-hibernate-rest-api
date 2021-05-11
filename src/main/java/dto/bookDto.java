package dto;

public class bookDto {

    private String title;
    private int authorId;
    private int seriesId;

    public String getTitle() {return title; }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public int getSeriesId() {
        return seriesId;
    }
    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }
}
