package com.example.springboot.BookPackage;

import com.example.springboot.Base.FonctionBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookControlleur")
public class BookControlleur {
    @Autowired
    private BookRepository book;

    @GetMapping("/books")
    public List<Book> getAll(){
        return book.findAll();
    }

    @PostMapping("/book")
    public Book createBook(@Validated @RequestBody Book request) throws Exception {
        String sql="insert into requete(request) values('%s')";
        String insert="insert into my_library(book_title,book_author,book_pages) values(\"%s\",\"%s\",\"%s\")";
        insert=String.format(insert,request.getTitle(),request.getAuthor(),request.getPage());
        sql=String.format(sql,insert);
        System.out.println(sql);
        FonctionBase.modifBase(sql);
        return book.save(request);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book>getById(@PathVariable long id){
        Book g=book.findById(id).get();
        return ResponseEntity.ok().body(g);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book>updateBook(@PathVariable long id,@RequestBody Book newBook) throws Exception {
        Book g=book.findById(id).get();
        String sql="insert into requete(request) values('%s')";
        String update="update my_library set book_title=\"%s\",book_author=\"%s\",book_pages=\"%s\" where book_title=\"%s\" and book_author=\"%s\" and book_pages=\"%s\"";
        update=String.format(update,newBook.getTitle(),newBook.getAuthor(),newBook.getPage(),g.getTitle(),g.getAuthor(),g.getPage());
        sql=String.format(sql,update);
        FonctionBase.modifBase(sql);
        g.setTitle(newBook.getTitle());
        g.setAuthor(newBook.getAuthor());
        g.setPage(newBook.getPage());
        book.save(g);
        return ResponseEntity.ok().body(g);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?>delete(@PathVariable long id) throws Exception {
        Book g=book.findById(id).get();
        String sql="insert into requete(request) values('%s')";
        String update="delete from my_library where book_title=\"%s\" and book_author=\"%s\" and book_pages=\"%s\"";
        update=String.format(update,g.getTitle(),g.getAuthor(),g.getPage());
        sql=String.format(sql,update);
        FonctionBase.modifBase(sql);
        book.delete(g);
        return ResponseEntity.ok().build();
    }
}
