/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume result= new Resume();
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                result = resume;
                break;
            }
        }
        return result;
    }

    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }
        }
        Resume [] resumeDeleted = new Resume[storage.length-1];
        int index = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                resumeDeleted[index++] = resume;
            }
        }
        storage = resumeDeleted;
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

        }return newStorage;
    }

        int size() {
            int count = 0;
            for (Resume resume : storage) {
                if (resume != null) {
                    count++;
                }
            }

            return count;
        }



}