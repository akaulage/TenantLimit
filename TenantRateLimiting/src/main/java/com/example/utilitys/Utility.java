/**
 * 
 */
package com.example.utilitys;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author vivek
 *
 */
@Component
public class Utility {

	Map<String, String> queryMap = new LinkedHashMap<String, String>();

	public String getTenant(String queryString) throws UnsupportedEncodingException {

		if (queryString != null) {
			String[] pairs = queryString.split("&");

			for (String pair : pairs) {
				int idx = pair.indexOf("=");
				queryMap.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
						URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
			}
		}
		return queryMap.get("tenant");

	}

}
