package practice.method_references;

import practice.lambda.Platform;
import practice.lambda.VideoGame;

@FunctionalInterface
public interface VideoGameFactory {
    public VideoGame newGame (String name, double rating, Platform platform);
}
