package me.Corvus;

import me.itsghost.jdiscord.DiscordAPI;
import me.itsghost.jdiscord.DiscordBuilder;
import me.itsghost.jdiscord.exception.BadUsernamePasswordException;
import me.itsghost.jdiscord.exception.DiscordFailedToConnectException;
import me.itsghost.jdiscord.exception.NoLoginDetailsException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        DiscordAPI api = new DiscordBuilder("BOTACCOUTEMAIL", "BOTACCOUNTPASSWORD").build();

        try {
            api.login();
        } catch (NoLoginDetailsException e) {
            e.printStackTrace();
        } catch (BadUsernamePasswordException e) {
            e.printStackTrace();
        } catch (DiscordFailedToConnectException e) {
            e.printStackTrace();
        }

        api.getEventManager().registerListener(new ExampleListener(api)); //Register listener

    }
}
