package pl.klab.catalogue.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.klab.catalogue.domain.Item;
import pl.klab.catalogue.domain.ItemType;
import pl.klab.catalogue.persistence.ItemRepository;

import java.util.List;

@RestController
@RequestMapping(value="/items")
public class ItemsController {

    @Autowired
    private ItemRepository repository;

    @RequestMapping(value="/{itemId}", method=RequestMethod.GET)
    public ResponseEntity<Item> getItem(@PathVariable Long itemId) {
        Item itemById = repository.getItemById(itemId);
        return new ResponseEntity(itemById, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = repository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
