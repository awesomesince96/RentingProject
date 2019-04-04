package com.springwithjersey.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.ItemManager;
import com.springwithjersey.model.Item;

@Service
@Transactional
public class ItemService {

  private @Autowired ItemManager itemManager;

  public void createItem(Item item) {
    Date date = java.util.Calendar.getInstance().getTime();
    item.setRegistration(date);
    itemManager.createItem(item);
  }

  public Item getItemById(long id) {
    return itemManager.getItemById(id);
  }

  public List<Item> getItem() {
    return itemManager.getItem();
  }

  public void updateItem(Item item) {
    itemManager.createItem(item);
  }

  public void saveAllItem(List<Item> countries) {
    itemManager.saveAllItem(countries);
  }

  public void deleteItem(long id) {
    itemManager.deleteItem(id);
  }

}
