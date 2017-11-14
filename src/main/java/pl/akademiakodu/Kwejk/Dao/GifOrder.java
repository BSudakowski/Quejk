package pl.akademiakodu.Kwejk.Dao;

import org.springframework.stereotype.Component;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component

public class GifOrder implements GifDao {

    private List<Gif> gifs = new ArrayList<>();

    public GifOrder(){
        gifs.add(new Gif("android-explosion", true));
        gifs.add(new Gif("ben-and-mike", false));
        gifs.add(new Gif("book-dominos", false));
        gifs.add(new Gif("compiler-bot", false));
        gifs.add(new Gif("cowboy-coder", false));
        gifs.add(new Gif("infinite-andrew", true));
    }

    @Override
    public void addUrl(String url) {

    }

    @Override
    public List<Gif> getGifs() {
        return gifs;
    }

    @Override
    public List<Gif> findOne(String url) {
        return gifs.stream().filter((g)->g.getUrl().equals(url)).collect(Collectors.toList());
    }
}