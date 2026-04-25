import java.util.Random;


class Node {
    String card;
    Node next;

    Node(String card) {
        this.card = card;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    void enqueue(String card) {
        Node newNode = new Node(card);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    void display() {
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.card);
            temp = temp.next;
        }
    }
}

class Player {
    String name;
    String[] cards = new String[9];
    Queue queue = new Queue();

    Player(String name) {
        this.name = name;
    }

    void sortCards() {
        String[] order = {"2","3","4","5","6","7","8","9","10",
                          "Jack","Queen","King","Ace"};

        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = 0; j < cards.length - i - 1; j++) {
                if (getRankIndex(cards[j], order) >
                    getRankIndex(cards[j + 1], order)) {

                    String temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
    }

    int getRankIndex(String card, String[] order) {
        String rank = card.split(" ")[0];
        for (int i = 0; i < order.length; i++) {
            if (order[i].equals(rank))
                return i;
        }
        return -1;
    }

    void addToQueue() {
        for (int i = 0; i < cards.length; i++) {
            queue.enqueue(cards[i]);
        }
    }

    void display() {
        System.out.println("\n" + name + " cards:");
        queue.display();
    }
}

public class DeckOfCardsQ5 {
    public static void main(String[] args) {

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
                          "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = new String[52];
        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }

        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int r = rand.nextInt(52);
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

        Player[] players = {
            new Player("Player 1"),
            new Player("Player 2"),
            new Player("Player 3"),
            new Player("Player 4")
        };

        index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i].cards[j] = deck[index++];
            }
        }

          for (int i = 0; i < 4; i++) {
            players[i].sortCards();
            players[i].addToQueue();
            players[i].display();
        }
    }
}