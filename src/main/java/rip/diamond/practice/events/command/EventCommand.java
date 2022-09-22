package rip.diamond.practice.events.command;

import org.bukkit.entity.Player;
import rip.diamond.practice.Language;
import rip.diamond.practice.events.EdenEvent;
import rip.diamond.practice.events.EventState;
import rip.diamond.practice.events.menu.EventCreateMenu;
import rip.diamond.practice.util.Common;
import rip.diamond.practice.util.command.Command;
import rip.diamond.practice.util.command.CommandArgs;
import rip.diamond.practice.util.command.argument.CommandArguments;

public class EventCommand extends Command {
    @CommandArgs(name = "event")
    public void execute(CommandArguments command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        EdenEvent event = EdenEvent.getOnGoingEvent();

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("create")) {
                if (!player.hasPermission("eden.command.event.create")) {
                    Language.NO_PERMISSION.sendMessage(player);
                    return;
                }
                if (event != null) {
                    Common.sendMessage(player, "&c現時有一個正在進行的活動!");
                    return;
                }
                new EventCreateMenu().openMenu(player);
                return;
            } else if (args[0].equalsIgnoreCase("forcestart")) {
                if (!player.hasPermission("eden.command.event.forcestart")) {
                    Language.NO_PERMISSION.sendMessage(player);
                    return;
                }
                if (event == null) {
                    Common.sendMessage(player, "&c現時並沒有一個正在進行的活動!");
                    return;
                }
                if (event.getState() != EventState.WAITING) {
                    Common.sendMessage(player, "&c活動已經開始!");
                    return;
                }
                event.start();
                return;
            } else if (args[0].equalsIgnoreCase("status")) {
                if (event == null) {
                    Common.sendMessage(player, "&c現時並沒有一個正在進行的活動!");
                    return;
                }
                if (event.getStatus(player) == null) {
                    Common.sendMessage(player, "&c這個活動沒有狀態可以查看!");
                    return;
                }

                Common.sendMessage(player, event.getStatus(player));
                return;
            }
        }
    }
}
