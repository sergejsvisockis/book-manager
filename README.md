# Book manager
Simple book manager with Oracle transactional even queues under the hood for the message exchange.

## Getting started
1. Setup Oracle database or use an existing instance
2. Run an `init.sql` script located in the project root
3. Run `book-data` app to create schema
4. Run all the remaining services

5. Execute the following request:
```http request
POST http://localhost:8082/api/book
Content-Type: application/json

{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "978-0134686097"
}
```
6. Ensure that the book is created in the `book` table
7. Also ensure that book creation events are in place in the `book_queue` table

An `init.sql` script is intentionally not within the `book-data` module to have more control over the queues management
process.