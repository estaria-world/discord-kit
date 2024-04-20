package world.estaria.discordkit.channel.config

import kotlinx.serialization.Serializable

/**
 * @author Niklas Nieberler
 */

@Serializable
class DiscordChannelConfig(
    val map: Map<String, String>
) {

    object Default {
        fun get(): DiscordChannelConfig {
            return DiscordChannelConfig(
                hashMapOf(
                    Pair("first", "second")
                )
            )
        }
    }

}