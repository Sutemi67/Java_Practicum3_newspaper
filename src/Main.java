import java.util.ArrayList;
import java.util.List;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        class Article {
            static String getArticle;

            Article(final String getArticle) {
                Article.getArticle = getArticle;
            }
        }

        interface Subscriber {
            public void send();
        }

        class OfflineSubscriber implements Subscriber {
            private final String address;

            public OfflineSubscriber(final String address) {
                this.address = address;
            }

            @Override
            public void send() {
                System.out.println(Article.getArticle + " была доставлена по адресу: " + address);
            }
        }

        class WebSite implements Subscriber {
            private final String url;

            public WebSite(final String url) {
                this.url = url;
            }

            @Override
            public void send() {
                System.out.println(Article.getArticle + " опубликована на страничке:  " + url);
            }
        }

        class NewspaperPublisher {
            private final List<Article> articles;
            List<Subscriber> subscriber = new ArrayList<>();

            public NewspaperPublisher(final List<Article> articles) {
                this.articles = articles;
            }

            public void subscribe(Subscriber subscriber) {
                if (this.subscriber.contains(subscriber)) {
                    return;
                }
                this.subscriber.add(subscriber);
            }

            public void unsubscribe(Subscriber subscriber) {
                if (this.subscriber.contains(subscriber)) {
                    this.subscriber.remove(subscriber);
                }
                return;
            }

            public void startWork() {
                for (Subscriber subscriber : this.subscriber) {
                    subscriber.send();
                }
            }

            public void publishNewArticle(Article articles) {
                this.articles.add(articles);
                for (Subscriber subscriber : this.subscriber) {
                    subscriber.send();
                }
            }
        }
    }
}