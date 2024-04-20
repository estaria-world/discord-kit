package world.estaria.discordkit.channel.config

import world.avionik.configkit.ConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class DiscordChannelConfigLoader : ConfigLoader<DiscordChannelConfig>(
    File("discord-channels.yaml"),
    YamlFileFormatter(
        DiscordChannelConfig.serializer()
    ),
    { DiscordChannelConfig.Default.get() }
)