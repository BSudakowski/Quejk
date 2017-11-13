package pl.akademiakodu.Kwejk.Model;

public class Gif {

    private String url;
    private boolean isFavorite;
    private String id;

    public Gif() {
    }

    public Gif(String url, boolean isFavorite, String id) {
        this.url = url;
        this.isFavorite = isFavorite;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gif(String url, boolean isFavorite) {

        this.url = url;
        this.isFavorite = isFavorite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
