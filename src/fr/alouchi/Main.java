package fr.alouchi;

import fr.alouchi.command.InvseeCommand;
import fr.alouchi.command.LimitArmorCommand;
import fr.alouchi.event.EchantItem;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        loadCommand();
        loadEvent();

        getLogger().info("Limit Armor - Alouchi");
    }

    @Override
    public void onDisable() {
        getLogger().info("Limit Armor - Alouchi");
    }

    public static Main getInstance() {
        return instance;
    }

    private void loadCommand() {
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("limitarmor").setExecutor(new LimitArmorCommand());
    }

    private void loadEvent() {
        getServer().getPluginManager().registerEvents(new EchantItem(), this);
    }
}