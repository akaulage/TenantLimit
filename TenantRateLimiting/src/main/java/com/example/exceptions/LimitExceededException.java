/**
 * 
 */
package com.example.exceptions;

import org.springframework.stereotype.Component;

/**
 * @author vivek
 *
 */

public class LimitExceededException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LimitExceededException(String msg){
		super(msg);
	}

}
