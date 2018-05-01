/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NmStudios;

import de.btobastian.sdcf4j.CommandExecutor;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.Discord4JHandler;
import java.io.File;
import java.io.IOException;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;

/**
 *
 * @author USER
 */
public class BuilderBot{

    /**
     * @param args the command line arguments
     */
  public static IDiscordClient createClient(String token, boolean login) { // Returns a new instance of the Discord client
        ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(token); // Adds the login info to the builder
        try {
            if (login) {
                return clientBuilder.login(); // Creates the client instance and logs the client in
            } else {
                return clientBuilder.build(); // Creates the client instance but it doesn't log the client in yet, you would have to call client.login() yourself
            }
        } catch (DiscordException e) { // This is thrown if there was a problem building the client
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
IDiscordClient client = createClient("NDQwNTQ2NDg2MDE1NzU0MjYw.DcjSgg.YXzhd5AC56USmBO1G2SPKphb75E", true);
CommandHandler handler = new Discord4JHandler(client);
client.getDispatcher().registerListener(new Run());
handler.registerCommand(new Run());
File f = new File("C:/customers/nullvalue123323");
f.getParentFile().mkdirs();
File f2 = new File("C:/items/nullvalue123323");
f2.getParentFile().mkdirs();
new logs().setVisible(true);
    }
    
    
    
}
