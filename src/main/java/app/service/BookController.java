package app.service;

import dao.BookOperations;
import dto.bookDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

@SpringBootApplication
@RestController
public class BookController {

    /***************** GET : BookEntity (first on the list/table )
     curl --location --request GET 'http://localhost:8080/book'
     *****************/
    @RequestMapping("/book")
    @ResponseBody
    public ResponseEntity<String> getBook() {
        BookOperations action = new BookOperations();
        return new ResponseEntity<>(action.getBook(), HttpStatus.OK); //200
    }

    /***************** GET : BookEntity by ID
     curl --location --request GET 'http://localhost:8080/bookId?id=3'
     *****************/
    @GetMapping(value = "/bookId", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> fetchBookById(@RequestParam(value = "id") int bookId) {
        BookOperations action = new BookOperations();
        return new ResponseEntity<>(action.fetchBookById(bookId), HttpStatus.OK); //200
    }


    /********** POST (insert) : Send request with
     * mandatory header : String requiredHeaderValue
     * optional header : String optionalHeaderValue
     * requestBody - json {"title":"HowIbuiltThis","authorId":11,"seriesId":6}
     * requestBody has values to be `inserted` in Database
     * responseBody - json  {"title":"HowIbuiltThis","authorId":11,"seriesId":6}
     *
     * **********************************************
     curl --location --request POST 'http://localhost:8080/post' \
     --header 'Content-Type: application/json' \
     --header 'requiredHeaderValue: mandatory-header' \
     --header 'optionalHeaderValue: optional-header' \
     --data-raw '{
     "title": "HowIbuiltThis",
     "authorId": "11",
     "seriesId": "6"
     }'
     **************************************************/
    @PostMapping(path = "/post", consumes = "application/json", produces = "application/json")
    public ResponseEntity<bookDto> postBook(
            @RequestHeader(name = "requiredHeaderValue", required = true) String requiredHeader,
            @RequestHeader(name = "optionalHeaderValue", required = false, defaultValue = "default") String optionalHeader,
            @RequestBody bookDto bookDtoPojo) {
        BookOperations action = new BookOperations();
        action.addBookNew(bookDtoPojo);
        return ResponseEntity.created(URI.create(bookDtoPojo.getTitle())).body(bookDtoPojo); //201
    }

    /*************** PUT (update) : BookEntity by ID
     curl --location --request PUT 'http://localhost:8080/update?id=27' \
     --header 'Content-Type: application/json' \
     --data-raw '{
     "title": "JavaHibernateRest-Now",
     "authorId": "3",
     "seriesId": "8"
     }'
     ***************/
    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<bookDto> updateBook(
            @RequestParam(value = "id") int bookId,
            @RequestBody bookDto bookDtoPojo) {
        BookOperations action = new BookOperations();
        action.updateBookWithId(bookId, bookDtoPojo);
        return ResponseEntity.created(URI.create(String.format(bookDtoPojo.getTitle()))).body(bookDtoPojo); //201
    }

    /********** DELETE : BookEntity by ID
     curl --location --request DELETE 'http://localhost:8080/delete/17'
     *********/
    @DeleteMapping(value = "/delete/{bookId}")
    public ResponseEntity<Integer> deleteBookWithID(@PathVariable int bookId) {
        BookOperations action = new BookOperations();
        int count = action.deleteBook(bookId);
        if (count < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        }
        return new ResponseEntity<>(bookId, HttpStatus.NO_CONTENT); //204
    }

}
