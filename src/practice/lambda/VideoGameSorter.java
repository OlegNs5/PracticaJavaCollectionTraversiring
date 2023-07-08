package practice.lambda;

import practice.PracticeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VideoGameSorter {
    public static void main(String[] args) {
        ArrayList<VideoGame> videoGames = PracticeUtils.getVideoGames(); // Am inlocuit lista cu metoda getVideoGames
                                                                            //din clasa PracticeUtils, foarte comod

//        Comparatorul ca o expresie lambda
        videoGames.sort((gameOne, gameTwo) -> Double.compare(gameOne.getRating(), gameTwo.getRating()));

//        System.out.println("Video sortate: "+videoGames);
       /* for (VideoGame videoGame:videoGames) {
            System.out.println(videoGame);
        }*/

        Collections.shuffle(videoGames);
        System.out.println("Jocurile amestecate :"/*+ videoGames*/);
        for (VideoGame jocuriVideo : videoGames) {
            System.out.println(jocuriVideo);
        }

        System.out.println();

        System.out.println("Jocurile sortate:");
//         Comparatorul cu referinta "::" la metoda getRating
        videoGames.sort(Comparator.comparingDouble(VideoGame::getRating));
        for (VideoGame jocuriVideo : videoGames) {
            System.out.println(jocuriVideo);
        }
        Collections.shuffle(videoGames);//Le amestecam din nou

        System.out.println();

        List<VideoGame> videoGameSorted = videoGames
                .stream()
                .sorted(Comparator.comparing(VideoGame::getName))
                .collect(Collectors.toList());

        System.out.println("Sortarea cu sorted:");// Afisam sortarea
        for (VideoGame videoGame:videoGameSorted) {
            System.out.println(videoGame);
        }
    }
}
