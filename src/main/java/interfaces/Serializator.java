package interfaces;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public interface Serializator<T> {
    public void serialization(T object);
    public T deserialization(String fileName);
}
