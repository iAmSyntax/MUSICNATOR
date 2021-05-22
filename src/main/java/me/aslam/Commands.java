package me.aslam;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
// !info command displays a basic abstract information of the bot
public class Commands extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        final String messageReceived = event.getMessage().getContentRaw();
        final TextChannel textChannel = event.getChannel();
        if (messageReceived.equals("!info")) {
            textChannel.sendMessage("A music bot that will play youtube links and searches songs too !").queue();
        }

    }
}
