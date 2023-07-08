package practice;

import practice.lambda.Platform;
import practice.lambda.VideoGame;
import practice.method_references.VideoGameFactory;

import java.util.ArrayList;

public class PracticeUtils {

    public final static  VideoGameFactory videoGameFactory = VideoGame::new; //nu inteleg
    public static ArrayList<VideoGame> getVideoGames(){
        ArrayList<VideoGame> videoGames = new ArrayList<>();
        videoGames.add(new VideoGame("Game1", 7.85, Platform.PC));
        videoGames.add(new VideoGame("Game2", 8.43, Platform.MOBILE));
        videoGames.add(new VideoGame("Game3", 6.7, Platform.PC));
        videoGames.add(new VideoGame("Game4", 9.2, Platform.CONSOLE));
        videoGames.add(new VideoGame("Game5", 9.45, Platform.CONSOLE));
        return videoGames;
    }
    public static ArrayList<VideoGame> getVideoGamesByFactory(){
        ArrayList<VideoGame> videoGames = new ArrayList<>();
        videoGames.add(videoGameFactory.newGame("Game1",7.85, Platform.PC));
        videoGames.add(videoGameFactory.newGame("Game2",8.43, Platform.MOBILE));
        videoGames.add(videoGameFactory.newGame("Game3",6.7, Platform.PC));
        videoGames.add(videoGameFactory.newGame("Game4",9.2, Platform.CONSOLE));
        videoGames.add(videoGameFactory.newGame("Game5",9.45, Platform.CONSOLE));
        return videoGames;
    }
}
