package Hashmaps;

import java.util.Map;

import java.util.HashMap;

public class HashmapApplication {
  public static String findFirstNonRepeatingCharacter(String text){
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < text.length(); i++){
      var ch = text.charAt(i);
      if(map.containsKey(ch)){
        // update map, if it's repeated use (-1) as it's value
        map.put(ch, -1);
      }else {
        // adding my own custom index (map.size()+1)
        map.put(ch, map.size()+1);
      }
    }
    Character leastRepeated = null;
    int repeatedIndex = text.length();
    for (var item: map.entrySet()){
      // if(item.getValue()
      if(item.getValue()!=-1 && item.getValue() <repeatedIndex ){
        repeatedIndex = item.getValue();
        leastRepeated = item.getKey();
      }  
    }
    return String.valueOf(leastRepeated);
  }
  // Method 2
  public static Character findFirstNoneRepeatingCharacter2(String text){
    Map<Character, Integer> map = new HashMap<>();
    var chars = text.toCharArray();

    for (char ch: chars){
      var count = map.containsKey(ch) ? map.get(ch) : 0;
      map.put(ch, count+1);
    }

    for( var ch: chars){
      if(map.get(ch)==1){
        return ch;
      }
    }
    return null;
  }
}
