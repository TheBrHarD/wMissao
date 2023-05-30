package com.contattos.wmissao.api;

import com.contattos.wcash.events.EventShop;
import com.contattos.wmissao.Main;
import com.contattos.wmissao.commands.Mission;
import com.contattos.wmissao.events.EventMission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class register {

    public register(){
        Comandos("missoes", new Mission());
        Eventos(new EventMission());
    }

    void Comandos(String comando, CommandExecutor classe){
        Main pl = Main.getPlugin();
        pl.getCommand(comando).setExecutor(classe);
    }

    void Eventos(Listener classe){
        Main pl = Main.getPlugin();
        Bukkit.getPluginManager().registerEvents(classe, pl);
    }
}
