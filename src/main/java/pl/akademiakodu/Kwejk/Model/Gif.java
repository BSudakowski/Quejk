package pl.akademiakodu.Kwejk.Model;

public class Gif {

    private String name;
    private String username;
    private boolean favorites;
    private String category;

    public Gif(String category) {
        this.category = category;
    }

    public Gif(String name, String username, boolean favorites, String category) {
        this.name = name;
        this.username = username;
        this.favorites = favorites;
        this.category = category;
    }

    public Gif(String name, String username, boolean favorites) {
        this.name = name;
        this.username = username;
        this.favorites = favorites;
    }

    public Gif(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public Gif(String name, boolean favorites) {
        this.name = name;
        this.favorites = favorites;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return getName() + ".gif";
    }

    @Override
    public String toString() {
        return "Gif{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", favorites=" + favorites +
                '}';
    }
}