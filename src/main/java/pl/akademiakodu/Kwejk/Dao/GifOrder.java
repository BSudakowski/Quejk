package pl.akademiakodu.Kwejk.Dao;

import org.springframework.stereotype.Component;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.ArrayList;
import java.util.List;
@Component

public class GifOrder implements GifDao {

    private List<Gif> gifs = new ArrayList<>();

    public GifOrder(){
        gifs.add(new Gif("gifs/android-explosion.gif", true));
        gifs.add(new Gif("gifs/ben-and-mike.gif", false));
        gifs.add(new Gif("gifs/book-dominos.gif", false));
        gifs.add(new Gif("gifs/compiler-bot.gif", false));
        gifs.add(new Gif("gifs/cowboy-coder.gif", false));
        gifs.add(new Gif("gifs/infinite-andrew.gif", true));

    }

    @Override
    public void addUrl(String url) {

    }

    @Override
    public List<Gif> getGifs() {
        return gifs;
    }
}
