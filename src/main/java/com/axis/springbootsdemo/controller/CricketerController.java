package com.axis.springbootsdemo.controller;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.axis.springbootsdemo.entity.Cricketer;

@RestController
public class CricketerController {
	
	private static ArrayList<Cricketer> crickList;
	static {
		crickList= new ArrayList<>();
		crickList.add(new Cricketer(101,"Suryakumar Yadhav", 111, 41, 8, 6,217.2));
		crickList.add(new Cricketer(102,"Hardik Pandya", 125, 51, 28, 6,207.2));
		crickList.add(new Cricketer(103,"Rohit Sharma", 121, 43, 18, 26,317.2));
		crickList.add(new Cricketer(104,"Virat Kholi", 100, 51, 18, 13,227.2));
		crickList.add(new Cricketer(105,"Dinesh Kumar", 132, 40, 19, 22,237.2));
		
	}
	
	@GetMapping("/message")
	
	public String getMessage() {
		return "Hello... First SpringBoot Project\n G'night!!! It's too late Aishu";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome. Happy to start";
	}
	
	//get all cricketers
	@GetMapping("/cricketers")
		public ArrayList<Cricketer> getCricketer() {
			return crickList;
		}
	
	//getbyid
	
	@GetMapping("/cricketer/{cricketerId}")
	public Cricketer getCricketerById(@PathVariable int cricketerId) {
		for(Cricketer ck:crickList) {
			if(ck.getCricketerId()==cricketerId) {
				return ck;			//return Cricketer if Id is found
			}
		}
		return null;				//return null if Cricketer id not found
	}
	
	@PostMapping("/cricketer")
	public ResponseEntity<String> addCricketer(@RequestBody Cricketer cricketer){
		crickList.add(cricketer);
		return new ResponseEntity<String>("Cricketer Added Successfully", HttpStatus.OK);
				}


	
	}
	


