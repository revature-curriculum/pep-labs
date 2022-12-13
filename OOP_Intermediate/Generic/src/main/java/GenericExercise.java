
/**
 * T here is a generic type.  It can stand in for any kind of object.
 * Here, our objective is to have an object that can store any object in its 'data' field, and then retrieve it.
 * This doesn't seem useful yet, but in a Collection such as ArrayList, you could have a generic
 * array that can store and retrieve many items of any type. This feature is needed for collections, web server
 * technologies, and advanced database interactivity (ORMs).
 *
 * You can read more about generics here: https://www.programiz.com/java-programming/generics
 *
 * For this problem, let's say we just need an Object that is able to manage a single Object of any type - T data.
 * For now, we just need to save and retrieve data.
 *
 * @param <T> a placeholder for any type of object.
 */
public class GenericExercise<T> {
    T data;

    /**
     * Set data to 'in'.
     * @param in an Object that will be of type T at runtime.
     */
    public void loadGenericItem(T in){

    }
    /**
     * @return T data. The type of Data will again be set when the GenericExercise object is created (at runtime).
     */
    public T returnGenericItem(){
        return null;
    }
}
