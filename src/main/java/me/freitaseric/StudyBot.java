package me.freitaseric;

import io.github.cdimascio.dotenv.Dotenv;
import me.freitaseric.database.DatabaseManager;
import me.freitaseric.listeners.InteractionListener;
import me.freitaseric.listeners.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;


public class StudyBot {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        JDA api = JDABuilder.createDefault(dotenv.get("TOKEN")).build();
        DatabaseManager db = new DatabaseManager();

        api.updateCommands().addCommands(Commands.slash("ping", "Returns the bot latency"), Commands.slash("search", "Make a search in google").addOption(OptionType.STRING, "search", "Your search goes here", true)).queue();

        new InteractionListener().init(api);
        new ReadyListener().init(api);
    }
}