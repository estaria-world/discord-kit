package world.estaria.discordkit.member.config

import world.avionik.configkit.ConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class DiscordMemberConfigLoader : ConfigLoader<DiscordMemberConfig>(
    File("discord-members.yaml"),
    YamlFileFormatter(
        DiscordMemberConfig.serializer()
    ),
    { DiscordMemberConfig.Default.get() }
)