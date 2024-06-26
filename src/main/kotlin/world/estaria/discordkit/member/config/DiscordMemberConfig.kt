package world.estaria.discordkit.member.config

import kotlinx.serialization.Serializable

/**
 * @author Niklas Nieberler
 */

@Serializable
class DiscordMemberConfig(
    val members: Map<String, String>
) {

    object Default {
        fun get(): DiscordMemberConfig {
            return DiscordMemberConfig(
                hashMapOf(
                    Pair("first", "second")
                )
            )
        }
    }

}