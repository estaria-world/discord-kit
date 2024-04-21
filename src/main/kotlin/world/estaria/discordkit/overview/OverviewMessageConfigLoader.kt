package world.estaria.discordkit.overview

import world.avionik.configkit.MultipleConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class OverviewMessageConfigLoader : MultipleConfigLoader<OverviewMessage>(
    File("overviewMessages"),
    YamlFileFormatter(
        OverviewMessage.serializer()
    )
) {

    fun getOverviewMessage(id: String): OverviewMessage? {
        return this.loadAll().firstOrNull { it.getName() == id }
    }

}