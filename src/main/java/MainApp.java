import jdbc.UserJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        UserJDBCTemplate studentJDBCTemplate = (UserJDBCTemplate) context.getBean("studentJDBCTemplate");
        studentJDBCTemplate.setImgURL("newURL111", 1);
    }
}
