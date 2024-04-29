package dev.patika.librarymanagementsystem;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactor = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactor.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        // add Author
        Author author = new Author();
        author.setName("Ahmet Ümit");
        author.setBirthDate(LocalDate.of(1960, 9, 30));
        author.setCountry("Türkiye");
        entityManager.persist(author);

        // Publisher Adding
        Publisher publisher = new Publisher();
        publisher.setName("Yapı Kredi Yayınları");
        publisher.setAddress("Türkiye");
        publisher.setEstablishmentDate(LocalDate.of(1996,01,01));
        entityManager.persist(publisher);

        // Book Adding
        Book book = new Book();
        book.setName("Sis ve Gece");
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setStock(45);
        book.setPublicationDate(LocalDate.of(1996, 05,05));
        entityManager.persist(book);

        // Category Adding
        Category categoryFiction = new Category();
        categoryFiction.setName("Roman");
        categoryFiction.setDescription("Polisiye");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        categoryFiction.setBookList(bookList);
        entityManager.persist(categoryFiction);

        // BookBorrowing Adding
        BookBorrowing borrowing = new BookBorrowing();
        borrowing.setBorrowerName("Seyma");
        borrowing.setBorrowDate(LocalDate.of(2024, 4, 28));
        borrowing.setReturnDate(LocalDate.of(2024, 5, 28));
        borrowing.setBook(book);
        entityManager.persist(borrowing);


        Category category = new Category();
        category.setName("Roman");
        category.setDescription("Realist");
        entityManager.persist(category);

        Book book2=entityManager.find(Book.class,1);
        List<Category>categoryList=new ArrayList<>();
        categoryList.add(category);
        book.setCategoryList(categoryList);


        entityTransaction.commit();
    }

}
