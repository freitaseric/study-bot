package me.freitaseric.listeners;

import me.freitaseric.commands.PingCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

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
    }
}
