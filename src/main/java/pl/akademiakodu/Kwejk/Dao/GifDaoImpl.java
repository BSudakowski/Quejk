package pl.akademiakodu.Kwejk.Dao;

import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.*;
import java.util.stream.Collectors;

public class GifDaoImpl implements GifDao {

    public static final String name1 = "android-explosion";
    public static final String name2 = "ben-and-mike";
    public static final String name3 = "book-dominos";
    public static final String name4 = "compiler-bot";
    public static final String name5 = "cowboy-coder";
    public static final String name6 = "infinite-andrew";


    private static List<Gif> names = new ArrayList<>();

    static {
        names.add(new Gif("android-explosion", "Masaki", false, "Android"));
        names.add(new Gif("ben-and-mike", "Bartek", true, "Funny"));
        names.add(new Gif("book-dominos", "Masaki", false, "Programming"));
        names.add(new Gif("compiler-bot", "Bartek", true, "Funny"));
        names.add(new Gif("cowboy-coder", "Masaki", false, "Android"));
        names.add(new Gif("infinite-andrew", "Bartek", true, "Programming"));
    }

    public List<Gif> findAll() {
        return names;
        /*
        List<Gif> gifs = new ArrayList<>();
        for (Gif name : names) {
            gifs.add(new Gif(name.getName(), name.getUsername()));
        }
        return gifs;
        */
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
