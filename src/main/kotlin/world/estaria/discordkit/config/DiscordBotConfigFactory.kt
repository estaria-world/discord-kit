package world.estaria.discordkit.config

import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder

/**
 * @author Niklas Nieberler
 */

object DiscordBotConfigFactory {

    /**
     * Creates a new bot shard instance
     */
    fun create(): DefaultShardManagerBuilder {
        val config = BotConfigLoader().load()
        return createWithConfig(config)
    }

    private fun createWithConfig(config: BotConfig): DefaultShardManagerBuilder {
        return DefaultShardManagerBuilder.createDefault(config.token)
            .setStatus(OnlineStatus.ONLINE)
            .setActivity(config.toActivity())
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
    }

}