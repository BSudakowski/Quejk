package pl.akademiakodu.Kwejk.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Gif {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private boolean favorites;
    @ManyToOne
    private Category category;

    public Gif() {

    }

    public Gif(String name, String username, boolean favorites, Category category) {
        this.name = name;
        this.username = username;
        this.favorites = favorites;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}