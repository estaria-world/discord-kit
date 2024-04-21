package world.estaria.discordkit.channel

import world.estaria.discordkit.channel.config.DiscordChannelConfigLoader

/**
 * @author Niklas Nieberler
 */

object DiscordChannel {

    private val discordChannelConfig = DiscordChannelConfigLoader().load()

    /**
     * Gets you the value of the key via the discord-channel config
     * @param key the enum key class
     * @return value of the config
     */
    fun get(key: DiscordChannelKey): String? {
        return get(key.getKey())
    }

    /**
     * Gets you the value of the key via the discord-channel config
     * @param key the enum key class
     * @return value of the config
     */
    fun get(key: String): String? {
        return this.discordChannelConfig.channels[key]
    }

}