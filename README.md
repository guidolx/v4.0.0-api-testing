# v4.0.0-api-testing
Test the new Java SDK API 


##### Exceptions
- Exceptions thrown by the Zitadel API extend the RuntimeException, meaning they do not need to be explicitly caught by the developer in their code. 
- Exceptions have an error code. Does the error code have the same meaning as HTTP status codes?
- The response headers and response body can be retrieved.
- A minor cosmetic improvement for the error message (without considering multiple validation errors):   
	- The exception.getMessage() returns the String "Error 400". For example, it might be more helpful to include the root cause in the exception message, such as for organisation names that are not in the expected range, since the error code can be checked with the exception—getCode():int method. 
	- Nice to have (IMO): com.zitadel.ApiException.getMessage() would return "Error 400:  invalid OrganizationNameQuery.Name: value length must be between 1 and 200 runes, inclusive)
