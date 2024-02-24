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
            void send(Article article);
        }
        class OfflineSubscriber implements Subscriber {
            private final String address;

            public OfflineSubscriber(final String address) {
                this.address = address;
            }

            @Override
            public void send(Article article) {
                System.out.println(Article.getArticle + " была доставлена по адресу: " + address);
            }
        }

        class WebSite implements Subscriber {
            private final String url;

            public WebSite(final String url) {
                this.url = url;
            }

            @Override
            public void send(Article article) {
                System.out.println(Article.getArticle + " опубликована на страничке:  " + url);
            }
        }

        class NewspaperPublisher {
            private final List<Article> articles;
            final List<Subscriber> subscribers = new ArrayList<>();

            public NewspaperPublisher(final List<Article> articles) {
                this.articles = articles;
            }

            public void subscribe(Subscriber subscriber) {
                if (this.subscribers.contains(subscriber)) {
                    return;
                }
                this.subscribers.add(subscriber);
            }

            public void unsubscribe(Subscriber subscriber) {
                this.subscribers.remove(subscriber);
            }

            public void startWork() {
                for (Article article : this.articles) {
                    for (Subscriber subscriber : this.subscribers) {
                        subscriber.send(article);
                    }
                }
            }

            public void publishNewArticle(Article article) {
                this.articles.add(article);
                for (Subscriber subscriber : this.subscribers) {
                    subscriber.send(article);
                }
            }
        }
    }
}