package pl.klab.catalogue.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.klab.catalogue.domain.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    Item getItemById(Long id);

}
