package com.contattos.wmissao.inventories;

import com.contattos.wcash.database.MethodBlock;
import com.contattos.wmissao.api.decimal;
import com.contattos.wmissao.api.newItens;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

import static com.contattos.wmissao.Main.getChat;
import static com.contattos.wmissao.api.decimal.newProgress;

public class InventoryMission implements Listener {

    public static void open(Player p){
        Inventory inv = Bukkit.createInventory(null, 6*9, "Missões");

        ItemStack status = newItens.add(Material.DIAMOND_PICKAXE, "§eMissões",
                new String[]{
                        "",
                        "§fBlocos quebrados: §7❒" + decimal.formatSimbolo(MethodBlock.get(p.getName())),
                        "",
                        "§7Quebre blocos na mineração para completar",
                        "§7as missões e ganhe recompensas exclusivas.",
                        "",
                        "§b/mina.",
                });

        ItemStack top1;
        ItemStack top2;
        ItemStack top3;
        ItemStack top4;
        ItemStack top5;

        if (MethodBlock.getTop().size() == 0 || MethodBlock.getTop().get(1) == null){
            top1 = newItens.add(Material.SKULL_ITEM, "§8#§f1 §7Ninguém",
                    new String[]{"§fQuantia: §7❒0"});
        } else {
            top1 = newItens.add(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) top1.getItemMeta();
            meta.setOwner(MethodBlock.getTop().get(0));
            meta.setDisplayName("§8#§f1 §7" + MethodBlock.getTop().get(0));
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§fQuantia: " + MethodBlock.getTop().get(1));

            meta.setLore(lore);
            top1.setItemMeta(meta);
        }
        if (MethodBlock.getTop().size() <= 2 || MethodBlock.getTop().get(3) == null){
            top2 = newItens.add(Material.SKULL_ITEM, "§8#§f2 §7Ninguém",
                    new String[]{"§fQuantia: §7❒0"});
        } else {
            top2 = newItens.add(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) top2.getItemMeta();
            meta.setOwner(MethodBlock.getTop().get(2));
            meta.setDisplayName("§8#§f2 §7" + MethodBlock.getTop().get(2));
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§fQuantia: " + MethodBlock.getTop().get(3));

            meta.setLore(lore);
            top2.setItemMeta(meta);
        }
        if (MethodBlock.getTop().size() <= 4 || MethodBlock.getTop().get(5) == null){
            top3 = newItens.add(Material.SKULL_ITEM, "§8#§f3 §7Ninguém",
                    new String[]{"§fQuantia: §7❒0"});
        } else {
            top3 = newItens.add(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) top3.getItemMeta();
            meta.setOwner(MethodBlock.getTop().get(4));
            meta.setDisplayName("§8#§f3 §7" + MethodBlock.getTop().get(4));
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§fQuantia: " + MethodBlock.getTop().get(5));

            meta.setLore(lore);
            top3.setItemMeta(meta);
        }
        if (MethodBlock.getTop().size() <= 6 || MethodBlock.getTop().get(7) == null){
            top4 = newItens.add(Material.SKULL_ITEM, "§8#§f4 §7Ninguém",
                    new String[]{"§fQuantia: §7❒0"});
        } else {
            String name = MethodBlock.getTop().get(6);
            top4 = newItens.add(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) top4.getItemMeta();
            meta.setOwner(MethodBlock.getTop().get(6));
            meta.setDisplayName("§8#§f4 §7" + MethodBlock.getTop().get(6));
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§fQuantia: " + MethodBlock.getTop().get(7));

            meta.setLore(lore);
            top4.setItemMeta(meta);
        }
        if (MethodBlock.getTop().size() <= 8 || MethodBlock.getTop().get(9) == null){
            top5 = newItens.add(Material.SKULL_ITEM, "§8#§f5 §7Ninguém",
                    new String[]{"§fQuantia: §7❒0"});
        } else {

            top5 = newItens.add(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) top5.getItemMeta();
            meta.setOwner(MethodBlock.getTop().get(0));
            meta.setDisplayName("§8#§f5 §7" + MethodBlock.getTop().get(8));
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§fQuantia: " + MethodBlock.getTop().get(9));

            meta.setLore(lore);
            top5.setItemMeta(meta);
        }

        ItemStack missao1 = null;

        boolean bconter = MethodBlock.contains(p.getName());
        double blocos = MethodBlock.get(p.getName());
        //PlayerData playerData = p.getPlayerData();


        int valorm1 = 105;
        String progresso = newProgress(blocos, valorm1, 10);

        if (bconter && blocos < valorm1){
            missao1 = newItens.add(Material.INK_SACK, "§eMissão §8#1", 1, 14,
                    new String[]{
                            "§7Quebre §f" + decimal.formatSimbolo(valorm1) + " §7blocos para concluir a missão.",
                            "",
                            " §fStatus: §6Em andamento.",
                            " §fProgresso: " + progresso + " §7❒" +
                                    decimal.formatSimbolo(blocos) + "/" + decimal.formatSimbolo(valorm1),
                            "",
                            " §eRecompensas:",
                            "§e│ §71x Cheque de Cash §6✪10K§a",
                            "§e│ §71x LuckyBlock",
                            "",
                            "§cVocê não os tem requisitos."
                    });
        }
        /*if (){
            missao1 = newItens.add(Material.INK_SACK, "§eMissão §8#1", 1, 10,
                    new String[]{
                            "§7Quebre §f" + decimal.formatSimbolo(valorm1) + " §7blocos para concluir a missão.",
                            "",
                            "§fStatus: §aConcluído.",
                            "",
                            "§aRecompensa já foi coletada.",
                    });
        }*/
        if (bconter && blocos >= valorm1){
            missao1 = newItens.add(Material.INK_SACK, "§eMissão §8#1", 1, 14,
                    new String[]{
                            "§7Quebre §f" + decimal.formatSimbolo(valorm1) + " §7blocos para concluir a missão.",
                            "",
                            " §fStatus: §aConcluído.",
                            " §fProgresso: " + progresso + " §7❒" +
                                    decimal.formatSimbolo(valorm1) + "/" + decimal.formatSimbolo(valorm1),
                            "",
                            " §eRecompensas:",
                            "§e│ §71x Cheque de Cash §6✪10K§a",
                            "§e│ §71x LuckyBlock",
                            "",
                            "§aClique para coletar.",
                    });
        }

        inv.setItem(29, missao1);
        inv.setItem(4, status);
        inv.setItem(11, top1);
        inv.setItem(12, top2);
        inv.setItem(13, top3);
        inv.setItem(14, top4);
        inv.setItem(15, top5);

        p.openInventory(inv);
    }
}
