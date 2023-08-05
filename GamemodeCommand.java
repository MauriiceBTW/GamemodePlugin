package me.maurice.gamemodeplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GamemodeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (label.equalsIgnoreCase("gm")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage("This Command can only be used ingame!");
                return true;
            }

            Player player = (Player) sender;

            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("0")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aYour gamemode was changed to Survival!");
                }
                else if (args[0].equalsIgnoreCase("1")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§aYour gamemode was changed to Creative!");
                }
                else if (args[0].equalsIgnoreCase("2")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("§aYour gamemode was changed to Adventure!");
                }
                else if (args[0].equalsIgnoreCase("3")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("§aYour gamemode was changed to Spectator!");
                }
                else {
                    player.sendMessage("§cGamemode not found!");
                }

            }
            else if (args.length == 2) {

                Player target = Bukkit.getPlayer(args[1]);

                if (target == null) {
                    player.sendMessage("§cPlayer not found!");
                    return true;
                }

                if (args[0].equalsIgnoreCase("0")) {
                    target.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§a" + target.getName() + "'s gamemode was changed to Survival!");
                }
                else if (args[0].equalsIgnoreCase("1")) {
                    target.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§a" + target.getName() + "'s gamemode was changed to Creative!");
                }
                else if (args[0].equalsIgnoreCase("2")) {
                    target.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("§a" + target.getName() + "'s gamemode was changed to Adventure!");
                }
                else if (args[0].equalsIgnoreCase("3")) {
                    target.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("§a" + target.getName() + "'s gamemode was changed to Spectator!");
                }
                else {
                    player.sendMessage("§cGamemode not found!");
                }
            }

        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
       
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) return list;
        if (args.length == 1) {
            for (int i = 0; i < 4; i++)
                list.add("" + i);
        }

        ArrayList<String> completerList = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith(args[0]))
                completerList.add(s);
        }

        return completerList;
    }
}
