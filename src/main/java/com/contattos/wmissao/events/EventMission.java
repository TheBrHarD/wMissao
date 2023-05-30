package com.contattos.wmissao.events;

import com.contattos.wcash.api.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

import static com.contattos.wmissao.Main.getChat;

public class EventMission implements Listener {

    HashMap<String, ItemInfo> itemInfo = new HashMap<>();

    @EventHandler
    public void onMission(InventoryClickEvent e){
        if(!(e.getWhoClicked() instanceof Player p)){
            return;
        }

        itemInfo.put("§eMissão §8#1", new ItemInfo("cash add " + p.getName() + " 1000"));

        if (e.getInventory().getTitle().equalsIgnoreCase("Missões")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null) return;
            if (e.getCurrentItem().getType() == Material.AIR) return;
            if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

            ItemInfo item = itemInfo.get(e.getCurrentItem().getItemMeta().getDisplayName());
            String msgFull = "§cSeu inventário está cheio!";



            if (e.getRawSlot() == e.getSlot() && e.getInventory().getTitle()
                    .equalsIgnoreCase("Missões")) {
                switch (e.getSlot()) {
                    case 29, 30 -> {
                        if (isInventoryFull(p)) {
                            e.setCancelled(true);
                            p.closeInventory();
                            ActionBar.sendAction(p.getPlayer(), msgFull);
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1f, 1f);
                            return;
                        }

                        String nome = e.getCurrentItem().getItemMeta().getDisplayName();

                        if (nome != null && nome.contentEquals("§eMissão §8#1")) {
                            String recompensa = item.getRewardCommand();
                            if (recompensa == null) return;
                            p.sendMessage("§aVocê coletou a " +
                                    e.getCurrentItem().getItemMeta().getDisplayName() +
                                    " §acom sucesso.");
                            p.sendMessage("§7você é lindo ");
                            p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), recompensa);

                        }
                    }
                }
            }

        }

    }
    public boolean isInventoryFull(Player player) {
        Inventory inv = player.getInventory();
        int emptySlots = 0;
        for (ItemStack item : inv.getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                emptySlots++;
            }
        }
        return emptySlots == 0;
    }
    public static class ItemInfo {
        public String rewardCommand;

        public ItemInfo(String rewardCommand) {
            this.rewardCommand = rewardCommand;
        }

        public String getRewardCommand() {
            return rewardCommand;
        }

    }
}
