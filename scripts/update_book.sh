curl -X PUT -d '{"id":"1","title":"Book name update 1","author":"Author update 1","price":111.11}' \
 -H "Content-Type: application/json" "localhost:8080/book/1"