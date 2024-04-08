package me.freitaseric.commands.utils;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PingCommand {
    public void run(SlashCommandInteractionEvent event) {
        long ping = event.getJDA().getGatewayPing();
        event.reply(String.format("Gateway ping is `%sms`!", ping)).setEphemeral(true).queue();
    }
}
