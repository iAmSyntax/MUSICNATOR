package me.aslam;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

//<-------------------------------- THE MAIN BOT CLASS ------------------------->\\

public class Bot {

    Bot() throws LoginException {
        // Get your bot token and paste it here if you want to try the bot
        JDA mbot = JDABuilder.createDefault("ENTER YOUR TOKEN HERE").build();
        mbot.getPresence().setActivity(Activity.listening("Music"));
        mbot.getPresence().setStatus(OnlineStatus.ONLINE);
        mbot.addEventListener(new Commands());               //each command class is passed on to addEventListener ()
        mbot.addEventListener(new JoinCommand());
        mbot.addEventListener(new PlayCommand());
        mbot.addEventListener(new StopCommand());
        mbot.addEventListener(new PauseCommand());
        mbot.addEventListener(new ResumeCommand());
        mbot.addEventListener(new SkipCommand());
    }

    public static void main(String[] args) throws LoginException {
        new Bot();
    }

}
