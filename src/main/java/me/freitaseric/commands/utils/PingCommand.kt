package me.freitaseric.commands.utils

import me.freitaseric.database.DatabaseManager
import me.freitaseric.utils.Colors
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

class PingCommand(private val event: SlashCommandInteractionEvent) {
    init {
        val client = event.jda.selfUser
        val gatewayPing: Long = event.jda.gatewayPing
        val interactionPing: Long = event.interaction.timeCreated.toInstant().toEpochMilli() - System.currentTimeMillis()
        val databasePing: Long = DatabaseManager().ping

        val embed = EmbedBuilder().setAuthor(
            event.user.globalName, "https://discord.com/users/${event.interaction.user.id}", event.user.avatarUrl
        )
            .setDescription("My latency is `${interactionPing}ms`.\nGateway latency is `${gatewayPing}ms`.\nDatabase latency is `${databasePing}ms`.")
            .setColor(
                Colors.HONEYDEW.hex
            ).setFooter(client.globalName, client.avatarUrl).setTimestamp(LocalDateTime.now()).build()

        event.replyEmbeds(embed).queue()
    }
}