package me.freitaseric.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadyListener extends ListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ReadyListener.class);

    public void init(JDA api) {
        api.addEventListener(this);
    }

    @Override
    public void onReady(ReadyEvent event) {
        event.getJDA().getPresence().setPresence(OnlineStatus.IDLE, Activity.listening("lo-fi while study"), true);
        logger.info("The client is ready and connected on {}!", event.getJDA().getSelfUser().getName());
    }
}
