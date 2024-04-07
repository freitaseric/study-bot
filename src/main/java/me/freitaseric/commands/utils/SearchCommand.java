package me.freitaseric.commands.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.Objects;

public class SearchCommand {

    public void run(SlashCommandInteractionEvent event) throws IOException, URISyntaxException, InterruptedException {
        SlashCommandInteraction interaction = event.getInteraction();
        SelfUser client = event.getJDA().getSelfUser();
        String search = Objects.requireNonNull(interaction.getOption("search")).getAsString();
        String link = "https://www.google.com/search?q=" + search;

        MessageEmbed embed = new EmbedBuilder()
                .setAuthor(interaction.getUser().getGlobalName(), interaction.getUser().getAvatarUrl())
                .setTitle("Search Results")
                .setDescription("Your search was be found [here](" + link + ")!")
                .setColor(Color.pink)
                .setFooter(client.getGlobalName(), client.getAvatarUrl())
                .build();

        event.replyEmbeds(embed).addActionRow(
                Button.link(link, Emoji.fromUnicode("🌐"))
        ).queue();
    }
}
