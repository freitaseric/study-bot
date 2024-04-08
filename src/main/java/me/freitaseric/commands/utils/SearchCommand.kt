package me.freitaseric.commands.utils

import me.freitaseric.utils.Colors
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.SelfUser
import net.dv8tion.jda.api.entities.emoji.Emoji
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction
import net.dv8tion.jda.api.interactions.components.buttons.Button
import java.time.LocalDate

class SearchCommand(private val event: SlashCommandInteractionEvent) {
    init {
        val interaction: SlashCommandInteraction = event.interaction
        val client: SelfUser = event.jda.selfUser
        val search = interaction.getOption("search")
        val link = "https://www.google.com/search?q=${search?.asString}"

        val embed = EmbedBuilder()
            .setAuthor(
                interaction.user.globalName,
                "https://discord.com/users/${event.interaction.user.id}",
                interaction.user.avatarUrl
            )
            .setTitle("Search Results")
            .setDescription("Your search was be found [here]($link)!")
            .setColor(Colors.HONEYDEW.hex)
            .setFooter(client.globalName, client.avatarUrl)
            .setTimestamp(LocalDate.now())
            .build()

        event.replyEmbeds(embed).addActionRow(
            Button.link(link, Emoji.fromUnicode("🌐"))
        ).queue()
    }
}