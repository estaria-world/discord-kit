package world.estaria.discordkit

import net.dv8tion.jda.api.sharding.ShardManager
import world.estaria.discordkit.config.DefaultConfig

/**
 * @author Niklas Nieberler
 */

class DiscordManager(
    private val config: DefaultConfig,
    private val shardManager: ShardManager
) {

    fun shutdown() {
        this.shardManager.shutdown()
    }

}