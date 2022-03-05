package com.example.demo;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class FirebaseApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader=FirebaseApplication.class.getClassLoader();
		
		File file=new File(Objects.requireNonNull(classLoader.getResource("serviceaccount.json")).getFile());
				FileInputStream serviceAccount=new FileInputStream(file.getAbsolutePath());	
		@SuppressWarnings("deprecation")
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://fir-sample-965cc-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);
		SpringApplication.run(FirebaseApplication.class, args);
	}

}
