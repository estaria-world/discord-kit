package world.estaria.discordkit.adapter

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import world.estaria.discordkit.channel.DiscordChannelKey

/**
 * @author Niklas Nieberler
 */

abstract class MessageReceivedAdapter(
    private val channelKey: DiscordChannelKey
) : ListenerAdapter() {

    abstract fun executeMessageReceived(event: MessageReceivedEvent, channel: MessageChannel)

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val channel = event.channel
        if (event.member!!.isOwner || channel.id != this.channelKey.getId())
            return

        event.message.delete().queue()
        executeMessageReceived(event, channel)
    }

}