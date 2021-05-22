package me.aslam;

import me.aslam.music.GuildMusicManager;
import me.aslam.music.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class StopCommand extends ListenerAdapter {
// !stop is a ShutDown command for stopping everything and clearing all the queue

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        final String stopCommand = event.getMessage().getContentRaw();
        final TextChannel channel = event.getChannel();
        final Member self = event.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        if (stopCommand.equals("!stop")) {
            if (!selfVoiceState.inVoiceChannel()) {
                channel.sendMessage("I need to be in a voice channel for this to work").queue();
                return;
            }

            final Member member = event.getMember();
            final GuildVoiceState memberVoiceState = member.getVoiceState();

            if (!memberVoiceState.inVoiceChannel()) {
                channel.sendMessage("You need to be in a voice channel").queue();
                return;
            }

            if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
                channel.sendMessage("you need to be in the same voice channel as me").queue();
                return;
            }

            final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(event.getGuild());
            musicManager.scheduler.player.stopTrack();
            musicManager.scheduler.queue.clear();
            channel.sendMessage("The song has been stopped and the queue has been cleared ").queue();
        }


    }


}
