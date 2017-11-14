package pl.akademiakodu.Kwejk.Dao;

import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.List;

public interface GifDao {

    void addUrl (String url);
    List<Gif> getGifs();
    List<Gif> findOne(String url);
}
