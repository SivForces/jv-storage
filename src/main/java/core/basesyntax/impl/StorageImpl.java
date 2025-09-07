package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    final private K[] keys = (K[]) new Object[10];
    final private V[] values = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        int check = 0;
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null && keys[i].equals(key)) {
                check = 1;
                values[i] = value;
            }
        }
        if(check == 0) {
            for (int j = 0; j < keys.length; j++) {
                if(keys[j] == null) {
                    keys[j] = key;
                    values[j] = value;
                    break;
                }
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int k = 0; k < keys.length; k++) {
            if(keys[k] == null) {
                return k;
            }
        }
        return 10;
    }
}
