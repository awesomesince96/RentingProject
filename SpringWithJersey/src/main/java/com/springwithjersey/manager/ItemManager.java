package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.Item;
import com.springwithjersey.rest.data.ItemRepository;

@Service
public class ItemManager {

  private @Autowired ItemRepository itemRepository;

  public void createItem(Item item) {
    itemRepository.save(item);
  }

  public Item getItemById(long id) {
    return itemRepository.findById(id);
  }

  public List<Item> getItem() {
    return itemRepository.findAllByStatus(Status.ACTIVE);
  }

  public void deleteItem(long id) {
    long result = itemRepository.deleteById(id);
  }

  public void saveAllItem(List<Item> countries) {
    itemRepository.save(countries);
  }
}
