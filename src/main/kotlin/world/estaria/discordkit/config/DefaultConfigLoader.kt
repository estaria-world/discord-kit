package world.estaria.discordkit.config

import world.avionik.configkit.ConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class DefaultConfigLoader : ConfigLoader<DefaultConfig>(
    File("config.yaml"),
    YamlFileFormatter(
        DefaultConfig.serializer(),
    ),
    { DefaultConfig.Default.get() }
)