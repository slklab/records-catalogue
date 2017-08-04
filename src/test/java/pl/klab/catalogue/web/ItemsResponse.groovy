package pl.klab.catalogue.web

import com.fasterxml.jackson.annotation.JsonProperty
import pl.klab.catalogue.domain.Item

class ItemsResponse {
    @JsonProperty
    private List<Item> items

    List<Item> getItems() {
        return items
    }

    void setItems(List<Item> items) {
        this.items = items
    }
}
