package pl.akademiakodu.Kwejk.Dao;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.Kwejk.Model.Category;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findOneByName(String name);
}
