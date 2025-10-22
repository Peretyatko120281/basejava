/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {

            storage[i] = null;

        }
    }

    void save(Resume r) {

        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Resume result = new Resume();
        for (Resume resume : storage) {
            if (resume != null && resume.uuid.equals(uuid)) {
                result = resume;
            }
        }
        return result;

    }

    void delete(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (storage[i] == storage[size - 1]) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    break;
                }
            }
        }
        size--;
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[storage.length]; // Максимальный размер

        int index = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                newStorage[index++] = resume;
            }

        }
        return newStorage;
    }

    int size() {


        return size;
    }


}