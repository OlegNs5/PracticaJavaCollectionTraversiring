package practice.method_references;

import practice.PracticeUtils;
import practice.lambda.Platform;
import practice.lambda.VideoGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

public class MethodReferences {
    public static void main(String[] args) {
        ArrayList<VideoGame> videoGames = PracticeUtils.getVideoGamesByFactory();

        StringBuilder gameNames= new StringBuilder();
        for (VideoGame videoGame : videoGames) {
            gameNames.append(videoGame.getName()).append(", ");
        }
        String finalTouchesGameNames = gameNames.substring(0,gameNames.toString().length()-2);
        System.out.println("Numele jocurilor este: " +finalTouchesGameNames);

//                Aceasi procedura ca de mai sus executata cu pipelines
//                                    ↓
        String videoGamesNames = videoGames.stream()
                .map(VideoGame::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Numele jocurilor cu joining: "+videoGamesNames);
        System.out.println();

        HashMap<Integer, VideoGame> videoGameHashMap = new HashMap<>();
        VideoGameFactory videoGameFactory = VideoGame::new;
        double rangeMin = 5;
        double ramgeMax = 10;
        for (int i = 0; i < 5; i++) {
            videoGameHashMap.put(i+1,videoGameFactory.newGame("Game" + (i+1),
                    rangeMin+(ramgeMax-rangeMin)* new Random().nextDouble(), Platform.PC) );
        }
     /*   System.out.println("Adaugam cinci perechi de jocuri cu HashMap: " +videoGameHashMap);
        System.out.println();
        for (Map.Entry<Integer,VideoGame> videoGameEntry:videoGameHashMap.entrySet()) {
            if (videoGameEntry.getValue().getRating()<7){
                videoGameEntry.getValue().setRating(7);
            }
        }
        System.out.println("Inlocuim jocurile cu ratingurile mai mici decit 7 cu 7: " +videoGameHashMap);

        videoGameHashMap.replaceAll((key, value) -> {
            if (value.getRating() < 7) {
                value.setRating(6);
            }
            return value;
        });
        System.out.println("Inlocuim cu replaceAll"+videoGameHashMap);*/

        videoGameHashMap.replaceAll((key, value) -> value.getRating() < 7 ? videoGameFactory
                .newGame(value.getName(), 7,value.getPlatform()) :
                value);
        System.out.println("replaceALL cu lamda in pipeLine: "+videoGameHashMap);
    }
}
