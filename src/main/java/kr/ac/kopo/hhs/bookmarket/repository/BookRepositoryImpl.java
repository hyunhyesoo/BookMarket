package kr.ac.kopo.hhs.bookmarket.repository;

import com.sun.nio.sctp.IllegalReceiveException;
import kr.ac.kopo.hhs.bookmarket.domain.Book;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl(){
        Book book1 = new Book();
        book1.setBookId("isbn1001");
        book1.setName("스프링 부트 완전정복");
        book1.setDescription("스프링 부트는 스프링을 기반으로 쉽고 빠르게 웹 애플리케이션을 개발할 수 있는 도구이다." +
                "이 책에서는 스프링 부트의 기본 개념을 쉽게 이해하고 다양한 실습 예제로 빠르게 익힐 수 있다." +
                "그리고 단계별 실습을 따라 하다 보면 도서 쇼핑몰 구축 프로젝트를 완성할 수 있다." +
                "개념-실습-프로젝트의 3단계 학습으로 스프링 부트를 제대로 익힌다면 개발 시간을 단축하고 생산성을 높일 수 있는 개발자로 성장할 수 있다.");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT전문서");
        book1.setAuthor("송미영");
        book1.setUnitPrice(new BigDecimal(35000));
        book1.setReleaseDate("2024/12/31");
        book1.setFileName("isbn1001.png");

        Book book2 = new Book();
        book2.setBookId("isbn1002");
        book2.setName("데이터베이스 개론");
        book2.setDescription("데이터베이스 하이루방가방가.");
        book2.setPublisher("한빛아카데미");
        book2.setCategory("IT교육교재");
        book2.setAuthor("이연희");
        book2.setUnitPrice(new BigDecimal(29000));
        book2.setReleaseDate("2022/01/15");
        book2.setFileName("isbn1002.png");

        Book book3 = new Book();
        book3.setBookId("isbn1003");
        book3.setName("다녀왔습니다!: 실리콘밸리, 워싱턴 D.C. 그리고 텍사스");
        book3.setDescription("“토스증권이 대신 다녀왔습니다, 미국 주식의 심장부에!”\n" +
                "혁신의 중심-실리콘밸리, 정책의 중심-워싱턴 D.C., 미래 산업의 중심-텍사스\n" +
                "기업과 사람을 만나고 현장에서 직접 발견한 투자 인사이트!");
        book3.setPublisher("비즈니스북스");
        book3.setCategory("경제,경영");
        book3.setAuthor("토스증권 리서치센터");
        book3.setUnitPrice(new BigDecimal(18000));
        book3.setReleaseDate("2026/03/23");
        book3.setFileName("isbn1003.png");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);

    }
    @Override
    public List<Book> getAllBookList(){
        return listOfBooks;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<Book>();
        for (Book searchBook : listOfBooks) {
            if (category.equalsIgnoreCase(searchBook.getCategory()))
                booksByCategory.add(searchBook);
        }

        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<String> booksByFiler = filter.keySet();

        if (booksByFiler.contains("publisher")){
            for (String publisherName : filter.get("publisher")){
                for (Book searchBook : listOfBooks){
                    if (publisherName.equalsIgnoreCase(searchBook.getPublisher()))
                        booksByPublisher.add(searchBook);
                }
            }
        }

        if (booksByFiler.contains("category")){
            for (String category : filter.get("category")){
                List<Book> list = getBookListByCategory(category);
                booksByCategory.addAll(list);
            }
        }

        booksByCategory.retainAll(booksByPublisher);


        return booksByCategory;
    }

    @Override
    public Book getBookById(String bookId) {
        Book book = null;
        for (Book searchBook: listOfBooks) {
            if(searchBook != null && searchBook.getBookId() != null && searchBook.getBookId().equals(bookId)){
                book = searchBook;
                break;
            }
        }

        if (book == null) {
            throw new IllegalArgumentException("도서ID가 " + bookId + "인 도서는 찾을 수가 없습니다.");
        }

        return book;
    }

    @Override
    public void setNewBook(Book book) {
        listOfBooks.add(book);
    }
}
