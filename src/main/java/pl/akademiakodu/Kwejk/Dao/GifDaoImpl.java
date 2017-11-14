package pl.akademiakodu.Kwejk.Dao;

import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.*;
import java.util.stream.Collectors;

public class GifDaoImpl implements GifDao {
    private static List<Gif> names = new ArrayList<>();

    static {
        CategoryDaoImpl dao = new CategoryDaoImpl();
        names.add(new Gif("android-explosion", "Daniel", false, "Android"));
        names.add(new Gif("ben-and-mike", "Daniel", true, "Funny"));
        names.add(new Gif("book-dominos", "Daniel", false, "Programming"));
        names.add(new Gif("compiler-bot", "Kuba", true, "Funny"));
        names.add(new Gif("cowboy-coder", "Kuba", false, "Android"));
        names.add(new Gif("infinite-andrew", "Kuba", true, "Programming"));
    }

    public List<Gif> findAll() {
        List<Gif> gifs = new ArrayList<>();
        for (Gif name : names) {
            gifs.add(new Gif(name.getName(), name.getUsername()));
        }
        return gifs;
    }

    public List<Gif> findCategories() {
        List<Gif> gifs = new ArrayList<>();
        for (Gif name : names) {

            gifs.add(new Gif(name.getCategory()));

        }
        return gifs;
    }

    @Override
    public List<Gif> findFavorites() {
        List<Gif> gifs = new ArrayList<>();
        for (Gif name : names) {
            if (name.isFavorites()) {
                gifs.add(new Gif(name.getName(), name.getUsername(), name.isFavorites()));
            }
        }
        return gifs;
    }

    public Gif findOne(String name) {
        return findAll().stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public Set<Gif> findCategory() {
        Set<Gif> categories = new HashSet<>();
        for (Gif category : names) {
            categories.add(new Gif(category.getCategory()));

        }
        return categories;
    }

}
