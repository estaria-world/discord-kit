package world.estaria.discordkit

import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder
import world.estaria.discordkit.config.DiscordBotConfigFactory

/**
 * @author Niklas Nieberler
 */

class DiscordConfigurator {

    private val defaultShardManagerBuilder = DiscordBotConfigFactory.create()

    fun withEventListeners(vararg listener: Any): DiscordConfigurator {
        this.defaultShardManagerBuilder.addEventListeners(*listener)
        return this
    }

    fun build(): DefaultShardManagerBuilder = this.defaultShardManagerBuilder

}