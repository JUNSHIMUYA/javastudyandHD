import com.pojo.Books;
import com.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void test()
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       BookService bookService =(BookService) context.getBean("BookServiceimpl");
       for(Books books:bookService.queryAllBook())
       {
           System.out.println(books);
       }
    }
}
