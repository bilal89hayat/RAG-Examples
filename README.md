User Query
|
v
[Spring Boot Controller]
|
|  Receives query via REST endpoint
v
[RagService / Service Class]
|
|  Prepare request body for Ollama
|  (query text + optional context documents)
v
restTemplate.postForEntity(ollamaUrl, body, Map.class)
|
|  --- SENT TO OLAMA SERVER ---
|  
|  Inside Ollama:
|   1️Converts `queryText` into embedding vector
|   2️Optionally performs retrieval on document vectors
|   3️Generates response text based on context
v
ResponseEntity<Map> response
|
|  Contains generated answer from Ollama
v
RagService extracts response.get("text")
|
v
Returned to User via REST API
