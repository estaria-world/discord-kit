package world.estaria.discordkit

import org.apache.logging.log4j.Logger
import world.estaria.discordkit.config.DefaultConfigLoader
import world.estaria.discordkit.config.DiscordBotConfigFactory

/**
 * @author Niklas Nieberler
 */

class DiscordConfigurator(
    private val logger: Logger
) {

    private val config = DefaultConfigLoader().load()
    private val defaultShardManagerBuilder = DiscordBotConfigFactory.create(config)

    fun withEventListeners(vararg listener: Any): DiscordConfigurator {
        this.defaultShardManagerBuilder.addEventListeners(*listener)
        return this
    }

    fun build(): DiscordManager {
        this.logger.info("Starting new discord bot instance")

        val shardManager = this.defaultShardManagerBuilder.build()
        Runtime.getRuntime().addShutdownHook(Thread {
            shardManager.shutdown()
        })
        return DiscordManager(
            this.config,
            shardManager
        )
    }

}