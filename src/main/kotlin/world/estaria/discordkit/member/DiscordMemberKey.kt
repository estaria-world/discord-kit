package world.estaria.discordkit.member

import world.estaria.discordkit.Key

/**
 * @author Niklas Nieberler
 */

interface DiscordMemberKey : Key {

    /**
     * Gets you the value of the key via the discord-member config
     * @return id of the config
     */
    fun getId(): String? {
        return DiscordMember.get(getKey())
    }

}