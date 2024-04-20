package world.estaria.discordkit

import org.apache.logging.log4j.LogManager

/**
 * @author Niklas Nieberler
 */

object DiscordKit {

    val logger = LogManager.getLogger("Discord-Server")

    /**
     * Creates a new discord bot configurator instance to configure this system
     * @return new instance of [DiscordConfigurator]
     */
    fun createConfiguration(): DiscordConfigurator {
        return DiscordConfigurator(this.logger)
    }

}