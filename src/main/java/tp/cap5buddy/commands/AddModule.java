package tp.cap5buddy.commands;

import tp.cap5buddy.modules.Module;
import tp.cap5buddy.storage.ModuleStorage;

public class AddModule extends Command {

    public static String execute(String name, String link) {
        Module mod = new Module(name, link);
        ModuleStorage.storeModule(mod);
        return mod.print();
    }
}
