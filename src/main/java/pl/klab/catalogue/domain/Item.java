package pl.klab.catalogue.domain;

import javax.persistence.*;

@Entity
@Table(name="Items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

//    @Enumerated(EnumType.STRING)
//    @Column(name="item_type")
//    private ItemType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ItemType getType() {
//        return type;
//    }
//
//    public void setType(ItemType type) {
//        this.type = type;
//    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(name, item.name)
             //   .append(type, item.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(name)
             //   .append(type)
                .toHashCode();
    }
}
