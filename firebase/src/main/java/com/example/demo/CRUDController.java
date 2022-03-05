package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//@RequestMapping("/crypto")
@RestController
public class CRUDController{
	public CRUDService crudService;
	public CRUDController(CRUDService crudService) {
		this.crudService=crudService;	
	}

	@PostMapping("/create")
	public String createCRUD(@RequestBody CRUD crud) throws InterruptedException,ExecutionException{
		return crudService.createCRUD(crud);
	}

	@GetMapping("/get")
	public CRUD getCRUD(@RequestParam String id) throws InterruptedException,ExecutionException{
		return crudService.getCRUD(id);
	}
}