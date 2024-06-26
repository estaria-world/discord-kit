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
    fun create(config: DefaultConfig): DefaultShardManagerBuilder {
        return DefaultShardManagerBuilder.createDefault(config.token)
            .setStatus(OnlineStatus.ONLINE)
            .setActivity(config.toActivity())
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
    }

}