package pl.akademiakodu.Kwejk.Model;

public class Gif {

    private String url;
    private boolean isFavorite;

    public Gif() {
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
