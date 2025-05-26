package TP.GrandMage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonValue;


public class GrandMage {

// Méthode pour construire l'URL de l'API
public String generateUrl(int number, String category, String difficulty) {
    return "https://quizzapi.jomoreschi.fr/api/v1/quiz?limit=" + number +
            "&category=" + category +
            "&difficulty=" + difficulty;
}

// Méthode qui appelle l'API et affiche la réponse
public String fetchQuiz(String apiUrl) {
    StringBuilder response = new StringBuilder();
    try {
        URL url = new URI(apiUrl).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;
        while ((output = br.readLine()) != null) {
            response.append(output);
        }
        conn.disconnect();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return response.toString(); 
}

//Méthode pour Parse le json et renvoter une linkedHashMao
public  LinkedHashMap<String, String> parseJsonReponse(String jsonString) {
JsonObject root = Json.createReader(new StringReader(jsonString)).readObject();
    JsonArray quizzes = root.getJsonArray("quizzes");
     LinkedHashMap<String, String> quizList = new LinkedHashMap<>();

        for (JsonValue quizValue : quizzes) {
        JsonObject quiz = quizValue.asJsonObject();
        String question = quiz.getString("question");
        String answer = quiz.getString("answer");
        quizList.put(question,answer);
    }
        return quizList;
}

public boolean compareResponseToAnswer(String expectedAnswer, String userAnswer) {
    if (expectedAnswer.equalsIgnoreCase(userAnswer)) {
        System.out.println("Bonne réponse !");
        return true;
    } else {
        System.out.println("Mauvaise réponse !");
        return false;
    }
}

public static void writeScore(List<String> content,String name) {
    try {
        Files.write(Paths.get("scores.txt"), content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        System.out.println("Sauvegarde de score de "+name+"Votre score a été sauvegardé dans scores.txt");
    } catch (IOException e) {
        System.out.println("Erreur : " + e.getMessage());
        e.printStackTrace();
    }
}


// Méthode principale qui génère un quiz
public void generateQuiz() {
    ArrayList<String> categories = new ArrayList<>();
    categories.add("tv_cinema");
    categories.add("art_litterature");
    categories.add("musique");
    categories.add("sport");
    categories.add("culture_generale");
    categories.add("jeux_video");

    ArrayList<String> difficulties = new ArrayList<>();
    difficulties.add("facile");
    difficulties.add("normal");
    difficulties.add("difficile");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Bienvenue dans notre quiz ! Quel est votre nom?");
    String name = scanner.nextLine();
    
    System.out.print("Choisissez le nombre de questions : \n");
    int number = scanner.nextInt();
    scanner.nextLine(); 

    System.out.print("Choisissez la catégorie parmis les suivantes :\n ");
    for (int i = 0; i < categories.size(); i++) {
        System.out.println((i + 1) + ". " + categories.get(i));
    }
    int catChoice = scanner.nextInt();
    scanner.nextLine(); 
    String category = categories.get(catChoice - 1);

    System.out.print("Choisissez la difficulté : ");
    for (int i = 0; i < difficulties.size(); i++) {
        System.out.println((i + 1) + ". " + difficulties.get(i));
    }

int diffChoice = scanner.nextInt();
scanner.nextLine(); 
String difficulty = difficulties.get(diffChoice - 1);

String apiUrl = generateUrl(number, category, difficulty);
LinkedHashMap<String, String> quizzes = parseJsonReponse(fetchQuiz(apiUrl));
int points = 0;

System.out.println("Appuyez sur Entrée pour commencer le quiz...");
scanner.nextLine();

for (Map.Entry<String, String> entry : quizzes.entrySet()) {
    System.out.println("Question : " + entry.getKey());
    System.out.print("Votre réponse : ");
    String userAnswer = scanner.nextLine().trim();
    String answer = entry.getValue().trim();
    if (compareResponseToAnswer(answer, userAnswer)) {
        points++;
    }
}
List<String> lines = new ArrayList<>();
lines.add("Score :  " + points);
lines.add(name);
lines.add("Date: "+  LocalDate.now());
writeScore(lines,name);
System.out.println("Quiz terminé ! Vous avez obtenu " + points + " point(s) sur " + quizzes.size() + ".");
scanner.close();
}

public static void main(String[] args) {
    GrandMage gm = new GrandMage();
    gm.generateQuiz();
}
}
