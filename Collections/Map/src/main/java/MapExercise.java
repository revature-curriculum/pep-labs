
import java.util.Map;

/**
 * Maps are key/value pairs. They are used in situations where we have some value that we'd like
 * to efficiently be able to access, but can be easily identified by some other value.
 * For instance, a dictionary 'key' may be the word and the 'value' may be its definition.
 * Or, if we'd like to keep track of how many times words were used in a book, we could use a word as a 'key'
 * and the amount of times the word appeared as a 'value'.
 *
 * Keys may not be duplicates, but there may be duplicate values in a map.
 *
 * You can read more about HashMap, a very efficient implementation of Map, here:
 * https://www.w3schools.com/java/java_hashmap.asp
 */
public class MapExercise {

    /**
     * Create and instantiate a collection that implements that Map interface, like
     * TreeSet or HashSet. This will be a Map that maps Integer keys to String values.
     * For example, 1:cat, 2:dog, 3:rat, etc.
     *
     * @return a new Map instantiated using Integer keys and String values.
     * Like the other collections problems, Map alone is only an interface. Some common Map implementations are
     * HashMap and TreeMap. Also like the other collections, Map must leverage a wrapper class instead of a primitive,
     * so here Integer is a wrapper for int.
     */
    public Map<Integer, String> createMap(){
        return null;
    }

    /**
     * Get the size of a map. (number of key/value paris)
     * @param map a map to be manipulated.
     * @return the size of map.
     */
    public int getSize(Map<Integer,String> map){
//        return total number of key/value pairs in the map
        return 0;
    }

    /**
     * Insert a key/value pair into a map.
     * @param map a map to be manipulated.
     * @param key the key of the new pair.
     * @param value the value of the new pair.
     * @return nothing, pass by reference will cause changes to the list object to be reflected across the program.
     */
    public void addKeyValuePair(Map<Integer,String> map, int key, String value){
    }

    /**
     * Get a value from a map given a key.
     * @param map a map to be manipulated.
     * @param key the key corresponding to the value we will be retrieving.
     * @return the value associated with key in map.
     */
    public String getValueFromKey(Map<Integer, String> map, int key){
        return "";
    }

    /**
     * Remove a key/value pair from a map.
     * @param map a map to be manipulated.
     * @param key the key corresponding to the pair we will be deleting.
     * @return nothing, pass by reference will cause changes to the list object to be reflected across the program.
     */
    public void removeKeyValuePair(Map<Integer, String> map, int key){
    }

    /**
     * Update the value related to a certain key in a map.
     * @param map a map to be manipulated.
     * @param key the key corresponding to the pair we will be updating.
     * @param value the new value that should be associated with key.
     * @return nothing, pass by reference will cause changes to the list object to be reflected across the program.
     */
    public void overwriteValue(Map<Integer, String> map, int key, String value){

    }
}
