package pl.akademiakodu.Kwejk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.Kwejk.Dao.GifRepository;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class GifService {

    @Autowired
    private GifRepository gifRepository;

    public GifService() {

    }

    public void add(Gif gif){
        gifRepository.save(gif);
    }

    public List<Gif> findAll(){
        List<Gif> gifs = new ArrayList<>();
        gifRepository.findAll().forEach((g)->gifs.add(g));
        return gifs;
    }

    public Gif findOneByName(String name){
        return gifRepository.findOneByName(name);
    }

    public Gif findOneByFavorite(Long index){
        Optional<Gif> optional = gifRepository.findById(index);
        return optional.get();
    }
}
