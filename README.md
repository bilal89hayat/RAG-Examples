```mermaid
graph TD
    A[User Query] --> B[Spring Boot Controller]
    B --> C[RagService / Service Class]
    C --> D[Prepare Request Body for Ollama]
    D --> E[REST Call to Ollama Server]
    E --> F[Ollama: Embedding + Retrieval + Generation]
    F --> G[ResponseEntity<Map> response]
    G --> H[Extract generated text from response]
    H --> I[Return answer to User via REST API]
