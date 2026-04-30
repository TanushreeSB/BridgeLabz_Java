public class SentenceSearch {
    public static String searchSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is powerful",
            "I love programming",
            "Search algorithms are useful"
        };

        System.out.println(searchSentence(sentences, "programming"));
    }
}