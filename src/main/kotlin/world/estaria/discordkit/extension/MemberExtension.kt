package world.estaria.discordkit.extension

import net.dv8tion.jda.api.entities.Member

/**
 * @author Niklas Nieberler
 */

/**
 * @param id of the role
 * @return true if this player has this role
 */
fun Member.hasRole(id: String): Boolean {
    return this.roles.any { it.id == id }
}