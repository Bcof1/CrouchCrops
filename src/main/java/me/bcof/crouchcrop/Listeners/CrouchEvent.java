package me.bcof.crouchcrop.Listeners;

import me.bcof.crouchcrop.CrouchCrop;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class CrouchEvent implements Listener {
    private CrouchCrop main;

    public CrouchEvent(CrouchCrop main) {
        this.main = main;
    }

    @EventHandler
    public void onCrouch(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        Block block = player.getLocation().add(0,1,0).getBlock(); // gets the actual block the player is standing on

        String message = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Hotbar-message")); // message for the hotbar
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message)); // puts message above hotbar using bungeecord api

      if(block.getType() != Material.AIR){
          if(block.getBlockData() instanceof Ageable){
              Ageable crop = (Ageable) block.getBlockData();
              if(crop.getAge() < crop.getMaximumAge()){
                  crop.setAge(crop.getAge() + 1);
                  block.setBlockData(crop);
              }
          }
      }
    }
}
