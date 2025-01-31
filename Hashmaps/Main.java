package Hashmaps;

public class Main {
  public static void main(String[] args){
    //  var leastRepeated = HashmapApplication.findFirstNonRepeatingCharacter("hello world");
    //  System.out.println(leastRepeated);
    var hashmap  = new CustomHashMaps();
    hashmap.put(1, "prosper");
    hashmap.put(50, "prosper2");
    hashmap.put(4, "prosper3");
    hashmap.put(150, "prosper4");
    var value = hashmap.get(150);
    System.out.println(value);
  }
}
