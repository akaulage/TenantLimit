/**
 * 
 */
package com.example.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myannotations.Limit;

/**
 * @author vivek
 *
 */
@RestController
@RequestMapping("/api")
public class ExampleController {
	
	@GetMapping(path="/limited")
	@Limit
	public ResponseEntity<Object> sampleApi(@RequestParam("tenant") String tenant) {
		return new ResponseEntity<Object>("This is Limited API..!",HttpStatus.OK);
	}
	
	@GetMapping(path="/unlimited")
	public ResponseEntity<Object> sampleunlimitedApi(@RequestParam("tenant") String tenant) {
		return new ResponseEntity<Object>("This is unrestricted API!",HttpStatus.OK);
	}

}
