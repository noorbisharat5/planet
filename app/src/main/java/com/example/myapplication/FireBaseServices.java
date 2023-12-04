package com.example.myapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;


public class FireBaseServices {
    private static FireBaseServices instance;
    private final FirebaseAuth auth;
    private FirebaseFirestore fire = FirebaseFirestore.getInstance();
    private final FirebaseStorage storage;

    public static FireBaseServices getInstance() {
        if (instance == null)
            instance = new FireBaseServices();
        return instance;
    }

    public FirebaseAuth getAuth() {
        return auth;
    }

    public FirebaseFirestore getFire() {
        return fire;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public FireBaseServices() {
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
    }
}
