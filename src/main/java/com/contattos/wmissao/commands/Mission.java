package com.contattos.wmissao.commands;

import com.contattos.wmissao.inventories.InventoryMission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Mission implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
        if (cmd.getName().equalsIgnoreCase("missoes")){
            if (!(sender instanceof Player)){
                sender.sendMessage("§cApenas jogadores podem utilizar este comando!");
                return true;
            }

            if(args.length == 0){
                Player p = (Player) sender;
                InventoryMission.open(p);
                return true;
            }

        }
        return false;
    }
}
