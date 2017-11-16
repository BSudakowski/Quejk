package pl.akademiakodu.Kwejk.Dao;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.Kwejk.Model.Gif;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface GifRepository extends CrudRepository<Gif, Long> {
    Gif findOneByName(String name);
}
