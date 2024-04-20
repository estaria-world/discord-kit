package world.estaria.discordkit.adapter

import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import world.estaria.discordkit.channel.DiscordChannelKey

/**
 * @author Niklas Nieberler
 */

abstract class ModalInteractionAdapter(
    private val channelKey: DiscordChannelKey
) : ListenerAdapter() {

    abstract fun executeModalInteraction(event: ModalInteractionEvent, channel: MessageChannelUnion)

    override fun onModalInteraction(event: ModalInteractionEvent) {
        val channel = event.channel
        if (channel.id != this.channelKey.getId())
            return
        executeModalInteraction(event, channel)
    }

}