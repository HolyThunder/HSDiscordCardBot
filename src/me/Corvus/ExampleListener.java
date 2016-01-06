package me.Corvus;

import me.itsghost.jdiscord.DiscordAPI;
import me.itsghost.jdiscord.event.EventListener;
import me.itsghost.jdiscord.events.UserChatEvent;
import me.itsghost.jdiscord.message.MessageBuilder;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;


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

        SettingsGetter SG = new SettingsGetter();
        ArrayList<String> settings = new ArrayList<String>();
        settings = SG.GetSettings();

        if(!e.getUser().toString().equalsIgnoreCase(settings.get(1))) {
            e.getGroup().sendMessage(new MessageBuilder()
                    .addString(cf.GetInfo(e.getMsg().toString()))
                    .build(api));
        }
    }
}
