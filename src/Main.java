import java.util.ArrayList;
import java.util.List;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        class Article {
            final String getArticle;
            Article(final String getArticle) {
                this.getArticle = getArticle;
            }
        }

        interface Subscriber {
            public void send(Article){};
        }

        class OfflineSubscriber implements Subscriber {
            private final String address;
            public OfflineSubscriber(final String address) {
                this.address = address;
            }

            @Override
            public void send(){
                System.out.println(article.getArticle+" была доставлена по адресу: "+address);
            }
        }
        class WebSite implements Subscriber{
            private final String url;
            public WebSite(final String url) {
                this.url = url;
            }

            @Override
            public void send(){
                System.out.println(article.getArticle+"опубликована на страничке:  "+address);
            }
            // метод send интерфейса Subscriber должен выводить текст "{article.getArticle} опубликована на страничке: {address}"
        }

        class NewspaperPublisher {

            private final List<Article> articles;

            List<Subscriber> subscriber = new List<>;
            // для отправки статей подписчикам, вам необходимо хранить их в списке
            // создайте пустой список подписчиков List<Subscriber>

            public NewspaperPublisher(final List<Article> articles) {
                this.articles = articles;
            }

            public void subscribe(Subscriber){
                if(List.contains(Subscriber)){
                    subscriber.add(Subscriber);
                }return;
            }
            public void unsubscribe(Subscriber){
                if(List.contains(Subscriber)){
                    subscriber.remove(Subscriber);
                }return;
            }
            public void startWork(){
                Subscriber.send();
            }
            public void publishNewArticle(Article){
                articles.add(Article);
                Subscriber.send(Article);
            }
            // Создайте метод subscribe() принимающий на вход любой объект, реализующий интерфейс Subscriber.
            // При вызове метода subscribe() новый подписчик должен добавляться в список подписчиков.
            // В списке подписчиков не должно быть дубликатов! Вы можете проеверить, есть ли данный подписчик в списке методом List.contains().

            // Создайте метод unsubscribe() принимающий на вход любой объект, реализующий интерфейс Subscriber.
            // При вызове данного метода подписчик должен удаляться из списка подписчиков.

            // Создайте метод startWork().
            // Метод должен отправлять все статьи, которые хранятся в данный момент в списке articles, всем подписчикам из списка.
            // Для отправки используйте метод send() класса Subscriber.

            // Создайте метод publishNewArticle(). Метод принимает на вход объект класса Article.
            // Метод должен добавлять новую статью в список статей articles, а затем рассылать её всем подписчикам из списка.
        }
    }
}