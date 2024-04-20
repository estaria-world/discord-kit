package world.estaria.discordkit.config

import world.avionik.configkit.ConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class BotConfigLoader : ConfigLoader<BotConfig>(
    File("config.yaml"),
    YamlFileFormatter(
        BotConfig.serializer(),
    ),
    { BotConfig.Default.get() }
)