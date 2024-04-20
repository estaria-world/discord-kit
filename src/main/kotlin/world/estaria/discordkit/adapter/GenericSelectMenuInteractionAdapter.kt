package world.estaria.discordkit.adapter

import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

/**
 * @author Niklas Nieberler
 */

abstract class GenericSelectMenuInteractionAdapter(
    private val selectMenuId: String,
) : ListenerAdapter() {

    abstract fun executeGenericSelectMenuInteraction(
        event: GenericSelectMenuInteractionEvent<*, *>,
        textChannel: TextChannel,
        user: User
    )

    override fun onGenericSelectMenuInteraction(event: GenericSelectMenuInteractionEvent<*, *>) {
        val textChannel = event.channel.asTextChannel()
        val user = event.user

        if (event.interaction.selectMenu.id != this.selectMenuId)
            return

        executeGenericSelectMenuInteraction(event, textChannel, user)
    }
}