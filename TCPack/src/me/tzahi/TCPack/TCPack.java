package me.tzahi.TCPack;





import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class TCPack extends JavaPlugin implements Listener {
  public static TCPack plugin;
  public ChatColor g = ChatColor.GOLD;
  public ChatColor r = ChatColor.RED;
  public ChatColor b = ChatColor.BLUE;
  public ChatColor y = ChatColor.YELLOW;
@Override
  public void onDisable()
  {
    System.out.println("[TCPack] Disabled!");
  }
@Override
  public void onEnable()
  {
    System.out.println("[TCPack] Enabled!");
    getServer().getPluginManager().registerEvents(this, this);
	getConfig().options().copyDefaults(true);
	saveConfig();
  }



  @SuppressWarnings("unused")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player) sender;
    if (getConfig().getBoolean("EnablePtime") == true) {
    if (cmd.getName().equalsIgnoreCase("ptime")) {
      if (args.length == 0) {
    	  if(p.hasPermission("ptime.list")) {
    	        p.sendMessage(b + "}---- PlayerTime help ----{");
    	        p.sendMessage(g + "/ptime day" + b + " - Sets your time to day.");
    	        p.sendMessage(g + "/ptime night" + b + " - Sets your time to night.");
    	        p.sendMessage(g + "/ptime morning" + b + " - Sets your time to morning.");
    	        p.sendMessage(g + "/ptime reset" + b + " - Sets your time to the normal server-time.");
    	        p.sendMessage(g + "/ptime info" + b + " - Shows you information about the time.");
    	        return true;  
    	  }
  		if(!(p.hasPermission("ptime.list"))) {
      		noPerms(sender);
      	}
      }if (args.length == 1) {
        if (args[0].equalsIgnoreCase("day")) {
        	if(p.hasPermission("ptime.day")) {
                p.setPlayerTime(6000L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to day.");
                return true;	
        	}
    		if(!(p.hasPermission("ptime.day"))) {
          		noPerms(sender);
          	}
        }if (args[0].equalsIgnoreCase("night")) {
        	if(p.hasPermission("ptime.night")) {
                p.setPlayerTime(18000L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to night.");
                return true;
        	}
    		if(!(p.hasPermission("ptime.night"))) {
          		noPerms(sender);
          	}
        }if (args[0].equalsIgnoreCase("morning")) {
        	if(p.hasPermission("ptime.morning")) {
                p.setPlayerTime(0L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to morning.");
                return true;
        	}
    		if(!(p.hasPermission("ptime.morning"))) {
          		noPerms(sender);
          	}
        }if (args[0].equalsIgnoreCase("dawn")) {
        	if(p.hasPermission("ptime.dawn")) {
                p.setPlayerTime(12000L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to dawn.");
                return true;
        	}
    		if(!(p.hasPermission("ptime.dawn"))) {
          		noPerms(sender);
          	}
        }if (args[0].equalsIgnoreCase("reset")) {
        	if(p.hasPermission("ptime.reset")) { 
                p.resetPlayerTime();
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to the normal server-time.");
                return true;
        	}
    		if(!(p.hasPermission("ptime.reset"))) {
          		noPerms(sender);
          	}
        }if (args[0].equalsIgnoreCase("info")) {
        	if(p.hasPermission("ptime.info")) {
        		p.sendMessage(r + "Your time is set on " + g + p.getPlayerTime() + r + ". The difference between the servertime and playertime is " + this.g + p.getPlayerTimeOffset() + this.r + ".");
                return true;
        	}
    		if(!(p.hasPermission("ptime.info"))) {
          		noPerms(sender);
          	}
        }
        }
      }
    }
    if (getConfig().getBoolean("EnableCompress") == true) {
    if (cmd.getName().equalsIgnoreCase("compress")) {
    	if (args.length == 0) {
    		if (p.hasPermission("compress.list")) {
      	        p.sendMessage(b + "}---- Compress help ----{");
      	        p.sendMessage(g + "/compress" + b + " - Lists compress commands.");
      	        p.sendMessage(g + "/compress wood" + b + " - Compresses wood.");
      	        p.sendMessage(g + "/compress bonemeal" + b + " - Compresses bonemeal.");
      	        p.sendMessage(g + "/compress ores" + b + " - Compresses iron, gold, and diamond.");
    		}
    		if(!(p.hasPermission("compress.list"))) {
          		noPerms(sender);
          	}
    	}
    	if (args.length == 1) {
    		if (args[0].equalsIgnoreCase("wood")) {
    		if (p.hasPermission("compress.wood")) {
    			PlayerInventory inventory = p.getInventory();
    			if (inventory.contains(Material.WOOD))  {
    				Material.WOOD.getData();
    				int j = getAmount(p,5, (byte) 0);
    				int h = getAmount(p,5, (byte) 1);
    				int k = getAmount(p,5, (byte) 2);
    				int m = getAmount(p,5, (byte) 3);
    		     int i = j*1;
    		     int hh = h*1;
    		     int kk = k*1;
    		     int mm = m*1; 
    			 int woodremainder = i%4;
    			 int hwoodremainder = hh%4;
    			 int kwoodremainder = kk%4;
    			 int mwoodremainder = mm%4;
    			 int woodtogive = i-woodremainder;
    			 int hwoodtogive = hh-hwoodremainder;
    			 int kwoodtogive = kk-kwoodremainder;
    			 int mwoodtogive = mm-mwoodremainder;
    			 int woodtoactgive = woodtogive/4;
    			 int hwoodtoactgive = hwoodtogive/4;
    			 int kwoodtoactgive = kwoodtogive/4;
    			 int mwoodtoactgive = mwoodtogive/4;
    			 ItemStack amounttoactgive = new ItemStack(Material.WOOD, i, (byte) 0);
    			 ItemStack hamounttoactgive = new ItemStack(Material.WOOD, hh, (byte) 1);
    			 ItemStack kamounttoactgive = new ItemStack(Material.WOOD, kk, (byte) 2);
    			 ItemStack mamounttoactgive = new ItemStack(Material.WOOD, mm, (byte) 3);
    			 ItemStack logs = new ItemStack(Material.LOG, woodtoactgive, (byte) 0);
    			 ItemStack hlogs = new ItemStack(Material.LOG, hwoodtoactgive, (byte) 1);
    			 ItemStack klogs = new ItemStack(Material.LOG, kwoodtoactgive, (byte) 2);
    			 ItemStack mlogs = new ItemStack(Material.LOG, mwoodtoactgive, (byte) 3);
    			 ItemStack planks = new ItemStack(Material.WOOD, woodremainder, (byte) 0);
    			 ItemStack hplanks = new ItemStack(Material.WOOD, hwoodremainder, (byte) 1);
    			 ItemStack kplanks = new ItemStack(Material.WOOD, kwoodremainder, (byte) 2);
    			 ItemStack mplanks = new ItemStack(Material.WOOD, mwoodremainder, (byte) 3);
    			 inventory.removeItem(amounttoactgive);
    			 inventory.removeItem(hamounttoactgive);
    			 inventory.removeItem(kamounttoactgive);
    			 inventory.removeItem(mamounttoactgive);
    			 inventory.addItem(logs);
    			 inventory.addItem(hlogs);
    			 inventory.addItem(klogs);
    			 inventory.addItem(mlogs);
    			 inventory.addItem(planks);
    			 inventory.addItem(hplanks);
    			 inventory.addItem(kplanks);
    			 inventory.addItem(mplanks);
    			}
    		}
    		if(!(p.hasPermission("compress.wood"))) {
          		noPerms(sender);
          	}
    		}
    		if (args[0].equalsIgnoreCase("ores")) {
    		if (p.hasPermission("compress.ores")) {
    			PlayerInventory inventory = p.getInventory();
    			if (inventory.contains(Material.DIAMOND)) {
    				int d = getAmount(p,264, (byte) 0);
    		     int i = d*1;
    			 int dremainder = i%9;
    			 int dtogive = i-dremainder;
    			 int dtoactgive = dtogive/9;
    			 ItemStack amounttoactgive = new ItemStack(Material.DIAMOND, i);
    			 ItemStack dblocks = new ItemStack(Material.DIAMOND_BLOCK, dtoactgive);
    			 ItemStack diamonds = new ItemStack(Material.DIAMOND, dremainder);
    			 inventory.removeItem(amounttoactgive);
    			 inventory.addItem(dblocks);
    			 inventory.addItem(diamonds);
    			 p.sendMessage(ChatColor.DARK_GREEN +"[TCPack] " + "Converted " + dtogive + " diamond into " + dtoactgive + " diamond blocks successfully.");
    			} else {
    				p.sendMessage(ChatColor.RED + "No diamond to convert.");
    			}
    			 if (inventory.contains(Material.GOLD_INGOT)) {
    		     int g = getAmount(p,266, (byte) 0);
    		     int o = g*1;
    			 int dremainder = o%9;
    			 int dtogive = o-dremainder;
    			 int dtoactgive = dtogive/9;
    			 ItemStack gamounttoactgive = new ItemStack(Material.GOLD_INGOT, o);
    			 ItemStack gdblocks = new ItemStack(Material.GOLD_BLOCK, dtoactgive);
    			 ItemStack gdiamonds = new ItemStack(Material.GOLD_INGOT, dremainder);
    			 inventory.removeItem(gamounttoactgive);
    			 inventory.addItem(gdblocks);
    			 inventory.addItem(gdiamonds);
    			 p.sendMessage(ChatColor.DARK_GREEN +"[TCPack] " + "Converted " + dtogive + " gold ingot into " + dtoactgive + " gold blocks successfully.");
    			} else {
    				p.sendMessage(ChatColor.RED + "No gold to convert.");
    			}
    			 if (inventory.contains(Material.IRON_INGOT)) {
    			 int r = getAmount(p,265, (byte) 0);
    		     int i = r*1;
    			 int dremainder = i%9;
    			 int dtogive = i-dremainder;
    			 int dtoactgive = dtogive/9;
    			 ItemStack amounttoactgive = new ItemStack(Material.IRON_INGOT, i);
    			 ItemStack dblocks = new ItemStack(Material.IRON_BLOCK, dtoactgive);
    			 ItemStack diamonds = new ItemStack(Material.IRON_INGOT, dremainder);
    			 inventory.removeItem(amounttoactgive);
    			 inventory.addItem(dblocks);
    			 inventory.addItem(diamonds);
    			 p.sendMessage(ChatColor.DARK_GREEN +"[TCPack] " + "Converted " + dtogive + " iron ingot into " + dtoactgive + " iron blocks successfully.");
    			} else {
    				p.sendMessage(ChatColor.RED + "No iron to convert.");
    			}
    		    
    		}
    		if(!(p.hasPermission("compress.ores"))) {
          		noPerms(sender);
          	}
    		}
    		if (args[0].equalsIgnoreCase("bonemeal")) {
    		if (p.hasPermission("compress.bonemeal")) {
    			PlayerInventory inventory = p.getInventory();
    			int j = getAmount(p,351, (byte) 15);
    			if (inventory.contains(Material.INK_SACK)) {
    		     int i = j*1;
    			 int woodremainder = i%3;
    			 int woodtogive = i-woodremainder;
    			 int woodtoactgive = (woodtogive/3);
    			 ItemStack origingrand = new ItemStack(Material.INK_SACK, woodremainder, (byte)15);
    			 ItemStack amounttoactgive = new ItemStack(Material.INK_SACK, i, (byte)15);
    			 ItemStack logs = new ItemStack(Material.BONE, woodtoactgive);
    			 inventory.removeItem(amounttoactgive);
    			 inventory.addItem(logs);
    			 inventory.addItem(origingrand);
    			} 
    		}
    		if(!(p.hasPermission("compress.bonemeal"))) {
          		noPerms(sender);
          	}
    		}
    	}
    	}
    }
    if (getConfig().getBoolean("EnableFake") == true) {
    if (cmd.getName().equalsIgnoreCase("fake")) {
        if (args.length == 0) {
      	  if(p.hasPermission("fake.list")) {
      	        p.sendMessage(b + "}---- Fake help ----{");
      	        p.sendMessage(g + "/fake" + b + " - Lists fake commands.");
      	        p.sendMessage(g + "/fake join" + b + " - Fake join the server.");
      	        p.sendMessage(g + "/fake leave" + b + " - Fake leave the server.");
      	        p.sendMessage(g + "/fake join (username)" + b + " - Player fake joins the server.");
      	        p.sendMessage(g + "/fake leave (username)" + b + " - Player fake leaves the server.");
      	        p.sendMessage(g + "/fake op (username)" + b + " - Fake op player.");
      	        p.sendMessage(g + "/fake deop (username)" + b + " - Fake deops player.");
      	        p.sendMessage(g + "/fake ban (username)" + b + " - Quietly fake bans player.");
      	        p.sendMessage(g + "/fake gban (username)" + b + " - Normally fake bans plater.");
      	        p.sendMessage(g + "/fake say (username) (message)" + b + " - Makes player say message. Put / in message to make it a command.");
      	        return true;  
      	  }
  		if(!(p.hasPermission("fake.list"))) {
      		noPerms(sender);
      	}
        }if (args.length == 1) {
          if (args[0].equalsIgnoreCase("join")) {
          	if(p.hasPermission("fake.join")) {
          		getServer().broadcastMessage(y + p.getName() + " joined the game.");
                  return true;	
          	}
          	if(!(p.hasPermission("fake.join"))) {
          		noPerms(sender);
          	}
          }
          if (args[0].equalsIgnoreCase("fix")) {
        	  if(p.hasPermission("fake.fix")) {
        		    String tbbm = getConfig().getString("TextBeforeBMessage");
        		    String tbbmdebug = tbbm.replace("Is", "deeeebuuuuggg debug");
        		    p.sendMessage(tbbmdebug);
        		    
        	  }
            	if(!(p.hasPermission("fake.fix"))) {
              		noPerms(sender);
              	}
          }
          if (args[0].equalsIgnoreCase("leave")) {
          	if(p.hasPermission("fake.leave")) {
          		getServer().broadcastMessage(y + p.getName() + " left the game.");
                  return true;
          	}
          	if(!(p.hasPermission("fake.leave"))) {
          		noPerms(sender);
          	}
          }
        }
        if (args.length == 2) {
        if (args[0].equalsIgnoreCase("join")) {
          	if(p.hasPermission("fake.join.other")) {
          		getServer().broadcastMessage(y + args[1] + " joined the game.");
                  return true;
          	}
          	if(!(p.hasPermission("fake.join.other"))) {
          		noPerms(sender);
          	}
         }
        if (args[0].equalsIgnoreCase("leave")) {
          	if(p.hasPermission("fake.leave.other")) {
          		getServer().broadcastMessage(y + args[1] + " left the game.");
                  return true;
          	}
          	if(!(p.hasPermission("fake.leave.other"))) {
          		noPerms(sender);
          	}
         }
        if (args[0].equalsIgnoreCase("op")) {
          	if(p.hasPermission("fake.op")) {
    	        Player target = Bukkit.getPlayerExact(args[1]);
    	        String displayname = target.getDisplayName();
    	        target.sendMessage(ChatColor.YELLOW + "You are now op!");
    	        p.sendMessage(displayname + " is fake opped.");
                  return true;
          	}
          	if(!(p.hasPermission("fake.op"))) {
          		noPerms(sender);
          	}
         }
        if (args[0].equalsIgnoreCase("deop")) {
          	if(p.hasPermission("fake.deop")) {
    	        Player target = Bukkit.getPlayerExact(args[1]);
    	        String displayname = target.getDisplayName();
    	        target.sendMessage(ChatColor.YELLOW + "You are no longer op!");
    	        p.sendMessage(displayname + " is fake deopped.");
                  return true;
          	}
          	if(!(p.hasPermission("fake.deop"))) {
          		noPerms(sender);
          	}
         }
        if (args[0].equalsIgnoreCase("ban")) {
          	if(p.hasPermission("fake.ban")) {
          		Player player = Bukkit.getPlayerExact(args[1]);
          	    String kbanmessage = getConfig().getString("BanMessagePlayer");
          		player.kickPlayer(kbanmessage);
                  return true;
          	}
          	if(!(p.hasPermission("fake.ban"))) {
          		noPerms(sender);
          	}
         }
        if (args[0].equalsIgnoreCase("gban")) {
        	if(p.hasPermission("fake.ban.global")) {
	        Player target = Bukkit.getPlayerExact(args[1]);
	        String displayname = target.getDisplayName();
	        String pinmessage = getConfig().getString("BanMessage");
	        String pinmessagereal = pinmessage.replace("playername", args[1]);
	        String pinmessageconverted = ChatColor.translateAlternateColorCodes('&', pinmessagereal);
	    	String banmessage = getConfig().getString("BanMessagePlayer");
	          		target.kickPlayer(banmessage);
      		getServer().broadcastMessage(pinmessageconverted.substring(1));
            return true;
	 
        }
        	if(!(p.hasPermission("fake.ban.global"))) {
          		noPerms(sender);
          	}
        
        }
        }
        if (args.length > 3) {
            if (args[0].equalsIgnoreCase("say")) {
              	if(p.hasPermission("fake.say")) {
              		
        	        Player target = Bukkit.getPlayerExact(args[1]);
        	        
        	        String message = args[2];
        	        for(int i = 3; i < args.length; i++) {
        	             message += " " + args[i];
        	        }
        	        if (target == null) {
        	        	p.sendMessage(ChatColor.RED + "Player is not online.");
        	        } 
        	        if (!(target == null)) {
        	        	target.chat(message);
        	        }                     
              	}
              	if(!(p.hasPermission("fake.say"))) {
              		noPerms(sender);
              	}
            }
        }
        if (args.length >= 3) {
            if (args[0].equalsIgnoreCase("gban")) {
            	if(p.hasPermission("fake.ban.global")) {
        	        String reason = args[2];
        	        for(int i = 3; i < args.length; i++) {
        	             reason += " " + args[i];
        	        }
    	        Player target = Bukkit.getPlayerExact(args[1]);
    	        String displayname = target.getDisplayName();
    	        String pinmessage = getConfig().getString("BanMessageReason");
    	        String pinmessagereal = pinmessage.replace("playername", args[1]);
    	        String pinmessagebetter = pinmessagereal.replace("reason", reason);
    	        String pinmessageconverted = ChatColor.translateAlternateColorCodes('&', pinmessagebetter);
    	    	String banmessage = getConfig().getString("BanMessagePlayerReason");
    	    	String banmessagereal = banmessage.replace("reason", reason);
    	          		target.kickPlayer(banmessagereal);
          		getServer().broadcastMessage(pinmessageconverted.substring(1));
                return true;
    	 
            }
            	if(!(p.hasPermission("fake.ban.global"))) {
              		noPerms(sender);
              	}
            }
            }
            if (args.length == 3) {
        	if (args[0].equalsIgnoreCase("say")) {
        		if(p.hasPermission("fake.say")) {
        			Player target = Bukkit.getPlayerExact(args[1]);
        	        if (!(target == null)) {
        	        	String message = args[2];
            	        target.chat(message);
        	        }
        	        if (target == null) {
        	        p.sendMessage(ChatColor.RED + "Player is not online.");
        	        }
        		}
        		if(!(p.hasPermission("fake.say"))) {
              		noPerms(sender);
              	}
        	}
        }
        if (args.length == 2) {
        	if (args[0].equalsIgnoreCase("say")) {
        		if(p.hasPermission("fake.say")) {
        			Player target = Bukkit.getPlayerExact(args[1]);
        			if(!(target == null)) {
        				p.sendMessage(ChatColor.RED + "Not enough arguments. Use /fake say (username) (message)");
        			}
        			if (target == null) {
        				p.sendMessage(ChatColor.RED + "Player is not online and not enough arguments. Use /fake say (username) (message)");
        			}
        		}
        		if(!(p.hasPermission("fake.say"))) {
              		noPerms(sender);
              	}
        	}
        }
        if (args.length == 1) {
        	if (args[0].equalsIgnoreCase("say")) {
        		if(p.hasPermission("fake.say")) {
        			p.sendMessage(ChatColor.RED + "Not enough arguments. Use /fake say (username) (message)");
        		}
        		if (!(p.hasPermission("fake.say"))) {
              		noPerms(sender);
        		}
        	}
        }
        }
    }
    if (getConfig().getBoolean("EnableFlight") == true) {
    if (cmd.getName().equalsIgnoreCase("fly")) {
    	if (args.length == 1) {
    		if (args[0].equalsIgnoreCase("t") || (args[0].equalsIgnoreCase("toggle"))) {
    		if(p.hasPermission("fly.toggle")) {
    			GameMode gamemode = p.getGameMode();
    			if (gamemode == GameMode.CREATIVE) {}
    			if (gamemode == GameMode.SURVIVAL) {
    			if (p.getAllowFlight() == false) {
    				p.setAllowFlight(true);
    				p.setFlying(true);
    				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully enabled.");
    			} else if (p.getAllowFlight() == true) {
    				p.setAllowFlight(false);
    				p.setFlying(false);
    				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully disabled.");
    			}
    		}
    		}
    		if(!(p.hasPermission("fly.toggle"))) {
    			noPerms(sender);
    		}
    		}
    	}
    	if (args.length == 0) {
    		if(p.hasPermission("fly.list")) {
      	        p.sendMessage(b + "}---- Flight help ----{");
      	        p.sendMessage(g + "/fly" + b + " - Lists flight commands.");
      	        p.sendMessage(g + "/fly t" + b + " - Toggles flight.");
      	        p.sendMessage(g + "/fly on" + b + " - Enables flight.");
      	        p.sendMessage(g + "/fly off" + b + " - Disables flight.");
      	        p.sendMessage(g + "/fly t (username)" + b + " - Toggles flight for player.");
      	        p.sendMessage(g + "/fly on (username)" + b + " - Enables flight for player.");
      	        p.sendMessage(g + "/fly off (username)" + b + " - Disables flight for player.");
    		}
    		if(!(p.hasPermission("fly.list"))) {
    			noPerms(sender);
    		}
    	}
    	if (args.length == 1) {
    		GameMode gamemode = p.getGameMode();
    		if (gamemode == GameMode.CREATIVE) {
    			p.sendMessage(ChatColor.RED + "You are in Creative mode.");
    		}
    		if (!(gamemode == GameMode.CREATIVE)) {
    		if (args[0].equalsIgnoreCase("on")) {
    			if(p.hasPermission("fly.enable")) {
        			if (p.getAllowFlight() == true) {
        				p.sendMessage(ChatColor.RED + "You are already flying.");
            			}
        			if (p.getAllowFlight() == false) {
        				p.setAllowFlight(true);
        				p.setFlying(true);
        				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully enabled.");
            			}
    			}
    			if (!(p.hasPermission("fly.enable"))) {
    				noPerms(sender);
    			}
    		}
    		if (args[0].equalsIgnoreCase("off")) {
    			if (p.hasPermission("fly.disable")) {
        			if (p.getAllowFlight() == false) {
        				p.sendMessage(ChatColor.RED + "You are already not flying.");
            			}
        			if (p.getAllowFlight() == true) {
        				p.setAllowFlight(false);
        				p.setFlying(false);
        				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully disabled.");
            			}
    			}
    			if (!(p.hasPermission("fly.disable"))) {
    				noPerms(sender);
    			}
    		}
    		}
    	}
    	if (args.length == 2) {
			Player target = Bukkit.getPlayerExact(args[1]);
			GameMode gamemode = target.getGameMode();
			if (gamemode == GameMode.CREATIVE) {
				p.sendMessage(ChatColor.RED + "Player is in Creative mode.");
			}
			if (!(gamemode == GameMode.CREATIVE)) {
		    if (args[0].equalsIgnoreCase("t") || (args[0].equalsIgnoreCase("toggle"))) {
		    	if(p.hasPermission("fly.toggle.other")) {
		    		String displayname = target.getDisplayName();
	    			if (target.getAllowFlight() == false) {
	    				target.setAllowFlight(true);
	    				target.setFlying(true);
	    				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully enabled for "+displayname+".");
	    			} else if (target.getAllowFlight() == true) {
	    				target.setAllowFlight(false);
	    				target.setFlying(false);
	    				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully disabled for "+displayname+".");
	    			}
	    		
		    	}
		    	if (!(p.hasPermission("fly.toggle.other"))) {
		    		noPerms(sender);
		    	}
		    }
    		if (args[0].equalsIgnoreCase("on")) {
    			if(p.hasPermission("fly.enable.other")) {    				
    			String displayname = target.getDisplayName();
    			if (target == null) {
    				p.sendMessage(ChatColor.RED + "Player is not online.");
    			}
    			if (!(target == null)) {
    			if (target.getAllowFlight() == true) {
    				p.sendMessage(ChatColor.RED + "Player is already flying.");
    			}
    			if (target.getAllowFlight() == false) {
				target.setAllowFlight(true);
				target.setFlying(true);
				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully enabled for "+displayname+".");
    			}
    			}
    		}
    			if (!(p.hasPermission("fly.enable.other"))) {
    				noPerms(sender);
    			}
    			}
    		if (args[0].equalsIgnoreCase("off")) {
    			if(p.hasPermission("fly.disable.other")) {
    			String displayname = target.getDisplayName();
    			if (target == null) {
    				p.sendMessage(ChatColor.RED + "Player is not online.");
    			}
    			if (!(target == null)) {
    			if (target.getAllowFlight() == false) {
    				p.sendMessage(ChatColor.RED + "Player is already not flying.");
    			}
    			if (target.getAllowFlight() == true) {
				target.setAllowFlight(false);
				target.setFlying(false);
				p.sendMessage(ChatColor.DARK_GREEN + "Flight successfully disabled for "+displayname+".");
    			}
    			}
    			}
    			}
    			if (!(p.hasPermission("fly.disable.other"))) {
    				noPerms(sender);
    			}
    		}
    	}
    }
  }
    return true;
  }
  public static int getAmount(Player player, int id, byte c)
  {
          PlayerInventory inventory = player.getInventory();
          ItemStack[] items = inventory.getContents();
          int j = 0;
          for (ItemStack item : items)
          {
              if ((item != null) && (item.getTypeId() == id) && item.getDurability() == c && (item.getAmount() > 0))
              {
                  j += item.getAmount();
              }
          }
          return j;
      }
  public static String buildMessage(String[] input, int startArg) {
	  StringBuilder sb = new StringBuilder(input[startArg]);
	  for(int i = ++startArg; i < input.length; i++) {
	    sb.append(' ').append(input[i]);
	  }
	  return sb.toString();
	}
  public void noPerms(CommandSender sender) {
			sender.sendMessage(ChatColor.RED + "Insufficient permissions.");	
  }
}