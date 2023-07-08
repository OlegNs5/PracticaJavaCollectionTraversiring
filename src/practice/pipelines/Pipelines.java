package practice.pipelines;

import practice.PracticeUtils;
import practice.lambda.Platform;
import practice.lambda.VideoGame;

import java.util.*;
import java.util.stream.Collectors;

public class Pipelines {
    public static void main(String[] args) {
        ArrayList<VideoGame> videoGames = PracticeUtils.getVideoGames();

        System.out.println("Jocurile mai mare decit 7");
        videoGames.stream()
                .filter(videoGame -> videoGame.getRating() > 7)
                .forEach(System.out::println);

        Optional<VideoGame> optionalMinVideoGame = videoGames.stream()
                .min(Comparator.comparing(VideoGame::getRating));
        /*if(optionalVideoGame.isPresent()) {
            System.out.println("Jocul cu cel mai mic rating este: " + optionalVideoGame.get().getRating());
            //Aceata expresie mai eleganta ↓
        }*/                              //↓
        optionalMinVideoGame.ifPresent(videoGame -> System.out.println("Jocul cu cel mai mic rating este: " + videoGame.getName() + " cu ratingul " + videoGame.getRating()));

        Optional<VideoGame> optionalMaxVideoGame1 = videoGames.stream()
                .max(Comparator.comparing(VideoGame::getRating));

        optionalMaxVideoGame1.ifPresent(videoGame -> System.out.println("Jocul cu cel mai mare rating este: " + videoGame.getName() + " cu ratingul " + videoGame.getRating()));


        Optional<VideoGame> optionalMidleVideoGame1 = videoGames.stream()
                .max(Comparator.comparing(VideoGame::getRating));
        optionalMidleVideoGame1.ifPresent(videoGame -> System.out.println("Jocul cu cel mai mare rating este: " + videoGame.getRating()));

        //media ratingului
        double average = videoGames.stream()
                .filter(averageRating -> averageRating.getRating() < 20)
                .mapToDouble(averageRating -> averageRating.getRating())
                .average()
                .getAsDouble();

        System.out.println("Media ratingurilor este: " + average);

        long gameLong = videoGames.stream()
                .filter(videoGame -> videoGame.getRating() > 9)
                .count();
        System.out.println("Numarul jocurilor cu rating mai mare decit 9 este: " + gameLong);

        DoubleSummaryStatistics statistics = videoGames
                .stream()
                .mapToDouble(VideoGame::getRating)
                .summaryStatistics();
        System.out.println();
        System.out.println("Media ratingurilor: " + statistics.getAverage());
        System.out.println("Cel mic rating: " + statistics.getMin());
        System.out.println("Cel mai mare rating: " + statistics.getMax());
        System.out.println("Numarul total de jocuri: " + statistics.getCount());

        List<String> videoGameNames = videoGames.stream()
                .filter(videoGame -> videoGame.getPlatform().equals(Platform.PC))
                .map(VideoGame::getName)
                .collect(Collectors.toList());

        System.out.println("Colectia de nume a tuturor jocurilor este: ");

        for (String videoGame : videoGameNames) {
            System.out.println(videoGame);
        }

    }
}
