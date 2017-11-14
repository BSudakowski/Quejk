package pl.akademiakodu.Kwejk.Dao;

import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.List;
import java.util.Set;

public interface GifDao {
    List<Gif> findAll();
    List<Gif> findFavorites();

    Gif findOne(String name);
    Set<Gif> findCategory();
}
