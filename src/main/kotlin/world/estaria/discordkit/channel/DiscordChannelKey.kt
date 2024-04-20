package world.estaria.discordkit.channel

import world.estaria.discordkit.Key

/**
 * @author Niklas Nieberler
 */

interface DiscordChannelKey : Key {

    /**
     * Gets you the value of the key via the discord-channel config
     * @return id of the config
     */
    fun getId(): String? {
        return DiscordChannel.get(getKey())
    }

}