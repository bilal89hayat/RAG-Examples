```mermaid
graph TD
    A[User Query] --> B[Spring Boot Controller]
    B --> C[RagService / Service Class]
    C --> D[Prepare Request Body for Ollama]
    D --> E[REST Call: restTemplate.postForEntity(ollamaUrl, body, Map.class)]
    E --> F[Ollama Server: Embedding + Retrieval + Generation]
    F --> G[ResponseEntity<Map> response]
    G --> H[Extract generated text: response.get("text")]
    H --> I[Return answer to User via REST API]
