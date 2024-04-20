package world.estaria.discordkit

import net.dv8tion.jda.api.sharding.ShardManager
import org.apache.logging.log4j.Logger
import world.estaria.discordkit.config.DiscordBotConfigFactory

/**
 * @author Niklas Nieberler
 */

class DiscordConfigurator(
    private val logger: Logger
) {

    private val defaultShardManagerBuilder = DiscordBotConfigFactory.create()

    fun withEventListeners(vararg listener: Any): DiscordConfigurator {
        this.defaultShardManagerBuilder.addEventListeners(*listener)
        return this
    }

    fun build(): ShardManager {
        this.logger.info("Starting new discord bot instance")

        val shardManager = this.defaultShardManagerBuilder.build()
        Runtime.getRuntime().addShutdownHook(Thread {
            shardManager.shutdown()
        })
        return shardManager
    }

}