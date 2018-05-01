/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NmStudios;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

/**
 *
 * @author USER
 */
public class BotUtils {
    
        static String BOT_PREFIX = "b+";

    // Handles the creation and getting of a IDiscordClient object for a token
    static IDiscordClient getBuiltDiscordClient(String token){

        // The ClientBuilder object is where you will attach your params for configuring the instance of your bot.
        // Such as withToken, setDaemon etc
        return new ClientBuilder()
                .withToken(token)
                .build();

    }

    // Helper functions to make certain aspects of the bot easier to use.
    static void sendMessage(IChannel channel, String message){

        // This might look weird but it'll be explained in another page.
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(message);
            } catch (DiscordException e){
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            }
        });
    
}
    
    /* Concepts 
    
      @Command(aliases = {"z:start"}, description = "Pong!")
public String onCommand(MessageReceivedEvent message) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
cal.setTime(date);  
int hours = cal.get(Calendar.HOUR_OF_DAY);
int minute = cal.get(Calendar.MINUTE);
    if(new File(message.getAuthor().getName() + ".properties").exists()){
        editUserData(message.getAuthor().getName(), "zitcoin", 0);
        editUserData(message.getAuthor().getName(), "timeStarted", convertToMinutes(hours, minute));
    return "Zitcoin > Starting miner!";
        
    } else if(!new File(message.getAuthor().getName() + ".properties").exists()){
            createUserData(message.getAuthor().getName(), 0, convertToMinutes(hours, minute), 0);
    return "Zitcoin > Starting miner!";
    }
        return "Zitcoin - Powered by Zaxun";
}

   @Command(aliases = {"z:end"}, description = "Pong!")
public String onCommand2(MessageReceivedEvent message) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
cal.setTime(date);  
int hours = cal.get(Calendar.HOUR_OF_DAY);
int minute = cal.get(Calendar.MINUTE);
    if(new File(message.getAuthor().getName() + ".properties").exists()){
        editUserData(message.getAuthor().getName(), "timeEnded", convertToMinutes(hours, minute));
        editUserData(message.getAuthor().getName(), "zitcoin", getIntData(message.getAuthor().getName(), "zitcoin") + getZitcoins(getIntData(message.getAuthor().getName(), "timeStarted"), getIntData(message.getAuthor().getName(), "timeEnded"), message.getAuthor().getName()));
    return "Zitcoin > You mined a total of " + getIntData(message.getAuthor().getName(), "zitcoin");
        
    } else if(!new File(message.getAuthor().getName() + ".properties").exists()){
    return "Zitcoin > Blocknet has bumped into an error: User hasn't started mining yet.";
    }
        return "Zitcoin - Powered by Zaxun";
}
    */
    
}
