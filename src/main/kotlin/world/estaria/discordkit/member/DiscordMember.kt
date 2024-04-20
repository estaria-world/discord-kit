package world.estaria.discordkit.member

import world.estaria.discordkit.channel.DiscordChannelKey
import world.estaria.discordkit.member.config.DiscordMemberConfigLoader

/**
 * @author Niklas Nieberler
 */

object DiscordMember {

    private val discordMemberConfig = DiscordMemberConfigLoader().load()

    /**
     * Gets you the value of the key via the discord-member config
     * @param key the enum key class
     * @return value of the config
     */
    fun get(key: DiscordChannelKey): String? {
        return get(key.getKey())
    }

    /**
     * Gets you the value of the key via the discord-member config
     * @param key the enum key class
     * @return value of the config
     */
    fun get(key: String): String? {
        return this.discordMemberConfig.map[key]
    }

}