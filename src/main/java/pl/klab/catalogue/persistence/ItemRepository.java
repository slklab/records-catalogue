package pl.klab.catalogue.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.klab.catalogue.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item getItemById(Long id);

}
