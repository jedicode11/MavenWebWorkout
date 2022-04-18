package webworkout.project.dao;

public interface Identifiable<K> {
    K getId();
    void setId(K id);
}
