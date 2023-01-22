package rip.diamond.practice.arenas.menu;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import rip.diamond.practice.Language;
import rip.diamond.practice.arenas.Arena;
import rip.diamond.practice.arenas.menu.button.impl.ArenaAPositionButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaAllowedKitsButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaBPositionButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaBuildMaxButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaCloneButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaDeleteButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaDisplayNameButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaMaxPositionButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaMinPositionButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaPortalProtectionRadiusButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaSaveButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaToggleButton;
import rip.diamond.practice.arenas.menu.button.impl.ArenaYLimitButton;
import rip.diamond.practice.util.menu.Button;
import rip.diamond.practice.util.menu.Menu;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ArenaEditMenu extends Menu {

    private final Arena arena;

    @Override
    public String getTitle(Player player) {
        return Language.ARENA_EDIT_MENU_TITLE.toString(arena.getName());
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        final Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(0, new ArenaCloneButton(arena));
        buttons.put(2, new ArenaToggleButton(arena));
        buttons.put(4, new ArenaDisplayNameButton(arena));
        buttons.put(6, new ArenaSaveButton(arena));
        buttons.put(8, new ArenaDeleteButton(arena));

        buttons.put(18, new ArenaAPositionButton(arena));
        buttons.put(19, new ArenaBPositionButton(arena));
        buttons.put(20, new ArenaMinPositionButton(arena));
        buttons.put(21, new ArenaMaxPositionButton(arena));
        buttons.put(22, new ArenaBuildMaxButton(arena));
        buttons.put(23, new ArenaYLimitButton(arena));
        buttons.put(24, new ArenaPortalProtectionRadiusButton(arena));
        buttons.put(25, new ArenaAllowedKitsButton(arena, this));

        return buttons;
    }
}
