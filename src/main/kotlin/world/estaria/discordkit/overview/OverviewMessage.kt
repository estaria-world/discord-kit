package world.estaria.discordkit.overview

import kotlinx.serialization.Serializable
import world.avionik.configkit.Nameable

/**
 * @author Niklas Nieberler
 */

@Serializable
class OverviewMessage(
    private val id: String,
    private val descriptions: List<String>
) : Nameable {

    override fun getName(): String = this.id

    fun getDescription(): String {
        return this.descriptions.joinToString("\n")
    }

    companion object {
        /**
         * @param id the message key
         * @return description of the message key
         */
        fun getDescription(id: String): String {
            val multipleConfigLoader = OverviewMessageConfigLoader()
            return multipleConfigLoader.getOverviewMessage(id)?.getDescription()
                ?: throw NullPointerException("failed to find message $id")
        }
    }

}