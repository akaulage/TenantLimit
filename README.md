# RateLimiting
Rate Limiting Means ability to make sure your API can be used only for X number of times in a particular time period.

This is small POC of Implemeting RateLimiting to Exposed API
Assumed Use case:

1. There are Two tenants tenant1 and tenant2.
2. Two REST APIs "/api/limited" and "/api/unlimited" are exposed.
3. We want to limit no of calls to "/api/limited" so annotated with "@Limit"

How to Run:
1. start Application(This is Spring Boot Application)
2. Hit API "http://localhost:8080/api/limited?tenant=tenant1" will get response for 5 time on sixth attempt will get error msg.
3. Can able to get response unlimited time with  "http://localhost:8080/api/unlimited?tenant=tenant1".
