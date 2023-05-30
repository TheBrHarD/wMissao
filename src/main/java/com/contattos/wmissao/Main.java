package com.contattos.wmissao;
import com.contattos.wcash.database.MethodBlock;
import com.contattos.wcash.database.MethodCash;
import com.contattos.wmissao.api.register;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    private static Chat chat = null;

    @Override
    public void onEnable() {
        getServer().getLogger().info("§aPlugin inicializado com sucesso.");
        new register();
        setupChat();
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("§aPlugin foi desligado.");
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static Chat getChat() {
        return chat;
    }

    public static Main getPlugin(){
        return getPlugin(Main.class);
    }

}
