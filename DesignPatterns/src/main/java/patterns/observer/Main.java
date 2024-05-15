package patterns.observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        NewsSubscriber alice = new NewsSubscriber("Alice");
        NewsSubscriber bob = new NewsSubscriber("Bob");
        NewsSubscriber carol = new NewsSubscriber("Carol");

        newsAgency.addObserver(alice);
        newsAgency.addObserver(bob);
        newsAgency.addObserver(carol);

        newsAgency.setNews("Breaking News: Observer Pattern Implemented Successfully!");

        newsAgency.removeObserver(bob);
        newsAgency.setNews("Update: Bob unsubscribed from the news.");
    }
}
