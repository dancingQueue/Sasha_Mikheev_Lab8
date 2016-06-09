package interfaces;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public interface Serializator<T> {
    void serialize(T object);

    T deserialize(String fileName);
}
