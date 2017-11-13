package pl.akademiakodu.Kwejk.Dao;

import org.springframework.stereotype.Component;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.ArrayList;
import java.util.List;
@Component

public class GifOrder implements GifDao {

    private List<Gif> gifs = new ArrayList<>();

    public GifOrder(){
        gifs.add(new Gif("gifs/android-explosion.gif", true, "0"));
        gifs.add(new Gif("gifs/ben-and-mike.gif", false, "1"));
        gifs.add(new Gif("gifs/book-dominos.gif", false, "2"));
        gifs.add(new Gif("gifs/compiler-bot.gif", false, "3"));
        gifs.add(new Gif("gifs/cowboy-coder.gif", false, "4"));
        gifs.add(new Gif("gifs/infinite-andrew.gif", true, "5"));

    }

    @Override
    public void addUrl(String url) {

    }

    @Override
    public List<Gif> getGifs() {
        return gifs;
    }
}
