package pl.klab.catalogue.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.klab.catalogue.domain.Item;
import pl.klab.catalogue.domain.ItemType;
import pl.klab.catalogue.persistence.ItemRepository;

@RestController
@RequestMapping(value="/items")
public class ItemsController {

    @Autowired
    private ItemRepository repository;

    @RequestMapping(value="/{itemId}", method=RequestMethod.GET)
    public HttpEntity<Item> getItem(Long itemId) {
        Item itemById = repository.getItemById(itemId);
        return new ResponseEntity(itemById, HttpStatus.OK);
    }
}
