package me.freitaseric;

import io.github.cdimascio.dotenv.Dotenv;
import me.freitaseric.listeners.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class StudyBot {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        JDA api = JDABuilder.createDefault(dotenv.get("TOKEN")).build();
        new ReadyListener().init(api);
    }
}