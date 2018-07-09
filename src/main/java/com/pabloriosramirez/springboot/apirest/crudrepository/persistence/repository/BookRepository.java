/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */

package com.pabloriosramirez.springboot.apirest.crudrepository.persistence.repository;


import com.pabloriosramirez.springboot.apirest.crudrepository.persistence.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
