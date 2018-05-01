/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NmStudios;

import de.btobastian.sdcf4j.CommandExecutor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringJoiner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.guild.member.UserBanEvent;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;
import sx.blah.discord.handle.impl.events.guild.role.RoleCreateEvent;
import sx.blah.discord.handle.impl.events.user.UserUpdateEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.Permissions;

/**
 *
 * @author USER
 */
public class Run implements CommandExecutor{
    
        public static ArrayList customerList = new ArrayList<String>();
    public static int amount = 0;
    public static File folder = new File("C:/customers/");
public static File[] listOfFiles = folder.listFiles();
public static int lookingForValue = 0;
    public static int searcherID = 0;
    public static String name = null;
    public static int unpaid = 0;
    public static boolean activated = true;
    
    /*
    
    ~ Coded by Zax P.
    
    Info:
    Bot Command List - Unorganized code but still functions.
    
    
    */
    
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) throws IOException{  
         logs.jTextArea1.append("\n User: " + event.getAuthor().getName() + "Channel: " + event.getChannel() + " : " + event.getMessage().getContent());
         if(activated == true){
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "removeuseless")){
             String[] argArray = event.getMessage().getContent().split(" ");
          // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if(argArray.length == 0)
            return;

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if(!argArray[0].startsWith(BotUtils.BOT_PREFIX))
            return;

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        // Load the rest of the args in the array into a List for safer access
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0); // Remove the command
            removeUselessCommand(event, argsList);
            
        }
        
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "removeUseless")){
             String[] argArray = event.getMessage().getContent().split(" ");
          // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if(argArray.length == 0)
            return;

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if(!argArray[0].startsWith(BotUtils.BOT_PREFIX))
            return;

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        // Load the rest of the args in the array into a List for safer access
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0); // Remove the command
            removeUselessCommand(event, argsList);
            
        }
   
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "developer")){
             String[] argArray = event.getMessage().getContent().split(" ");
          // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if(argArray.length == 0)
            return;

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if(!argArray[0].startsWith(BotUtils.BOT_PREFIX))
            return;

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        // Load the rest of the args in the array into a List for safer access
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0); // Remove the command
            developerCommand(event, argsList);
            
        }
        
           if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "swear-bypass")){
             String[] argArray = event.getMessage().getContent().split(" ");
          // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if(argArray.length == 0)
            return;

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if(!argArray[0].startsWith(BotUtils.BOT_PREFIX))
            return;

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        // Load the rest of the args in the array into a List for safer access
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0); // Remove the command
            addBypassCommand(event, argsList);
            
        }
           
            if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "help")){
             String[] argArray = event.getMessage().getContent().split(" ");
          // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if(argArray.length == 0)
            return;

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if(!argArray[0].startsWith(BotUtils.BOT_PREFIX))
            return;

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        // Load the rest of the args in the array into a List for safer access
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0); // Remove the command
            helpCommand(event, argsList);
            
        }
                if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "report")){
             String[] argArray = event.getMessage().getContent().split(" ");
          // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if(argArray.length == 0)
            return;

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if(!argArray[0].startsWith(BotUtils.BOT_PREFIX))
            return;

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        // Load the rest of the args in the array into a List for safer access
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0); // Remove the command
            reportUserCommand(event, argsList);
            
        }
         }
    }
            
               public static void removeUselessCommand(MessageReceivedEvent event, List<String> args) throws IOException{
                   event.getAuthor().addRole(event.getGuild().getRoleByID(440546834088329257L));
                   //BotUtils.sendMessage(event.getChannel(), "Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                   System.out.println("Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                 // BotUtils.sendMessage(event.getChannel(), "Added role is: " + event.getGuild().getRoleByID(Long.parseLong(args.get(0))).getName());
            BotUtils.sendMessage(event.getChannel(), "``You are now given exemption to unsee useless channels``");
    
     }
                  public static void sayCommand(MessageReceivedEvent event, long channelId, String text) throws IOException{;
                   //BotUtils.sendMessage(event.getChannel(), "Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                  // System.out.println("Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                 // BotUtils.sendMessage(event.getChannel(), "Added role is: " + event.getGuild().getRoleByID(Long.parseLong(args.get(0))).getName());
            BotUtils.sendMessage(event.getGuild().getChannelByID(channelId), text);
    
     }
                  
                   public static void helpCommand(MessageReceivedEvent event, List<String> args) throws IOException{
                   //event.getAuthor().addRole(event.getGuild().getRoleByID(440546834088329257L));
                   //BotUtils.sendMessage(event.getChannel(), "Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                   //System.out.println("Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                 // BotUtils.sendMessage(event.getChannel(), "Added role is: " + event.getGuild().getRoleByID(Long.parseLong(args.get(0))).getName());
            BotUtils.sendMessage(event.getChannel(), "** Builder Bot Help v1.0 ** \n -report : Reports a staff/a member \n Usage: b+report <@user> <2 word reason> \n -developer : Contacts the Builder Bot developer \n Usage: b+developer \n -swear-bypass : Adds the swear-bypass role \n Usage: b+swear-bypass");
    
     }
               
               public static void addBypassCommand(MessageReceivedEvent event, List<String> args) throws IOException{
                   event.getAuthor().addRole(event.getGuild().getRoleByID(437146715884355584L));
                   //BotUtils.sendMessage(event.getChannel(), "Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                   //System.out.println("Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                 // BotUtils.sendMessage(event.getChannel(), "Added role is: " + event.getGuild().getRoleByID(Long.parseLong(args.get(0))).getName());
            BotUtils.sendMessage(event.getChannel(), "``You are now given exemption to swearing!``");
    
     }
               
               public static void reportUserCommand(MessageReceivedEvent event, List<String> args) throws IOException{
                //  if(args.get(0) != null && args.get(1) != null && args.get(2) != null){
                StringBuilder buffer = new StringBuilder();
                     if(args.get(0).contains("@")){
                        for(int i = 1; i <= args.size() - 1; i++){
                          buffer.append(args.get(i)).append(" ");
// one, two
System.out.println(buffer.toString());
                        }
                        String joined = buffer.toString();
                         
                                     BotUtils.sendMessage(event.getChannel(), "``You have reported " + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " for " + joined + "``");
             BotUtils.sendMessage(event.getGuild().getChannelByID(440583799403970570L), "``" + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " has been reported for " +  joined + "``");
            event.getAuthor().getOrCreatePMChannel().sendMessage("``Thank you for reporting, there will be a investigation happening in awhile.``");
            event.getGuild().getUserByID(221536817969627136L).getOrCreatePMChannel().sendMessage("User : " + event.getAuthor().getName() + " has reported " + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " for " +  joined + "``");
                   //BotUtils.sendMessage(event.getChannel(), "Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                   //System.out.println("Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                 // BotUtils.sendMessage(event.getChannel(), "Added role is: " + event.getGuild().getRoleByID(Long.parseLong(args.get(0))).getName());
                         }
                 
                   }
              /*   if(args.size() == 1){
               //   if(args.get(0) != null && args.get(1) != null && args.get(2) == null){
                     if(args.get(0).contains("@")){
                        
                         
                                     BotUtils.sendMessage(event.getChannel(), "``You have reported " + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " for " + args.get(1) + "``");
             BotUtils.sendMessage(event.getGuild().getChannelByID(440583799403970570L), "``" + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " has been reported for " + args.get(1)+ "``");
            event.getAuthor().getOrCreatePMChannel().sendMessage("``Thank you for reporting, there will be a investigation happening in awhile.``");
            event.getGuild().getUserByID(221536817969627136L).getOrCreatePMChannel().sendMessage("User : " + event.getAuthor().getName() + " has reported " + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " for " + args.get(1) + "``");
                   //BotUtils.sendMessage(event.getChannel(), "Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                   //System.out.println("Available roles: " + event.getAuthor().getRolesForGuild(event.getGuild()));
                 // BotUtils.sendMessage(event.getChannel(), "Added role is: " + event.getGuild().getRoleByID(Long.parseLong(args.get(0))).getName());
                         }
                 
                   }
                 /*  if(args.size() == 2){
                       if(args.get(0).contains("@")){
                   //if(args.get(0) != null && args.get(1) != null && args.get(2) != null){
                      BotUtils.sendMessage(event.getChannel(), "``You have reported " + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " for " + args.get(1) + " " + args.get(2) + "``");
             BotUtils.sendMessage(event.getGuild().getChannelByID(440583799403970570L), "``" + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " has been reported for " + args.get(1) + " " + args.get(2) + "``");
            event.getAuthor().getOrCreatePMChannel().sendMessage("``Thank you for reporting, there will be a investigation happening in awhile.``");
            event.getGuild().getUserByID(221536817969627136L).getOrCreatePMChannel().sendMessage("User : " + event.getAuthor().getName() + " has reported " + event.getGuild().getUserByID(Long.parseLong(args.get(0).replace("@", "").replace("<", "").replace(">", "").replace("!", ""))).getName() + " for " + args.get(1) +  " " + args.get(2) +"``");
                 }*/
                     /* else if(args.get(0).contains("@") == false)

                   BotUtils.sendMessage(event.getChannel(), "``You have reported " + args.get(0) + " for " + args.get(1) + "``");
             BotUtils.sendMessage(event.getGuild().getChannelByID(440583799403970570L), "``" + args.get(0) + " has been reported for " + args.get(1));
            event.getAuthor().getOrCreatePMChannel().sendMessage("``Thank you for reporting, there will be a investigation happening in awhile.``");
            event.getGuild().getUserByID(221536817969627136L).getOrCreatePMChannel().sendMessage("User : " + event.getAuthor().getName() + " has reported " + args.get(0) + " for " + args.get(1) + "``");
                 } *///if(args.get(2) != null){
                    // BotUtils.sendMessage(event.getChannel(), "``Please use only 1 word reason for example abuse and explain in the investigation that will be conducted soon.``");
                 //}
                 
              // }
              // }
               //}



     

                public static void developerCommand(MessageReceivedEvent event, List<String> args) throws IOException{
                    event.getGuild().getUserByID(221536817969627136L).getOrCreatePMChannel().sendMessage("User : " + event.getAuthor().getName() + " has contacted you for a possible bug.");
                BotUtils.sendMessage(event.getChannel(), "``Builder bot developer has been contacted.``");
    
     }
               
               
               
               @EventSubscriber
              public void onRoleCreateEvent(RoleCreateEvent event) throws InterruptedException{
                  Thread.sleep(12340);
                  BotUtils.sendMessage(event.getGuild().getChannelByID(440560317764730890L), "``Role created : "  + event.getRole().getName() + " creation date : " + event.getRole().getCreationDate() + "``");
              }
              
              
              
               @EventSubscriber
              public void onBanEvent(UserBanEvent event) throws InterruptedException{
                //  Thread.sleep(2460);
                  BotUtils.sendMessage(event.getGuild().getChannelByID(440560317764730890L), "``User banned : "  + event.getUser().getName());
              }
              
              @EventSubscriber
              public void onUserJoinEvent(UserJoinEvent event) throws InterruptedException{
                //  Thread.sleep(2460);
                  BotUtils.sendMessage(event.getGuild().getChannelByID(440563478579773450L), "``User : " + event.getUser().getName() + " creation date: " + event.getUser().getCreationDate() + "``");
              }
              
         
         
    }

    
    
    
    

