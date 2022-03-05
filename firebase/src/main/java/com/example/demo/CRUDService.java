package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import com.google.cloud.firestore.WriteResult;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class CRUDService {	
	public String createCRUD(CRUD crud) throws ExecutionException,InterruptedException{
		Firestore dbFirestore=FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture=dbFirestore.collection("crud_user").document(crud.getId()).set(crud);
		return "user registered successfully"+collectionsApiFuture.get().getUpdateTime().toString();
		}
	
	public CRUD getCRUD(String id) throws ExecutionException,InterruptedException{
		Firestore dbFirestore=FirestoreClient.getFirestore();
		DocumentReference documentReference=dbFirestore.collection("crud_user").document(id);
		ApiFuture<DocumentSnapshot>future=documentReference.get();
		DocumentSnapshot document=future.get();
		CRUD crud;
		if(document.exists()) {
			crud=document.toObject(CRUD.class);
			return crud;
		}
return null;
	}
}