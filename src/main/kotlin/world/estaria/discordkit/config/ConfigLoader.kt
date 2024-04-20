package world.estaria.discordkit.config

import world.avionik.configkit.ConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class ConfigLoader : ConfigLoader<Config>(
    File("config.yaml"),
    YamlFileFormatter(
        Config.serializer(),
    ),
    { Config.Default.get() }
)