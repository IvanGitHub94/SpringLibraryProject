package com.jpcsaturday.SpringLibraryProject;

import com.jpcsaturday.SpringLibraryProject.dbexample.dao.BookDaoJDBC;

import com.jpcsaturday.SpringLibraryProject.dbexample.MyDBConfigContext2;
import com.jpcsaturday.SpringLibraryProject.dbexample.dao.BookDAOBean;
import com.jpcsaturday.SpringLibraryProject.dbexample.dao.BookDaoJDBC;
import com.jpcsaturday.SpringLibraryProject.dbexample.db.DBConnection;
import com.jpcsaturday.SpringLibraryProject.dbexample.model.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringLibraryProjectApplication implements CommandLineRunner {

	public BookDAOBean bookDAOBean;

	//Инжект бина через конструктор
//    public SpringLibraryProjectApplication(BookDAOBean bookDAOBean) {
//        this.bookDAOBean = bookDAOBean;
//    }


	//Инжект бина через сеттер
//    @Autowired
//    public void setEnv(BookDAOBean bookDAOBean) {
//        this.bookDAOBean = bookDAOBean;
//    }

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringLibraryProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Шаг 1 (Большая связность кода)
//        BookDaoJDBC bookDaoJDBC = new BookDaoJDBC();
//        bookDaoJDBC.findBookById(2);

		//Шаг 2 (Сделали BookDAOBean - добавили поле connection)
//        BookDAOBean bookDAOBean = new BookDAOBean(DBConnection.INSTANCE.getConnection());
//        bookDAOBean.findBookById(4);

		//Шаг 3 - работаем со Spring Context
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyDBConfigContext.class);
//        BookDAOBean bookDAOBean = ctx.getBean(BookDAOBean.class);
//        bookDAOBean.findBookById(1);

		//Шаг 4 - для MyDBConfigContext добавляем аннотацию @ComponentScan, удаляем связь на BookDAOBean
		//Добавляем аннотацию @Component для BookDAOBean (на 3 шаги был без аннотации)

		//Финальный шаг
//        bookDAOBean.findBookById(3);

		//JDBC обертка от Spring(зависимость spring-boot-starter-jdbc) -> Работа с темплейтом
        List<Book> bookList = jdbcTemplate.query("select * from books",
                ((rs, rowNum) -> new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDate("date_added")
                )));

        bookList.forEach(System.out::println);

	}
}
