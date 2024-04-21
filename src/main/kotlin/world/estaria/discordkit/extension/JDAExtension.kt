package world.estaria.discordkit.extension

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel
import world.estaria.discordkit.channel.DiscordChannelKey

/**
 * @author Niklas Nieberler
 */
 
fun JDA.getTextChannelById(channelKey: DiscordChannelKey): TextChannel? {
    return channelKey.getId()?.let { this.getTextChannelById(it) }
}