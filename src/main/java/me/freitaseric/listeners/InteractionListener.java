package me.freitaseric.listeners;

import me.freitaseric.commands.utils.PingCommand;
import me.freitaseric.commands.utils.SearchCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.io.IOException;
import java.net.URISyntaxException;

public class InteractionListener extends ListenerAdapter {
    public void init(JDA api) {
        api.addEventListener(this);
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        SlashCommandInteraction interaction = event.getInteraction();

        if (interaction.getName().equals("ping")) {
            PingCommand command = new PingCommand();
            command.run(event);
        }
        if (interaction.getName().equals("search")) {
            SearchCommand command = new SearchCommand();
            try {
                command.run(event);
            } catch (IOException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
