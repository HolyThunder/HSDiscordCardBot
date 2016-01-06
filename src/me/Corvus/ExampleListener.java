package me.Corvus;

import me.itsghost.jdiscord.DiscordAPI;
import me.itsghost.jdiscord.event.EventListener;
import me.itsghost.jdiscord.events.UserChatEvent;
import me.itsghost.jdiscord.events.UserTypingEvent;
import me.itsghost.jdiscord.message.MessageBuilder;
import org.json.simple.parser.ParseException;

import java.io.IOException;


/**
 * Created by soulb on 1/5/2016.
 */
public class ExampleListener implements EventListener {
    DiscordAPI api;
    CardFinder cf = new CardFinder();
    public ExampleListener(DiscordAPI api){
        this.api = api;
    }
    public void userChat(UserChatEvent e) throws IOException, ParseException {

        if(cf.GetInfo(e.getMsg().toString()) != null && !e.getUser().toString().equalsIgnoreCase("BOTACCOUNTUSERNAME")) {
            e.getGroup().sendMessage(new MessageBuilder()
                    .addString(cf.GetInfo(e.getMsg().toString()))
                    .build(api));
        }
    }
}
