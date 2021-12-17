
package com.Reto4.repository.crud;

import com.Reto4.model.Product;
import com.Reto4.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface ProductCrudRepository extends MongoRepository<Product, String>{

}
