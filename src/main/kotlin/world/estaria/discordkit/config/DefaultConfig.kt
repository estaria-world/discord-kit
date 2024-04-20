package world.estaria.discordkit.config

import kotlinx.serialization.Serializable

/**
 * @author Niklas Nieberler
 */

@Serializable
class DefaultConfig(
    val token: String,
    private val activity: Activity,
    val memberOwnerIds: Array<String>
) {

    @Serializable
    class Activity(
        val name: String,
        val type: net.dv8tion.jda.api.entities.Activity.ActivityType
    )

    object Default {
        fun get(): DefaultConfig {
            return DefaultConfig(
                "",
                Activity(
                    "",
                    net.dv8tion.jda.api.entities.Activity.ActivityType.PLAYING
                ),
                arrayOf(
                    "123"
                )
            )
        }
    }

    fun toActivity(): net.dv8tion.jda.api.entities.Activity {
        return net.dv8tion.jda.api.entities.Activity.of(this.activity.type, this.activity.name)
    }

}