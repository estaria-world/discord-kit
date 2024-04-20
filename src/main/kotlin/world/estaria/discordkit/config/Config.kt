package world.estaria.discordkit.config

import kotlinx.serialization.Serializable

/**
 * @author Niklas Nieberler
 */

@Serializable
class Config(
    val token: String,
    private val activity: Activity
) {

    @Serializable
    class Activity(
        val name: String,
        val type: net.dv8tion.jda.api.entities.Activity.ActivityType
    )

    object Default {
        fun get(): Config {
            return Config("", Activity("", net.dv8tion.jda.api.entities.Activity.ActivityType.PLAYING))
        }
    }

    fun toActivity(): net.dv8tion.jda.api.entities.Activity {
        return net.dv8tion.jda.api.entities.Activity.of(this.activity.type, this.activity.name)
    }

}