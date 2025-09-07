package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_SIZE = 10;
    private final K[] keys = (K[]) new Object[ARRAY_SIZE];
    private final V[] values = (V[]) new Object[ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        int check = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null && values[i] != null) {
                check = 1;
                values[i] = value;
                return;
            } else if (keys[i] != null && keys[i].equals(key)) {
                check = 1;
                values[i] = value;
                return;
            }
        }
        if (check == 0) {
            for (int j = 0; j < keys.length; j++) {
                if (keys[j] == null) {
                    keys[j] = key;
                    values[j] = value;
                    return;
                }
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int sizeLength = 0;
        for (int k = 0; k < keys.length; k++) {
            if (keys[k] == null && values[k] == null) {
            } else if (keys[k] != null) {
                sizeLength = sizeLength + 1;
            }
        }
        return sizeLength;
    }
}
