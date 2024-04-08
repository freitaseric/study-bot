package me.freitaseric.commands.utils

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

class PingCommand(private val event: SlashCommandInteractionEvent) {
    init {
        val ping: Long = event.jda.gatewayPing
        event.reply(String.format("Gateway ping is `%sms`!", ping)).queue()
    }
}