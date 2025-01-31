package Hashmaps;

import java.security.KeyException;
import java.util.LinkedList;

public class CustomHashMaps {
  int size = 100;
  LinkedList<Entry>[] elements;
  public CustomHashMaps(){
    this.elements =  new LinkedList[size];
  }    
  public void put(int k, String v){
    var index = hash(k);
    if(elements[index]==null){
      var entry = new Entry(k, v);
      var list  = new LinkedList<Entry>();
      list.add(entry);
      elements[index] =  list;
    }else {
      var bucket = elements[index];
      for (var entry: bucket){
        if(entry.key == k){
          entry.value = v;
          return ;
        } 
      }
      var entry = new Entry(k, v);
      elements[index].add(entry);
    }
  }
  public String get(int k) {
    var index = hash(k);
    if(elements[index]==null){
      // element wasn't found 
      return null;
    }
    for (int i=0; i < elements[index].size(); i ++){
      var entry = elements[index].get(i);
      if(entry.key==k){
        return entry.value;
      }
    }
    return null;
  }
  public void remove(int k){
    var index = hash(k);
    if(elements[index]==null){
      // does not exists
    }
    if(elements[index].size()==1){
      elements[index] = null;
    }
    for (int i=0; i < elements[index].size(); i ++){
      var entry = elements[index].get(i);
      if(entry.key==k){
        elements[index].remove(i);
        break;
      }
    }
  }
  // hash function
  private int hash(int k){
    return k % size;
  }
}
